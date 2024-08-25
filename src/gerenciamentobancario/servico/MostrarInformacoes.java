package gerenciamentobancario.servico;

import java.util.List;

import gerenciamentobancario.dominio.Cliente;
import gerenciamentobancario.dominio.Conta;

public class MostrarInformacoes {

    public static void mostarCliente(Cliente cliente) {
        System.out.println(cliente);
    }

    public static void mostrarContas(Cliente cliente) {
        List<Conta> contasDoCliente = cliente.getConta();

        for (int i = 0; i < contasDoCliente.size(); i++) {
            System.out.println((i+1) + " - " + contasDoCliente.get(i));
        };
    }

    public static void mostrarContas(List<Conta> contasDoCliente) {

        for (int i = 0; i < contasDoCliente.size(); i++) {
            System.out.println((i+1) + " - " + contasDoCliente.get(i));
        };
    }

    

    public static void mostrarSaldo(Cliente cliente) {
        List<Conta> contas = cliente.getConta();

        
        for (Conta conta : contas) {
            System.out.println("O saldo atual da conta numero " + conta.getNumConta() + " é de " + conta.consultarSaldo());
        }
    }
}
