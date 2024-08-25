package gerenciamentobancario.dominio;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String cpf;
    private List<Conta> contas = new ArrayList<>();


    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    


    @Override
    public String toString() {
        return "Cliente [nome=" + nome + ", cpf=" + cpf + ", Conta=" + contas +  "]";
    }




    public String getNome() {
        return nome;
    }




    public String getCpf() {
        return cpf;
    }



    public List<Conta> getConta() {
        if (contas==null) {
            System.out.println("Você ainda não possui uma conta");
        }
        return contas;
    }


    public void setConta(Conta conta) {
        
        contas.add(conta);
        
    }

    
}
