package tela;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import tabelas.Candidato;
import tabelas.Evento;

import tabelas.Pessoa;
import tabelas.dao.CandidatoDao;
import tabelas.dao.EventoDao;
import tabelas.dao.PessoaDao;

public class Sigea extends JFrame implements ActionListener, MouseListener, KeyListener {

    Login login;
    Cadastro cadastro;
    Entrada entrada;
    LoginFuncionario loginFuncionario;
    Modelo modelo;
    ModeloFuncionario modeloFuncionario;
    FuncionarioAlterar funcionarioAlterar;
    FuncionarioAlteraDados funcionarioAlteraDados;

    Util util;

    Pessoa pessoa;
    PessoaDao pessoaDao;
    Candidato candidato;
    CandidatoDao candidatoDao;
    Evento evento;
    EventoDao eventoDao;

    boolean bot = false;

    public Sigea() {
        login = new Login();
        cadastro = new Cadastro();
        entrada = new Entrada();
        loginFuncionario = new LoginFuncionario();
        modelo = new Modelo();
        modeloFuncionario = new ModeloFuncionario();
        funcionarioAlterar = new FuncionarioAlterar();
        funcionarioAlteraDados = new FuncionarioAlteraDados();

        eventoDao = new EventoDao();

        //Configurações do JFrame 
        setTitle("SIGEA");
        setSize(login.img.getWidth(this), login.img.getHeight(this));
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        init();

        add(entrada);
    }

    public static void main(String[] args) {
        new Sigea();
    }

    public void trocarTela(JPanel remove, JPanel novaTela) {

        util.TELA_ATUAL = novaTela;
        util.ULTIMA_TELA = remove;

        remove.setVisible(false);
        this.add(novaTela);
        novaTela.setVisible(true);
        novaTela.requestFocus();

        init();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Login
        if (e.getSource() == login.jCadastro) {
            trocarTela(login, cadastro = new Cadastro());

        }

        if (e.getSource() == login.jEntrar) {
            if (pessoaDao.loginCandidato(login.jtxtCpf, login.jtxtPassword)) {
                Util.nomeCandidato = pessoaDao.nomeCandidato(login.jtxtCpf);
                trocarTela(login, modelo = new Modelo());

            }
        }

        //Login Funcionario
        if (e.getSource() == loginFuncionario.jEntrar) {
            if (pessoaDao.loginFuncionario(loginFuncionario.jtxtMatricula, loginFuncionario.jtxtSenha)) {
                Util.nomeFuncionario = pessoaDao.nomeFuncionario(loginFuncionario.jtxtMatricula);
                trocarTela(loginFuncionario, modeloFuncionario = new ModeloFuncionario());
                Util.matricula = Integer.parseInt(loginFuncionario.jtxtMatricula.getText());
            }
        }

        //Entrada
        if (e.getSource() == entrada.jParticipante) {
            trocarTela(entrada, login = new Login());
        }

        if (e.getSource() == entrada.jFuncionario) {
            trocarTela(entrada, loginFuncionario = new LoginFuncionario());
        }

        //Cadastro
        if (e.getSource() == cadastro.jCadastrar) {
            pessoa = new Pessoa(cadastro.jtxtCpf.getText(), cadastro.jtxtNome.getText(), cadastro.jtxtEmail.getText(), cadastro.jtxtEndereco.getText());
            candidato = new Candidato(cadastro.jtxtCpf.getText(), cadastro.jtxtSenha.getText());
            pessoaDao = new PessoaDao();
            candidatoDao = new CandidatoDao();
            pessoaDao.incluir(pessoa);
            candidatoDao.incluir(candidato);
            JOptionPane.showMessageDialog(null, "Conta cridada!");
        }

        //Modelo
        if (e.getSource() == modelo.jSair) {
            trocarTela(modelo, entrada = new Entrada());
        }

        //ModeloFuncionario
        if (e.getSource() == modeloFuncionario.jSair) {
            trocarTela(modeloFuncionario, entrada = new Entrada());
        }

        if (e.getSource() == modeloFuncionario.jSalvar) {
            evento = new Evento(convertInt(modeloFuncionario.jtxtNumero), Util.matricula, Util.matricula, modeloFuncionario.jtxtNome.getText(), convertInt(modeloFuncionario.jtxtVagas), modeloFuncionario.jtxtDataInicio.getText(), modeloFuncionario.jtxtDataFim.getText(), modeloFuncionario.jtxtHoraInicio.getText(), modeloFuncionario.jtxtHoraFim.getText(), modeloFuncionario.jtxtInscricaoHoraInicio.getText(), modeloFuncionario.jtxtInscricaoHoraFim.getText(), modeloFuncionario.jtxtInscricaoDataInicio.getText(), modeloFuncionario.jtxtInscricaoDataFim.getText());
            eventoDao = new EventoDao();
            eventoDao.incluir(evento);
        }

        if (e.getSource() == modeloFuncionario.jAlterar) {
            trocarTela(modeloFuncionario, funcionarioAlterar = new FuncionarioAlterar());
        }

        //FuncionarioAlterar
        if (e.getSource() == funcionarioAlterar.jSair) {
            trocarTela(funcionarioAlterar, entrada = new Entrada());
        }

        if (e.getSource() == funcionarioAlterar.jAdicionar) {
            trocarTela(funcionarioAlterar, modeloFuncionario = new ModeloFuncionario());
        }

        if (e.getSource() == funcionarioAlterar.jPesquisar) {
            if (eventoDao.pesquisarNumEvento(funcionarioAlterar.jtxtPesquisar)) {
                trocarTela(funcionarioAlterar, funcionarioAlteraDados = new FuncionarioAlteraDados());
                eventoDao.pesquisar(funcionarioAlterar.jtxtPesquisar, funcionarioAlteraDados.jtxtNumero,funcionarioAlteraDados.jtxtNome, funcionarioAlteraDados.jtxtVagas, funcionarioAlteraDados.jtxtDataInicio, funcionarioAlteraDados.jtxtDataFim, funcionarioAlteraDados.jtxtHoraInicio, funcionarioAlteraDados.jtxtHoraFim, funcionarioAlteraDados.jtxtInscricaoHoraInicio, funcionarioAlteraDados.jtxtInscricaoHoraFim, funcionarioAlteraDados.jtxtInscricaoDataInicio, funcionarioAlteraDados.jtxtInscricaoDataFim);

            }
        }

        //FuncionarioAlteraDados
        if (e.getSource() == funcionarioAlteraDados.jSair) {
            trocarTela(funcionarioAlteraDados, entrada = new Entrada());
        }

        if (e.getSource() == funcionarioAlteraDados.jAdicionar) {
            trocarTela(funcionarioAlteraDados, modeloFuncionario = new ModeloFuncionario());
        }

        if (e.getSource() == funcionarioAlteraDados.jAlterar){
            evento = new Evento(convertInt(funcionarioAlteraDados.jtxtNumero), Util.matricula, Util.matricula, funcionarioAlteraDados.jtxtNome.getText(), convertInt(funcionarioAlteraDados.jtxtVagas), funcionarioAlteraDados.jtxtDataInicio.getText(), funcionarioAlteraDados.jtxtDataFim.getText(), funcionarioAlteraDados.jtxtHoraInicio.getText(), funcionarioAlteraDados.jtxtHoraFim.getText(), funcionarioAlteraDados.jtxtInscricaoHoraInicio.getText(), funcionarioAlteraDados.jtxtInscricaoHoraFim.getText(), funcionarioAlteraDados.jtxtInscricaoDataInicio.getText(), funcionarioAlteraDados.jtxtInscricaoDataFim.getText());
            eventoDao = new EventoDao();
            eventoDao.alterar(evento);

        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int tecla = e.getKeyCode();

        if (tecla == KeyEvent.VK_ESCAPE) {
            trocarTela(util.TELA_ATUAL, util.ULTIMA_TELA);
        }

        //Configuração dos Jtxt da classe Login
        util.jTextDelete(tecla, login.jtxtCpf, "CPF");
        util.jTextDelete(tecla, login.jtxtPassword, "Senha");

        //Configuração dos Jtxt da classe Cadastro
        util.jTextDelete(tecla, cadastro.jtxtCpf, "Cpf");
        util.jTextDelete(tecla, cadastro.jtxtNome, "Nome");
        util.jTextDelete(tecla, cadastro.jtxtEmail, "Email");
        util.jTextDelete(tecla, cadastro.jtxtSenha, "Senha");
        util.jTextDelete(tecla, cadastro.jtxtEndereco, "Endereço");

        //Configuração dos Jtxt da classe Login Funcionario
        util.jTextDelete(tecla, loginFuncionario.jtxtMatricula, "Matricula");
        util.jTextDelete(tecla, loginFuncionario.jtxtSenha, "Senha");

        //Configuração dos Jtxt da classe ModeloFuncionario
        util.jTextDelete(tecla, modeloFuncionario.jtxtNumero, "Número");
        util.jTextDelete(tecla, modeloFuncionario.jtxtNome, "Nome");
        util.jTextDelete(tecla, modeloFuncionario.jtxtVagas, "Vagas");
        util.jTextDelete(tecla, modeloFuncionario.jtxtDataInicio, "02/12/2018");
        util.jTextDelete(tecla, modeloFuncionario.jtxtDataFim, "04/12/2018");
        util.jTextDelete(tecla, modeloFuncionario.jtxtHoraInicio, "16:40");
        util.jTextDelete(tecla, modeloFuncionario.jtxtHoraFim, "20:00");
        util.jTextDelete(tecla, modeloFuncionario.jtxtInscricaoDataInicio, "10/10/2018");
        util.jTextDelete(tecla, modeloFuncionario.jtxtInscricaoDataFim, "28/11/2018");
        util.jTextDelete(tecla, modeloFuncionario.jtxtInscricaoHoraInicio, "10:00");
        util.jTextDelete(tecla, modeloFuncionario.jtxtInscricaoHoraFim, "23:59");

        Util.jTextDelete(tecla, funcionarioAlterar.jtxtPesquisar, "Número do Evento");

        //Configuração dos Jtxt da classe FuncionarioAlteraDados
        util.jTextDelete(tecla, funcionarioAlteraDados.jtxtNumero, "Número");
        util.jTextDelete(tecla, funcionarioAlteraDados.jtxtNome, "Nome");
        util.jTextDelete(tecla, funcionarioAlteraDados.jtxtVagas, "Vagas");
        util.jTextDelete(tecla, funcionarioAlteraDados.jtxtDataInicio, "02/12/2018");
        util.jTextDelete(tecla, funcionarioAlteraDados.jtxtDataFim, "04/12/2018");
        util.jTextDelete(tecla, funcionarioAlteraDados.jtxtHoraInicio, "16:40");
        util.jTextDelete(tecla, funcionarioAlteraDados.jtxtHoraFim, "20:00");
        util.jTextDelete(tecla, funcionarioAlteraDados.jtxtInscricaoDataInicio, "10/10/2018");
        util.jTextDelete(tecla, funcionarioAlteraDados.jtxtInscricaoDataFim, "28/11/2018");
        util.jTextDelete(tecla, funcionarioAlteraDados.jtxtInscricaoHoraInicio, "10:00");
        util.jTextDelete(tecla, funcionarioAlteraDados.jtxtInscricaoHoraFim, "23:59");

    }

    @Override
    public void keyReleased(KeyEvent e) {
        //Configuração dos Jtxt da classe Login
        util.jTextRewrite(login.jtxtCpf, "CPF");
        util.jTextRewrite(login.jtxtPassword, "Senha");

        //Configuração dos Jtxt da classe Cadastro
        util.jTextRewrite(cadastro.jtxtCpf, "Cpf");
        util.jTextRewrite(cadastro.jtxtNome, "Nome");
        util.jTextRewrite(cadastro.jtxtEmail, "Email");
        util.jTextRewrite(cadastro.jtxtSenha, "Senha");
        util.jTextRewrite(cadastro.jtxtEndereco, "Endereço");

        //Configuração dos Jtxt da classe Matricula
        util.jTextRewrite(loginFuncionario.jtxtMatricula, "Matricula");
        util.jTextRewrite(loginFuncionario.jtxtSenha, "Senha");

        //Configuração dos Jtxt da classe ModeloFuncionario
        util.jTextRewrite(modeloFuncionario.jtxtNumero, "Número");
        util.jTextRewrite(modeloFuncionario.jtxtNome, "Nome");
        util.jTextRewrite(modeloFuncionario.jtxtVagas, "Vagas");
        Util.jTextRewrite(modeloFuncionario.jtxtDataInicio, "02/12/2018");
        Util.jTextRewrite(modeloFuncionario.jtxtDataFim, "04/12/2018");
        util.jTextRewrite(modeloFuncionario.jtxtHoraInicio, "16:40");
        util.jTextRewrite(modeloFuncionario.jtxtHoraFim, "20:00");
        util.jTextRewrite(modeloFuncionario.jtxtInscricaoDataInicio, "10/10/2018");
        util.jTextRewrite(modeloFuncionario.jtxtInscricaoDataFim, "28/11/2018");
        util.jTextRewrite(modeloFuncionario.jtxtInscricaoHoraInicio, "10:00");
        util.jTextRewrite(modeloFuncionario.jtxtInscricaoHoraFim, "23:59");

        //Configuração dos Jtxt da classe FuncionarioAlterar
        Util.jTextRewrite(funcionarioAlterar.jtxtPesquisar, "Número do Evento");

        //Configuração dos Jtxt da classe FuncionarioAlteraDados
        util.jTextRewrite(funcionarioAlteraDados.jtxtNumero, "Número");
        util.jTextRewrite(funcionarioAlteraDados.jtxtNome, "Nome");
        util.jTextRewrite(funcionarioAlteraDados.jtxtVagas, "Vagas");
        Util.jTextRewrite(funcionarioAlteraDados.jtxtDataInicio, "02/12/2018");
        Util.jTextRewrite(funcionarioAlteraDados.jtxtDataFim, "04/12/2018");
        util.jTextRewrite(funcionarioAlteraDados.jtxtHoraInicio, "16:40");
        util.jTextRewrite(funcionarioAlteraDados.jtxtHoraFim, "20:00");
        util.jTextRewrite(funcionarioAlteraDados.jtxtInscricaoDataInicio, "10/10/2018");
        util.jTextRewrite(funcionarioAlteraDados.jtxtInscricaoDataFim, "28/11/2018");
        util.jTextRewrite(funcionarioAlteraDados.jtxtInscricaoHoraInicio, "10:00");
        util.jTextRewrite(funcionarioAlteraDados.jtxtInscricaoHoraFim, "23:59");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == login.jtxtCpf && login.jtxtCpf.getText().equals("Email Pessoal")) {
            login.jtxtCpf.setCaretPosition(0);
        }

        if (e.getSource() == login.jtxtPassword && login.jtxtCpf.getText().equals("Senha")) {
            login.jtxtPassword.setCaretPosition(0);
        }

    }

    @Override
    public void mousePressed(MouseEvent e) { //se pressionar
        if (e.getSource() == login.jOlho) { //botao bressionado pelo mouse
            if (bot == false && !login.jtxtPassword.getText().equals("Senha")) {
                login.jtxtPassword.requestFocus();
                login.jOlho.setIcon(null);
                login.jtxtPassword.setEchoChar('\u0000'); //revelar
            }
            bot = !bot;
        }
        if (e.getSource() == cadastro.jOlho) { //botao bressionado pelo mouse
            if (bot == false && !cadastro.jtxtSenha.getText().equals("Senha")) {
                cadastro.jtxtSenha.requestFocus();
                cadastro.jOlho.setIcon(null);
                cadastro.jtxtSenha.setEchoChar('\u0000'); //revelar
            }
            bot = !bot;
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == login.jOlho) {
            if (bot && !login.jtxtPassword.getText().equals("Senha")) {
                login.jOlho.setIcon(util.olhoCorte);
                login.jtxtPassword.requestFocus();
                login.jtxtPassword.setEchoChar('\u2022'); //ocultar
            }
            bot = !bot;
        }

        if (e.getSource() == cadastro.jOlho) {
            if (bot && !cadastro.jtxtSenha.getText().equals("Senha")) {
                cadastro.jOlho.setIcon(util.olhoCorte);
                cadastro.jtxtSenha.requestFocus();
                cadastro.jtxtSenha.setEchoChar('\u2022'); //ocultar
            }
            bot = !bot;
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == login.jCadastro) { //se passar o mouse por cima troca a imagem do botao cadastre-se para o sublinhado
            login.jCadastro.setIcon(util.cadastroSublinhado);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == login.jCadastro) { //se sair do botao Cadastre-se
            login.jCadastro.setIcon(null);
        }

    }

    public void init() {
        //metodo para o Teclado ser utilizado no Panel
        login.addKeyListener(this);
        cadastro.addKeyListener(this);
        entrada.addKeyListener(this);
        loginFuncionario.addKeyListener(this);
        modelo.addKeyListener(this);
        modeloFuncionario.addKeyListener(this);

        //metodo para o Iplementar o ActionListener
        this.login.jCadastro.addActionListener(this);
        this.login.jtxtCpf.addActionListener(this);
        this.login.jEntrar.addActionListener(this);

        this.cadastro.jCadastrar.addActionListener(this);

        this.loginFuncionario.jEntrar.addActionListener(this);

        this.entrada.jParticipante.addActionListener(this);
        this.entrada.jFuncionario.addActionListener(this);

        this.modelo.jSair.addActionListener(this);

        this.modeloFuncionario.jSair.addActionListener(this);
        this.modeloFuncionario.jSalvar.addActionListener(this);
        this.modeloFuncionario.jAlterar.addActionListener(this);
        this.modeloFuncionario.jConsultar.addActionListener(this);
        this.modeloFuncionario.jExcluir.addActionListener(this);

        this.funcionarioAlterar.jSair.addActionListener(this);
        this.funcionarioAlterar.jAdicionar.addActionListener(this);
        this.funcionarioAlterar.jConsultar.addActionListener(this);
        this.funcionarioAlterar.jExcluir.addActionListener(this);
        this.funcionarioAlterar.jPesquisar.addActionListener(this);

        this.funcionarioAlteraDados.jSair.addActionListener(this);
        this.funcionarioAlteraDados.jAdicionar.addActionListener(this);
        this.funcionarioAlteraDados.jConsultar.addActionListener(this);
        this.funcionarioAlteraDados.jExcluir.addActionListener(this);
        this.funcionarioAlteraDados.jAlterar.addActionListener(this);

        //metodo para o Iplementar o Eventos do Mouse nos componentes
        this.login.jCadastro.addMouseListener(this);
        this.login.jOlho.addMouseListener(this);
        this.login.jtxtCpf.addMouseListener(this);
        this.login.jtxtPassword.addMouseListener(this);

        this.cadastro.jOlho.addMouseListener(this);

        //metodo para o Teclado ser utilizado no componente
        this.login.jtxtCpf.addKeyListener(this);
        this.login.jtxtPassword.addKeyListener(this);

        this.loginFuncionario.jtxtMatricula.addKeyListener(this);
        this.loginFuncionario.jtxtSenha.addKeyListener(this);

        this.cadastro.jtxtCpf.addKeyListener(this);
        this.cadastro.jtxtNome.addKeyListener(this);
        this.cadastro.jtxtEmail.addKeyListener(this);
        this.cadastro.jtxtSenha.addKeyListener(this);
        this.cadastro.jtxtEndereco.addKeyListener(this);

        this.modeloFuncionario.jtxtNumero.addKeyListener(this);
        this.modeloFuncionario.jtxtNome.addKeyListener(this);
        this.modeloFuncionario.jtxtVagas.addKeyListener(this);
        this.modeloFuncionario.jtxtDataInicio.addKeyListener(this);
        this.modeloFuncionario.jtxtDataFim.addKeyListener(this);
        this.modeloFuncionario.jtxtHoraInicio.addKeyListener(this);
        this.modeloFuncionario.jtxtHoraFim.addKeyListener(this);
        this.modeloFuncionario.jtxtInscricaoDataInicio.addKeyListener(this);
        this.modeloFuncionario.jtxtInscricaoDataFim.addKeyListener(this);
        this.modeloFuncionario.jtxtInscricaoHoraInicio.addKeyListener(this);
        this.modeloFuncionario.jtxtInscricaoHoraFim.addKeyListener(this);

        this.funcionarioAlterar.jtxtPesquisar.addKeyListener(this);

        this.funcionarioAlteraDados.jtxtNumero.addKeyListener(this);
        this.funcionarioAlteraDados.jtxtNome.addKeyListener(this);
        this.funcionarioAlteraDados.jtxtVagas.addKeyListener(this);
        this.funcionarioAlteraDados.jtxtDataInicio.addKeyListener(this);
        this.funcionarioAlteraDados.jtxtDataFim.addKeyListener(this);
        this.funcionarioAlteraDados.jtxtHoraInicio.addKeyListener(this);
        this.funcionarioAlteraDados.jtxtHoraFim.addKeyListener(this);
        this.funcionarioAlteraDados.jtxtInscricaoDataInicio.addKeyListener(this);
        this.funcionarioAlteraDados.jtxtInscricaoDataFim.addKeyListener(this);
        this.funcionarioAlteraDados.jtxtInscricaoHoraInicio.addKeyListener(this);
        this.funcionarioAlteraDados.jtxtInscricaoHoraFim.addKeyListener(this);

    }

    public int convertInt(JTextField txt) {
        return Integer.parseInt(txt.getText());

    }

}
