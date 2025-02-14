# Histórias de Usuário - Sistema de Matrículas

## 1. Aluno realiza matrícula
**Como um** aluno
**Eu quero** me matricular em disciplinas obrigatórias e optativas
**Para que** eu possa garantir minha participação no semestre.

### Critérios de aceitação:
- O aluno deve poder escolher 4 disciplinas obrigatórias e 2 optativas.
- O sistema deve verificar se a disciplina não atingiu o limite de 60 alunos.
- A matrícula deve ser registrada no sistema.
- O sistema deve notificar o Sistema de Cobrança após a inscrição.

---

## 2. Aluno cancela matrícula
**Como um** aluno
**Eu quero** cancelar minha matrícula em uma disciplina
**Para que** eu possa ajustar minha carga horária.

### Critérios de aceitação:
- O aluno pode cancelar uma disciplina antes do prazo limite.
- O sistema deve registrar a alteração e liberar a vaga para outro aluno.

---

## 3. Aluno visualiza disciplinas
**Como um** aluno
**Eu quero** ver as disciplinas disponíveis
**Para que** eu possa planejar minha matrícula.

### Critérios de aceitação:
- O aluno deve visualizar todas as disciplinas do semestre.
- O sistema deve indicar quais disciplinas ainda possuem vagas.

---

## 4. Professor visualiza alunos matriculados
**Como um** professor
**Eu quero** ver a lista de alunos matriculados em minhas disciplinas
**Para que** eu possa me preparar para as aulas.

### Critérios de aceitação:
- O professor deve visualizar a lista de alunos por disciplina.
- O sistema deve garantir que apenas professores autorizados tenham acesso a essa informação.

---

## 5. Secretaria gerencia currículo do semestre
**Como um** funcionário da secretaria
**Eu quero** criar e atualizar as disciplinas de cada semestre
**Para que** os alunos possam se matricular corretamente.

### Critérios de aceitação:
- A secretaria pode adicionar, remover ou editar disciplinas.
- O sistema deve garantir que apenas usuários autorizados realizem essas modificações.

---

## 6. Notificação ao sistema de cobrança
**Como um** sistema de cobrança
**Eu quero** ser notificado sobre matrículas de alunos
**Para que** eu possa processar os pagamentos corretamente.

### Critérios de aceitação:
- Sempre que um aluno se matricular, o sistema deve enviar os dados ao sistema de cobrança.
- O sistema deve garantir a integridade dos dados enviados.