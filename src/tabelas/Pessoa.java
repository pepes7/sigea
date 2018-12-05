package tabelas;

public class Pessoa {
    private String cpf;
    private String nome;
    private String email;
    private String endereco;
    
    public Pessoa(){
        cpf = "";
        nome = "";
        email = "";        
        endereco = "";        
    }
    public Pessoa(String cpf, String nome,String email,String endereco){
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;        
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    
}
