package tabelas;

public class Funcionario {

    private int matricula;
    private String cpfPessoa;
    private int codDepartamento;
    private String senha;

    public Funcionario(int matricula, String cpfPessoa, int codDepartamento, String senha){
        this.matricula = matricula;
        this.cpfPessoa = cpfPessoa;
        this.codDepartamento = codDepartamento;
        this.senha = senha;
    }
    
    public Funcionario(){
        this.matricula = 0;
        this.cpfPessoa = "";
        this.codDepartamento = 0;
        this.senha = "";
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getCpfPessoa() {
        return cpfPessoa;
    }

    public void setCpfPessoa(String cpfPessoa) {
        this.cpfPessoa = cpfPessoa;
    }

    public int getCodDepartamento() {
        return codDepartamento;
    }

    public void setCodDepartamento(int codDepartamento) {
        this.codDepartamento = codDepartamento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
