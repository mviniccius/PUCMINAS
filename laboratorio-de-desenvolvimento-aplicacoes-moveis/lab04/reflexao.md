# Reflexão — Lab 04: Transparência em Sistemas Distribuídos

## 1. Síntese — Tipo de transparência mais difícil de implementar

O tipo mais difícil é a **transparência de relocação**. Diferente da migração (Tarefa 3), onde o serviço é movido com o processo parado, a relocação exige continuidade *enquanto o cliente ainda usa o recurso*. Isso exige buffers de mensagens e uma máquina de estados explícita (`MIGRATING -> RECONNECTING -> CONNECTED`), como visto em `relocacao_websocket.py`. Qualquer falha nessa janela de transição pode causar perda permanente de dados. É essa complexidade temporal — garantir consistência em tempo real enquanto o usuário ainda interage — que torna a relocação inerentemente mais difícil que os demais tipos.

## 2. Trade-offs — Quando esconder a distribuição é prejudicial

Em um app de e-commerce, ocultar completamente erros de rede — retornando `None` silenciosamente como no `anti_pattern.py` da Tarefa 7 — faz o usuário adicionar itens ao carrinho sem perceber que a operação falhou. Ao finalizar a compra, o carrinho está vazio. Uma mensagem de erro explícita ("Não foi possível adicionar. Tente novamente.") seria muito mais útil. A transparência excessiva impede o usuário de distinguir um sistema funcionando de um sistema falhando silenciosamente, tornando a experiência menos resiliente do que seria com falhas bem comunicadas.

## 3. Conexão com Labs anteriores — async/await e quebra deliberada de transparência

No Lab 02, `async/await` foi estudado como forma de gerenciar operações concorrentes sem bloquear a thread. A conexão com a Tarefa 7 é direta: usar `async` em `fetch_user_remote()` é uma quebra **intencional** de transparência — a palavra-chave `await` sinaliza ao chamador que aquela operação pode suspender, demorar ou falhar por razões de rede. O que no Lab 02 era ganho de performance, aqui é também um **contrato explícito**: o programador é forçado a lidar com a realidade distribuída, tornando o código mais correto e resiliente, ainda que menos transparente.

## 4. GIL e multiprocessing

O GIL (*Global Interpreter Lock*) é um mutex interno do CPython que impede duas threads de executarem bytecode Python ao mesmo tempo. Com `threading`, race conditions podem não se manifestar de forma reproduzível, pois o GIL serializa as operações — tornando a demonstração imprecisa. A Tarefa 6 usa `multiprocessing` porque cada processo tem seu próprio espaço de memória e GIL: dois processos leem o saldo no Redis simultaneamente, calculam independentemente e gravam valores inconsistentes, criando a race condition de forma real e reproduzível. Esse cenário reflete com fidelidade ambientes de produção com múltiplas máquinas, onde o lock distribuído via `SET NX EX` do Redis é a solução correta.

## 5. Desafio técnico encontrado

O principal desafio foi configurar as credenciais do Redis Cloud no arquivo `.env`. Ao executar `teste_conexao_redis.py` pela primeira vez, a conexão falhou com `AuthenticationError`. O diagnóstico mostrou que a senha copiada do painel continha caracteres especiais (`@`, `#`, `!`) que o Python-dotenv interpretava incorretamente quando o valor não estava entre aspas. A solução foi envolver o valor da senha com aspas duplas no `.env`:

```dotenv
REDIS_PASSWORD="minha@senha#especial!"
```

Após essa correção, o `ping()` foi bem-sucedido e as demais tarefas funcionaram normalmente. O episódio reforçou que variáveis de ambiente com caracteres especiais exigem atenção ao formato do `.env`, e que nunca se deve colocar credenciais diretamente no código-fonte — a separação entre configuração e código é essencial em qualquer sistema distribuído.

---

## Questões adicionais por tarefa

### Tarefa 1 — Transparência de Acesso
- O código cliente **não precisou mudar** entre `CONFIG_BACKEND=local` e `CONFIG_BACKEND=http`. Apenas a variável de ambiente foi alterada, e a função `get_repo_from_env()` selecionou automaticamente a implementação adequada.
- `ConfigRepository` é a **abstração/contrato** (Strategy interface); `LocalConfig` e `RemoteConfig` são as **estratégias concretas**; `get_repo_from_env()` é a **factory** que seleciona a estratégia com base no ambiente.

### Tarefa 2 — Transparência de Localização
- Para resolução **dinâmica**, o `ServiceLocator` precisaria consultar um sistema externo a cada chamada (ou com TTL curto), como chamadas HTTP ao Consul, etcd ou ao DNS do Kubernetes, ao invés de carregar o registry uma única vez na inicialização.
- Duas tecnologias de produção como service registry: **etcd** (usado internamente pelo Kubernetes) e **AWS Cloud Map** (serviço gerenciado de descoberta da AWS).

### Tarefa 3 — Transparência de Migração
- A persistência da sessão entre dois processos separados demonstra o princípio de **stateless application + stateful store**: a lógica computacional é separada do estado, que reside em um store externo (Redis). Qualquer instância pode assumir o tráfego sem perder contexto.
- Uma variável global em memória não resolve o problema nem mesmo na mesma máquina porque cada réplica da aplicação tem seu próprio espaço de memória. Múltiplas réplicas não compartilham variáveis Python — cada processo enxerga apenas seu próprio `session_store`.

### Tarefa 4 — Transparência de Relocação
1. **Migração** ocorre quando o serviço é movido entre instâncias com uma janela de indisponibilidade (processo A encerra, processo B sobe). **Relocação** é tecnicamente mais difícil porque o recurso se move *enquanto ainda está sendo usado* — não há janela de downtime aceitável.
2. O buffer **não garante** semântica *exactly-once*. Entrega duplicada pode ocorrer se a mensagem for enviada antes da falha e reenviada do buffer após a reconexão. Perda pode ocorrer se o processo travar antes de adicionar ao buffer.
3. Modelar estados explicitamente com `Enum` permite transições validadas, facilita logging e debugging, e torna o código autodocumentado. Uma flag booleana `is_relocating` não captura o estado intermediário `RECONNECTING` e torna o código mais propenso a erros lógicos.
4. **Kubernetes Pod rescheduling**: quando um Pod é movido para outro nó, os clientes continuam conectados sem perceber — o Service do Kubernetes redireciona o tráfego transparentemente.

### Tarefa 5 — Transparência de Replicação
- O código **não implementa** consistência *read-your-writes*. Para garantir essa propriedade, após uma escrita o cliente deveria direcionar suas leituras subsequentes para o master (ou aguardar a propagação para as réplicas) durante um intervalo de tempo.
- A versão anterior com recursão (`return self.query(sql, write=True)`) é perigosa porque pode causar **stack overflow** em caso de falha persistente do master — cada chamada recursiva adiciona um frame à pilha. A versão atual usa fallback direto, sem recursão.

### Tarefa 6 — Transparência de Concorrência
- `multiprocessing` é usado porque o GIL impede race conditions reproduzíveis com `threading`.
- O `distributed_lock` usa o Redis Cloud (externo aos dois processos), enquanto `threading.Lock()` é interno ao processo — não funciona para sincronização entre processos distintos ou máquinas diferentes.
- Se o Processo-A travar dentro da seção crítica antes do `finally`, o TTL (`ex`) fará o Redis expirar automaticamente o lock após o tempo configurado, evitando deadlock. O risco residual é que, se o TTL for menor que o tempo da operação crítica, o lock pode expirar antes de o processo terminar, permitindo que outro processo entre na seção crítica simultaneamente.

### Tarefa 7 — Transparência de Falha (bônus)
- O `anti_pattern.py` viola a **1ª falácia da computação distribuída** de Peter Deutsch: *"A rede é confiável"* (*"The network is reliable"*). A função `get_user()` parece uma chamada local, mas pode falhar silenciosamente por latência ou indisponibilidade de rede, sem que o chamador tenha qualquer indicação.
- `async/await` quebra deliberadamente a transparência porque força o programador a reconhecer que a operação pode suspender, pode ter latência variável e pode falhar. Neste contexto, essa é a decisão correta: **transparência excessiva mascara propriedades fundamentais de sistemas distribuídos** (latência, falhas parciais) que o código cliente precisa estar preparado para lidar.
