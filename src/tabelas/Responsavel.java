package tabelas;

public class Responsavel {

    private int matFuncionario;
    private int numEvento;
    private String papel;

    public Responsavel(int matFuncionario, int numEvento, String papel){
        this.matFuncionario = matFuncionario;
        this.numEvento = numEvento;
        this.papel = papel;
    }
    
    public Responsavel(){
        this.matFuncionario = 0;
        this.numEvento = 0;
        this.papel = "";
    }

    public int getMatFuncionario() {
        return matFuncionario;
    }

    public void setMatFuncionario(int matFuncionario) {
        this.matFuncionario = matFuncionario;
    }

    public int getNumEvento() {
        return numEvento;
    }

    public void setNumEvento(int numEvento) {
        this.numEvento = numEvento;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }
    
    

}
