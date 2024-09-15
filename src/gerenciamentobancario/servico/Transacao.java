package gerenciamentobancario.servico;

import java.util.List;
import java.util.Scanner;

import gerenciamentobancario.dominio.Conta;

@SuppressWarnings("resource")
public class Transacao {

    private static void realizarSaque(Conta conta, double valor) {
        conta.sacar(valor);
    }

    private static void realizarDeposito(Conta conta, double valor) {
        conta.depositar(valor);
    }

    private static void realizarTranferencia(Conta pagador, Conta recebedor, double valor) {

        if (pagador.consultarSaldo() < valor) {
            System.out.println("Saldo insuficiente");
            return;
        }

        pagador.adicionarSaldo(-valor);
        recebedor.adicionarSaldo(valor);

        System.out.println("Tranferencia no valor de " + valor + " efetuada com sucesso");
    }
    
    private static double valorSaque() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual valor deseja sacar?");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        return valor;
    }

    private static double valorDeposito() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual valor deseja depositar?");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        return valor;
    }

    private static Conta contaSaque(List<Conta> contasDoCliente) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual conta será utilizada para o saque?");
        int escolhaDaConta = Integer.parseInt(scanner.nextLine());

        if (escolhaDaConta <= 0 || escolhaDaConta > contasDoCliente.size()) {
            return null;
        }

        return contasDoCliente.get(escolhaDaConta -1);
    }

    private static Conta contaDeposito(List<Conta> contasDoCliente) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual conta será utilizada para o deposito?");
        int escolhaDaConta = Integer.parseInt(scanner.nextLine());

        if (escolhaDaConta <= 0 || escolhaDaConta > contasDoCliente.size()) {
            return null;
        }

        return contasDoCliente.get(escolhaDaConta -1);
    }


    private static Conta pagadorTranferencia(List<Conta> contasDoCliente) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Escolha a conta que ira fazer o pagamento");
        int escolhaDoPagador = Integer.parseInt(scanner.nextLine());

        if (escolhaDoPagador <= 0 || escolhaDoPagador > contasDoCliente.size()) {
            return null;
        }

        return contasDoCliente.get(escolhaDoPagador -1);

    }

    private static Conta recebedorTranferencia(List<Conta> contasDoCliente) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Escolha a conta que ira receber");
        int escolhaDoRecebedor = Integer.parseInt(scanner.nextLine());

        if (escolhaDoRecebedor <= 0 || escolhaDoRecebedor > contasDoCliente.size()) {
            return null;
        }

        return contasDoCliente.get(escolhaDoRecebedor -1);
    }

    private static double valorTranferencia() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual o valor da tranferencia?");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        return valor;
    }

    public static void saque(List<Conta> contasDoCliente){
        
        if (contasDoCliente.size() < 2) {
            
            double valor = valorSaque();
            Conta conta = contasDoCliente.get(0);
            realizarSaque(conta, valor);

        } else {

            MostrarInformacoes.mostrarContas(contasDoCliente);

            Conta conta = contaSaque(contasDoCliente);

            if (conta == null) {
                System.out.println("Invalido");
            } else {

                double valor = valorSaque();
                realizarSaque(conta, valor);

            }

            
        }
    }

    public static void deposito(List<Conta> contasDoCliente) {
        if (contasDoCliente.size() < 2) {

            double valor = valorDeposito();
            Conta conta = contasDoCliente.get(0);
            realizarDeposito(conta, valor);

        } else {
            
            MostrarInformacoes.mostrarContas(contasDoCliente);
            
            Conta conta = contaDeposito(contasDoCliente);

            if (conta == null) {
                System.out.println("Invalido");
            } else{
                
                double valor = valorDeposito();
                realizarDeposito(conta, valor);

            }

        }
    }



    public static void transferencia(List<Conta> contasDoCliente){
        if (contasDoCliente.size() < 2) {
            System.out.println("É necessário possuir no mínimo 2 contas para realizar tranferencias");
            return;
        }

        MostrarInformacoes.mostrarContas(contasDoCliente);

        Conta pagador = pagadorTranferencia(contasDoCliente);
        Conta recebedor = recebedorTranferencia(contasDoCliente);
        

        if (pagador == null || recebedor == null || pagador.equals(recebedor)) {
            System.out.println("Contas invalidas ou iguais");
            return;
        } 

        double valor = valorTranferencia();
        realizarTranferencia(pagador, recebedor, valor);
        
    }
}