package tabelas;

public class Fone {
    private String cpfPessoa;
    private String numero;

    public Fone(String cpfPessoa, String numero) {
        this.cpfPessoa = cpfPessoa;
        this.numero = numero;
    }
    
    public Fone() {
        this.cpfPessoa = "";
        this.numero = "";
    }

    public String getCpfPessoa() {
        return cpfPessoa;
    }

    public void setCpfPessoa(String cpfPessoa) {
        this.cpfPessoa = cpfPessoa;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
}
