package tabelas;

public class Evento {

    private int numero;
    private int matFuncSolicita;
    private int matFuncAutoriza;
    private String nome;
    private int qtdePessoas;
    //Ajeitar os tipos abaixo
    private int dataInicio;
    private int dataFim;
    private int horaInicio;
    private int horaFim;
    private int horaInscricaoInicio;
    private int horaInscricaoFim;
    private int dataInscricaoInicio;
    private int dataInscricaoFim;

    public Evento(int numero, int matFuncSolicita, int matFuncAutoriza, String nome, int qtdePessoas, int dataInicio, int dataFim, int horaInicio, int horaFim, int horaInscricaoInicio, int horaInscricaoFim, int dataInscricaoInicio, int dataInscricaoFim){
        this.numero = numero;
        this.matFuncSolicita = matFuncSolicita;
        this.matFuncAutoriza = matFuncAutoriza;
        this.nome = nome;
        this.qtdePessoas = qtdePessoas;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.horaInscricaoInicio = horaInscricaoInicio;
        this.horaInscricaoFim = horaInscricaoFim;
        this.dataInscricaoInicio = dataInscricaoInicio;
        this.dataInscricaoFim = dataInscricaoFim;
    }
    
    public Evento(){
        this.numero = 0;
        this.matFuncSolicita = 0;
        this.matFuncAutoriza = 0;
        this.nome = "";
        this.qtdePessoas = 0;
        this.dataInicio = 0;
        this.dataFim = 0;
        this.horaInicio = 0;
        this.horaFim = 0;
        this.horaInscricaoInicio = 0;
        this.horaInscricaoFim = 0;
        this.dataInscricaoInicio = 0;
        this.dataInscricaoFim = 0;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getMatFuncSolicita() {
        return matFuncSolicita;
    }

    public void setMatFuncSolicita(int matFuncSolicita) {
        this.matFuncSolicita = matFuncSolicita;
    }

    public int getMatFuncAutoriza() {
        return matFuncAutoriza;
    }

    public void setMatFuncAutoriza(int matFuncAutoriza) {
        this.matFuncAutoriza = matFuncAutoriza;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdePessoas() {
        return qtdePessoas;
    }

    public void setQtdePessoas(int qtdePessoas) {
        this.qtdePessoas = qtdePessoas;
    }

    public int getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(int dataInicio) {
        this.dataInicio = dataInicio;
    }

    public int getDataFim() {
        return dataFim;
    }

    public void setDataFim(int dataFim) {
        this.dataFim = dataFim;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(int horaFim) {
        this.horaFim = horaFim;
    }

    public int getHoraInscricaoInicio() {
        return horaInscricaoInicio;
    }

    public void setHoraInscricaoInicio(int horaInscricaoInicio) {
        this.horaInscricaoInicio = horaInscricaoInicio;
    }

    public int getHoraInscricaoFim() {
        return horaInscricaoFim;
    }

    public void setHoraInscricaoFim(int horaInscricaoFim) {
        this.horaInscricaoFim = horaInscricaoFim;
    }

    public int getDataInscricaoInicio() {
        return dataInscricaoInicio;
    }

    public void setDataInscricaoInicio(int dataInscricaoInicio) {
        this.dataInscricaoInicio = dataInscricaoInicio;
    }

    public int getDataInscricaoFim() {
        return dataInscricaoFim;
    }

    public void setDataInscricaoFim(int dataInscricaoFim) {
        this.dataInscricaoFim = dataInscricaoFim;
    }
    

}
