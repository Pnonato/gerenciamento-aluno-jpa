# Gerenciamento de Alunos com JPA

Projeto em Java utilizando JPA (Hibernate) e banco de dados H2 para gerenciamento de alunos via terminal.

## Participantes

Pedro Marrara Barros Nonato  
Cauã Valim De Sousa Olivio  

## Funcionalidades

O sistema permite realizar as seguintes operações:

- Cadastrar aluno  
- Listar todos os alunos  
- Buscar aluno pelo nome  
- Atualizar dados do aluno  
- Remover aluno  
- Menu interativo no terminal  

## Tecnologias Utilizadas

- Java 21  
- Maven  
- Hibernate (JPA)  
- H2 Database  

## Como Executar o Projeto

Existem duas formas de executar o projeto: pelo IntelliJ IDEA ou pelo terminal.

---

## Opção 1 — Executar pelo IntelliJ IDEA

1. Abra o IntelliJ IDEA  
2. Clique em **File → Open** e selecione a pasta do projeto  
3. Aguarde o Maven baixar as dependências automaticamente  
4. Abra a classe `Main.java`  
5. Clique no botão **Run ▶** ao lado do método `main`  

---

## Opção 2 — Executar pelo Terminal (Maven)

### Requisitos

- Java 21 instalado  
- Maven instalado e configurado no PATH  

### 1. Clonar o repositório

```bash
git clone https://github.com/Pnonato/gerenciamento-aluno-jpa.git
cd gerenciamento-aluno-jpa
mvn clean package
mvn exec:java
