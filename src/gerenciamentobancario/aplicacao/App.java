package gerenciamentobancario.aplicacao;

import java.util.List;
import java.util.Scanner;

import gerenciamentobancario.dominio.Cliente;
import gerenciamentobancario.dominio.Conta;
import gerenciamentobancario.servico.MostrarInformacoes;
import gerenciamentobancario.servico.Transacao;


public class App {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = "------------------------------\n" + 
                "Abaixo está tudo o que pode fazer, escolha algumas das opções digitando o numero correspondente:\n" + 
                "1 - Ver informações do cliente\n" + 
                "2 - Ver informações da sua conta\n" + 
                "3 - Criar conta\n" + 
                "4 - Consultar saldo\n" + 
                "5 - Realizar operações bancarias\n" + 
                "S para sair\n" + 
                "------------------------------";

        Cliente cliente = inicializacao();

        String escolha = "";

        while (!escolha.equalsIgnoreCase("s")) {
            scanner = new Scanner(System.in);

            System.out.println(message);
            escolha = scanner.nextLine();

            switch (escolha.toLowerCase()) {
                case "1":
                    MostrarInformacoes.mostarCliente(cliente);
                break;
                case "2":
                    MostrarInformacoes.mostrarContas(cliente);
                    break;
                case "3":
                    Conta.criarConta(cliente);
                    break;
                case "4":
                    MostrarInformacoes.mostrarSaldo(cliente);
                    break;
                case "5":
                    menuOperaçõesBancarias(cliente);
                    break;

                case "s":
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
                       
        }
        

        scanner.close();
    }


    @SuppressWarnings("resource")
    private static Cliente inicializacao() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite seu nome: ");
        String nomeCliente = scanner.nextLine();
        System.out.print("Digite seu cpf: ");
        String cpf = scanner.nextLine();

        Cliente cliente = new Cliente(nomeCliente, cpf);
        System.out.println("Seja bem-vindo ao nosso banco " + cliente.getNome() + "!!!");

        return cliente;
    }

    @SuppressWarnings("resource")
    private static void menuOperaçõesBancarias(Cliente cliente){
        String msgOperacoesBancarias = "------------------------------\n" + 
                        "Esse é o nosso setor de operações, abaixo está tudo o que ser feito aqui:\n" +
                        "1 - Sacar\n" + 
                        "2 - Depositar\n" +
                        "3 - Realizar Tranferencias entre contas\n" + 
                        "S para sair\n" +
                        "------------------------------";


        Scanner scanner = new Scanner(System.in);
        String escolha = "";
        List<Conta> contasDoCliente = cliente.getConta();

        
        if (contasDoCliente.isEmpty()) {
            System.out.println("Você deve abrir uma conta para acessar esses serviços");
            return;
        }

        while (!escolha.equalsIgnoreCase("s")) {
            System.out.println(msgOperacoesBancarias);
            escolha = scanner.nextLine();

            switch (escolha) {
                case "1":
                    Transacao.saque(contasDoCliente);
                    break;
                case "2" :
                    Transacao.deposito(contasDoCliente);
                    break;
                case "3" :
                    Transacao.transferencia(contasDoCliente);
                    break;
                default:
                    break;
            }
        } 
    }
}