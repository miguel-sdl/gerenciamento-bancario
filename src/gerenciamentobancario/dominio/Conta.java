package gerenciamentobancario.dominio;

import java.util.Random;
import java.util.Scanner;

public abstract class Conta {
    protected int numConta;
    protected double saldo;
    protected Cliente cliente;


    

    

    public Conta() {
        Random random = new Random();
        numConta = random.nextInt(1000, 9999);
    }




    public Conta(int numConta) {
        this.numConta = numConta;
    }

    


    @Override
    public String toString() {
        return "Conta [numConta=" + numConta + ", saldo=" + saldo + ", TipoDeConta=" + getTipoDeConta() + "]";
    }




    @SuppressWarnings("resource")
    public static void criarConta(Cliente cliente) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite 1 para conta-corrente ou 2 para conta-poupança");
        String escolhaDeConta = scanner.nextLine();

         if (escolhaDeConta.equals("1")) {
                cliente.setConta(new ContaCorrente());
                System.out.println("Conta-corrente criada com sucesso");

            } else if (escolhaDeConta.equals("2")) {
                cliente.setConta(new ContaPoupanca());
                System.out.println("Conta-poupança criada com sucesso");
                
            } else {
                System.out.println("Invalido");
            }

        
        
    }


    public abstract String getTipoDeConta();




    



    public double consultarSaldo(){
        return this.saldo;
    }





    public long getNumConta() {
        return numConta;
    }







    public void depositar(double saldo) {
        this.saldo += saldo;
        System.out.println("Você depositou " + saldo);
        System.out.println("Seu novo saldo é " + this.saldo);
    }
    


    public abstract void sacar(double valor);


    public void adicionarSaldo(double valor){
        this.saldo += valor;
    }




    public Cliente getCliente() {
        return cliente;
    }








    
}
