# 🧾 Histórias de Usuário e Critérios de Aceitação

## 1️⃣ Cadastro e Login

### História 1: Cadastro de Cliente
**Como cliente**, quero me cadastrar no sistema informando meus dados pessoais, **para que eu possa acessar e utilizar o serviço de aluguel de carros**.

#### ✅ Critérios de Aceitação:
- O cliente deve fornecer **Nome, CPF, RG, Endereço, Profissão** e **Dados de Renda** (até 3 fontes).
- O sistema deve **validar CPF e RG** para evitar duplicatas.
- O cliente deve receber um **e-mail de confirmação** para ativar a conta.
- O **cadastro só será concluído após a ativação do e-mail**.

---

### História 2: Login no Sistema
**Como cliente**, quero fazer login no sistema com meu e-mail e senha, **para que eu possa acessar meus dados e realizar aluguéis**.

#### ✅ Critérios de Aceitação:
- O sistema deve permitir login apenas com **e-mail e senha corretos**.
- O sistema deve exibir uma **mensagem de erro** caso o login falhe.
- O sistema deve **bloquear a conta após 5 tentativas** de login incorretas.
- Deve existir uma opção de **recuperação de senha via e-mail**.

---

## 2️⃣ Gerenciamento de Pedidos

### História 3: Criar Pedido de Aluguel
**Como cliente**, quero criar um pedido de aluguel de carro informando o período desejado e o modelo do carro, **para que eu possa alugar um veículo conforme minha necessidade**.

#### ✅ Critérios de Aceitação:
- O cliente deve selecionar **modelo, ano e período de aluguel**.
- O sistema deve verificar se há **disponibilidade para o período solicitado**.
- O sistema deve exibir um **resumo do pedido antes da confirmação**.
- O pedido deve ser salvo no sistema com o status **"Pendente"**.

---

### História 4: Consultar Pedidos
**Como cliente**, quero visualizar meus pedidos de aluguel em andamento, **para que eu possa acompanhar o status e gerenciar minhas reservas**.

#### ✅ Critérios de Aceitação:
- O cliente deve visualizar uma **lista de seus pedidos com status atualizado**.
- O sistema deve permitir **filtrar pedidos por status** (Pendente, Aprovado, Cancelado).
- O sistema deve exibir **detalhes do pedido ao clicar** em um item da lista.

---

### História 5: Cancelar Pedido de Aluguel
**Como cliente**, quero cancelar um pedido de aluguel antes da confirmação, **para evitar cobranças indevidas caso eu mude de ideia**.

#### ✅ Critérios de Aceitação:
- O cliente deve conseguir cancelar o pedido apenas se o status for **"Pendente"**.
- O sistema deve exibir um **alerta pedindo confirmação do cancelamento**.
- O pedido deve ser marcado como **"Cancelado"** e não pode ser modificado posteriormente.

---

## 3️⃣ Gestão dos Automóveis

### História 6: Listar Carros Disponíveis
**Como cliente**, quero visualizar uma lista de carros disponíveis para aluguel, **para que eu possa escolher um modelo adequado às minhas necessidades**.

#### ✅ Critérios de Aceitação:
- O sistema deve listar apenas os **carros disponíveis** para aluguel.
- O cliente deve poder **filtrar os carros por modelo, ano e faixa de preço**.
- O sistema deve exibir **imagem, modelo, ano e valor do aluguel**.

---

### História 7: Cadastrar Novo Carro *(Administrador)*
**Como administrador**, quero cadastrar e gerenciar a frota de veículos disponíveis para aluguel, **para garantir que o sistema tenha opções atualizadas**.

#### ✅ Critérios de Aceitação:
- O administrador deve fornecer **modelo, marca, ano, placa e matrícula**.
- O sistema deve **validar se a placa já existe no cadastro**.
- O sistema deve permitir **editar ou remover um veículo**.

---

## 4️⃣ Contratos e Pagamentos

### História 8: Assinar Contrato Digital
**Como cliente**, quero assinar digitalmente o contrato de aluguel, **para formalizar a locação do veículo**.

#### ✅ Critérios de Aceitação:
- O cliente deve **visualizar um contrato digital antes da assinatura**.
- O sistema deve registrar **data e IP da assinatura eletrônica**.
- O contrato deve ser **vinculado ao pedido e armazenado no sistema**.

---

### História 9: Efetuar Pagamento
**Como cliente**, quero pagar o aluguel do carro via cartão de crédito, débito ou boleto, **para garantir flexibilidade no pagamento**.

#### ✅ Critérios de Aceitação:
- O cliente deve escolher entre **cartão de crédito, débito ou boleto**.
- O sistema deve **validar o pagamento antes de confirmar a reserva**.
- O sistema deve atualizar o status do pedido para **"Pago"** após a confirmação do pagamento.

---

## 5️⃣ Segurança e Administração

### História 10: Recuperação de Senha
**Como cliente**, quero recuperar minha senha caso eu esqueça, **para que eu possa continuar acessando minha conta**.

#### ✅ Critérios de Aceitação:
- O cliente deve **inserir seu e-mail** para solicitar a recuperação.
- O sistema deve **enviar um link seguro** para redefinição de senha.
- O **link deve expirar em 30 minutos** por motivos de segurança.
