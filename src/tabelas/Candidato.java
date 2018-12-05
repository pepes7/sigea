package tabelas;

public class Candidato {

    private int numero;
    private String cpfPessoa;
    private String senha;

    public Candidato(String cpfPessoa, String senha) {
        this.cpfPessoa = cpfPessoa;
        this.senha = senha;
    }

    public Candidato() {
        this.numero = 0;
        this.cpfPessoa = "";
        this.senha = "";
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCpfPessoa() {
        return cpfPessoa;
    }

    public void setCpfPessoa(String cpfPessoa) {
        this.cpfPessoa = cpfPessoa;
    }

}
