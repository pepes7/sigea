package tabelas;

public class Candidato {
    private int numero;
    private String cpfPessoa;

    public Candidato(int numero, String cpfPessoa){
        this.numero = numero;
        this.cpfPessoa = cpfPessoa;
    }
    
    public Candidato(){
        this.numero = 0;
        this.cpfPessoa = "";
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