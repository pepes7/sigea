package tabelas;

public class Inscricao {

    private int numero;
    private int matFuncAprova;
    private int numEventoReferente;
    private int numCandidatoFaz;
    //Modificar os tipos 
    private int dataInscricao;
    private int hora;
    private int dataFim;
    private String situacao;

    public Inscricao(int numero, int matFuncAprova, int numEventoReferente, int numCandidatoFaz, int dataInscricao, int hora, int dataFim, String situacao){
        this.numero = numero;
        this.matFuncAprova = matFuncAprova;
        this.numEventoReferente = numEventoReferente;
        this.numCandidatoFaz = numCandidatoFaz;
        this.dataInscricao = dataInscricao;
        this.hora = hora;
        this.dataFim = dataFim;
        this.situacao = situacao;
    }
    
    public Inscricao(){
        this.numero = 0;
        this.matFuncAprova = 0;
        this.numEventoReferente = 0;
        this.numCandidatoFaz = 0;
        this.dataInscricao = 0;
        this.hora = 0;
        this.dataFim = 0;
        this.situacao = "";
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getMatFuncAprova() {
        return matFuncAprova;
    }

    public void setMatFuncAprova(int matFuncAprova) {
        this.matFuncAprova = matFuncAprova;
    }

    public int getNumEventoReferente() {
        return numEventoReferente;
    }

    public void setNumEventoReferente(int numEventoReferente) {
        this.numEventoReferente = numEventoReferente;
    }

    public int getNumCandidatoFaz() {
        return numCandidatoFaz;
    }

    public void setNumCandidatoFaz(int numCandidatoFaz) {
        this.numCandidatoFaz = numCandidatoFaz;
    }

    public int getDataInscricao() {
        return dataInscricao;
    }

    public void setDataInscricao(int dataInscricao) {
        this.dataInscricao = dataInscricao;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getDataFim() {
        return dataFim;
    }

    public void setDataFim(int dataFim) {
        this.dataFim = dataFim;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
    
}
