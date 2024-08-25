package gerenciamentobancario.dominio;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(){
        super();
    }

    public ContaPoupanca(int numConta) {
        super(numConta);
    }

    @Override
    public String getTipoDeConta() {
        return "Conta Poupança";
    }

    @Override
    public void sacar(double valor) {
        System.out.println("Conta do tipo poupança, para sacar entre em contato com o banco");
    }

    public static void criarConta(Cliente cliente) {
        cliente.setConta(new ContaPoupanca());
        System.out.println("Conta poupança criada com sucesso");
    }
}
