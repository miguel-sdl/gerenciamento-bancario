package gerenciamentobancario.dominio;

public class ContaCorrente extends Conta {

    public ContaCorrente(){
        super();
    }

    public ContaCorrente(int numConta) {
        super(numConta);
    }

    public String getTipoDeConta(){
        return "Conta-corrente";
    }

    @Override
    public void sacar(double valor){
        if (valor>this.saldo) {
            System.out.println("Saldo indisponivel");
            return;
        }
        this.saldo -=  valor;
        System.out.println("Voce sacou " + valor);
        System.out.println("Seu novo saldo é " + this.saldo);
    }

    
    public static void criarConta(Cliente cliente) {
        cliente.setConta(new ContaCorrente());
        System.out.println("Conta corrente criada com sucesso");
    }
}
