package tabelas;

public class Evento {

    private int numero;
    private int matFuncSolicita;
    private int matFuncAutoriza;
    private String nome;
    private int qtdePessoas;
    //Ajeitar os tipos abaixo
    private String dataInicio;
    private String dataFim;
    private String horaInicio;
    private String horaFim;
    private String horaInscricaoInicio;
    private String horaInscricaoFim;
    private String dataInscricaoInicio;
    private String dataInscricaoFim;

    public Evento(int numero, int matFuncSolicita, int matFuncAutoriza, String nome, int qtdePessoas, String dataInicio, String dataFim, String horaInicio, String horaFim, String horaInscricaoInicio, String horaInscricaoFim, String dataInscricaoInicio, String dataInscricaoFim) {
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

    public Evento() {
        this.numero = 0;
        this.matFuncSolicita = 0;
        this.matFuncAutoriza = 0;
        this.nome = "";
        this.qtdePessoas = 0;
        this.dataInicio = "";
        this.dataFim = "";
        this.horaInicio = "";
        this.horaFim = "";
        this.horaInscricaoInicio = "";
        this.horaInscricaoFim = "";
        this.dataInscricaoInicio = "";
        this.dataInscricaoFim = "";
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

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }

    public String getHoraInscricaoInicio() {
        return horaInscricaoInicio;
    }

    public void setHoraInscricaoInicio(String horaInscricaoInicio) {
        this.horaInscricaoInicio = horaInscricaoInicio;
    }

    public String getHoraInscricaoFim() {
        return horaInscricaoFim;
    }

    public void setHoraInscricaoFim(String horaInscricaoFim) {
        this.horaInscricaoFim = horaInscricaoFim;
    }

    public String getDataInscricaoInicio() {
        return dataInscricaoInicio;
    }

    public void setDataInscricaoInicio(String dataInscricaoInicio) {
        this.dataInscricaoInicio = dataInscricaoInicio;
    }

    public String getDataInscricaoFim() {
        return dataInscricaoFim;
    }

    public void setDataInscricaoFim(String dataInscricaoFim) {
        this.dataInscricaoFim = dataInscricaoFim;
    }

}
