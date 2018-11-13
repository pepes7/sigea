package tabelas;

public class Pessoa {
    private String cpf;
    private String nome;
    private String email;
    private String senha;
    private String endereco;
    
    public Pessoa(){
        cpf = "";
        nome = "";
        email = "";        
        senha = "";
        endereco = "";        
    }
    public Pessoa(String cpf, String nome,String email,String senha,String endereco){
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;        
        this.senha = senha;
        this.endereco = endereco;        
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    
}
