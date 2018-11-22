package tela;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

import tabelas.Pessoa;
import tabelas.dao.PessoaDAO;

public class Sigea extends JFrame implements ActionListener, MouseListener, KeyListener {

    Login login;
    Cadastro cadastro;
    Entrada entrada;
    LoginFuncionario loginFuncionario;
    Modelo modelo;
    ModeloFuncionario modeloFuncionario;

    Util util;
    Pessoa pessoa;
    PessoaDAO pessoaDao;
    boolean bot = false;
    boolean clickUser = false, clickPassword = false;

    public Sigea() {
        login = new Login();
        cadastro = new Cadastro();
        entrada = new Entrada();
        loginFuncionario = new LoginFuncionario();
        modelo = new Modelo();
        modeloFuncionario = new ModeloFuncionario();

        //Configurações do JFrame 
        setTitle("SIGEA");
        setSize(login.img.getWidth(this), login.img.getHeight(this));
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        //metodo para o Teclado ser utilizado no Panel
        login.addKeyListener(this);
        cadastro.addKeyListener(this);
        entrada.addKeyListener(this);
        loginFuncionario.addKeyListener(this);
        modelo.addKeyListener(this);

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

        //metodo para o Iplementar o Eventos do Mouse nos componentes
        this.login.jCadastro.addMouseListener(this);
        this.login.jOlho.addMouseListener(this);
        this.login.jtxtCpf.addMouseListener(this);
        this.login.jtxtPassword.addMouseListener(this);

        this.cadastro.jOlho.addMouseListener(this);

        //metodo para o Teclado ser utilizado no componente
        this.login.jtxtCpf.addKeyListener(this);
        this.login.jtxtPassword.addKeyListener(this);

        this.loginFuncionario.jtxtEmail.addKeyListener(this);
        this.loginFuncionario.jtxtSenha.addKeyListener(this);

        this.cadastro.jtxtCpf.addKeyListener(this);
        this.cadastro.jtxtNome.addKeyListener(this);
        this.cadastro.jtxtEmail.addKeyListener(this);
        this.cadastro.jtxtSenha.addKeyListener(this);
        this.cadastro.jtxtEndereco.addKeyListener(this);

        add(modelo);
    }

    public static void main(String[] args) {
        new Sigea();
    }

    public void trocarTela(JPanel remove, JPanel novaTela) {

        util.TELA_ATUAL = novaTela;
        util.ULTIMA_TELA = remove;

        if (util.TELA_ATUAL  != modeloFuncionario && util.TELA_ATUAL  != modelo){
            remove.setVisible(false);
            this.add(novaTela);
            novaTela.setVisible(true);
            novaTela.requestFocus();
        }
       
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Login
        if (e.getSource() == login.jCadastro) {
            trocarTela(login, cadastro);
        }

        if (e.getSource() == login.jEntrar) {
            if (pessoaDao.pesquisarPessoa(login.jtxtCpf, login.jtxtPassword)) {
                trocarTela(login, modelo);
            }
        }

        //Entrada
        if (e.getSource() == entrada.jParticipante) {
            trocarTela(entrada, login);
        }

        if (e.getSource() == entrada.jFuncionario) {
            trocarTela(entrada, loginFuncionario);
        }

        //Cadastro
        if (e.getSource() == cadastro.jCadastrar) {
            pessoa = new Pessoa();
            pessoa.setCpf(cadastro.jtxtCpf.getText());
            pessoa.setNome(cadastro.jtxtNome.getText());
            pessoa.setEmail(cadastro.jtxtEmail.getText());
            pessoa.setSenha(cadastro.jtxtSenha.getText());
            pessoa.setEndereco(cadastro.jtxtEndereco.getText());
            pessoaDao = new PessoaDAO();
            pessoaDao.incluir(pessoa);
        }

        //Modelo
        if (e.getSource() == modelo.jSair) {
            trocarTela(modelo, entrada);
        }

        //ModeloFuncionario
        if (e.getSource() == modeloFuncionario.jSair) {
            trocarTela(modeloFuncionario, entrada);
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
        util.jTextDelete(tecla, login.jtxtCpf, "Cpf");
        util.jTextDelete(tecla, login.jtxtPassword, "Senha");

        //Configuração dos Jtxt da classe Cadastro
        util.jTextDelete(tecla, cadastro.jtxtCpf, "Cpf");
        util.jTextDelete(tecla, cadastro.jtxtNome, "Nome");
        util.jTextDelete(tecla, cadastro.jtxtEmail, "Email");
        util.jTextDelete(tecla, cadastro.jtxtSenha, "Senha");
        util.jTextDelete(tecla, cadastro.jtxtEndereco, "Endereço");

        //Configuração dos Jtxt da classe Cadastro
        util.jTextDelete(tecla, loginFuncionario.jtxtEmail, "Email Pessoal");
        util.jTextDelete(tecla, loginFuncionario.jtxtSenha, "Senha");

    }

    @Override
    public void keyReleased(KeyEvent e) {
        //Configuração dos Jtxt da classe Login
        util.jTextRewrite(login.jtxtCpf, "Cpf");
        util.jTextRewrite(login.jtxtPassword, "Senha");

        //Configuração dos Jtxt da classe Cadastro
        util.jTextRewrite(cadastro.jtxtCpf, "Cpf");
        util.jTextRewrite(cadastro.jtxtNome, "Nome");
        util.jTextRewrite(cadastro.jtxtEmail, "Email");
        util.jTextRewrite(cadastro.jtxtSenha, "Senha");
        util.jTextRewrite(cadastro.jtxtEndereco, "Endereço");

        //Configuração dos Jtxt da classe Cadastro
        util.jTextRewrite(loginFuncionario.jtxtEmail, "Email Pessoal");
        util.jTextRewrite(loginFuncionario.jtxtSenha, "Senha");
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

}

