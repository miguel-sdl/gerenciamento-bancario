# Gerenciamento Bancário no Terminal

## Descrição
Este é um projeto simples de gerenciamento bancário em `Java`. Essa aplicação permite o usuário digitar numeros para navegar por menus que oferecem diversas funcionalidades de gerenciamento de contas bancárias. O objetivo deste projeto é colocar em prática e consolidar os conhecimentos adquiridos de `Java` e `Git`.

## Funcionalidades
A aplicação fornece ao usuário instruções para acessar diversas funcionalidades como:


- **Consulta de Informações:** Permite consultar informações do usuário, das contas e o saldo das contas.
- **Criação de Contas:** Permite criar contas do tipo **Conta-Corrente** e **Conta-Poupança**, o tipo de conta altera o comportamento de algumas operações.
- **Operações Bancárias:** Incluem operações de saque, depósito e transferência entre contas.


## Estrutura de Diretórios
Essa é a estrutura de diretórios do projeto:
- **src/**: Contém os arquivos fonte `.java`, dividídos nos seguintes pacotes:
    - **aplicacao/**: Contém a classe `App` com o método `main` que executa o programa.
    - **dominio/**: Contém classes como `Cliente` e `Conta`.
    - **servico/**: Contém classes utilitárias como `MostrarInformacoes` e `Transacao`.
- **bin/**: Contém os arquivos compilados `.class`.

## Como Executar
Este projeto utilizou o **Java JDK 21**, aqui estão as intruções para a execução do projeto:
1. Clone o Repositório:
``` sh
git clone https://github.com/miguel-sdl/gerenciamento-bancario.git
```
2. Navegue até o diretótio do projeto:
``` sh
cd gerenciamento-bancario
```
3. Compile o projeto:
``` sh
javac -d bin @sources.txt
```
4. Execute a aplicação:
```` sh
java -cp bin gerenciamentobancario.aplicacao.App
````
##