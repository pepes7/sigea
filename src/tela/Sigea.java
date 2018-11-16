package tela;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import tabelas.Pessoa;
import tabelas.dao.PessoaDAO;
import static tela.Util.FONT_DEFAULT;
import static tela.Util.FONT_FIELDS;
import static tela.Util.GRAY_LIGHT;

public class Sigea extends JFrame implements ActionListener, MouseListener, KeyListener {

    Login login;
    Cadastro cadastro;
    Entrada entrada;
    LoginFuncionario loginFuncionario;
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

        cadastro.addKeyListener(this);
        entrada.addKeyListener(this);
        loginFuncionario.addKeyListener(this);
        login.addKeyListener(this);

        login.setFocusable(true);

        setTitle("SIGEA");
        setSize(login.img.getWidth(this), login.img.getHeight(this));
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        add(entrada);

        this.login.jCadastro.addActionListener(this);
        this.login.jCadastro.addMouseListener(this);
        this.login.jOlho.addMouseListener(this);
        this.login.jtxtEmail.addMouseListener(this);
        this.login.jtxtPassword.addMouseListener(this);

        this.cadastro.jCadastrar.addActionListener(this);
        this.entrada.jParticipante.addActionListener(this);
        this.entrada.jFuncionario.addActionListener(this);

        login.jtxtEmail.addKeyListener(this);
        login.jtxtPassword.addKeyListener(this);
        
        cadastro.jtxtCpf.addKeyListener(this);
        cadastro.jtxtNome.addKeyListener(this);
        cadastro.jtxtEmail.addKeyListener(this);
        cadastro.jtxtEndereco.addKeyListener(this);
        cadastro.jtxtSenha.addKeyListener(this);
    }

    public static void main(String[] args) {
        new Sigea();
    }

    public void trocarTela(JPanel remove, JPanel novaTela) {

        Util.TELA_ATUAL = novaTela;
        Util.ULTIMA_TELA = remove;

        remove.setVisible(false);
        this.add(novaTela);
        novaTela.setVisible(true);
        novaTela.requestFocus();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login.jCadastro) {
            new Login();
            trocarTela(login, cadastro);
        }

        if (e.getSource() == entrada.jParticipante) {
            trocarTela(entrada, login);
        }

        if (e.getSource() == entrada.jFuncionario) {
            trocarTela(entrada, loginFuncionario);
        }

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

        util.JTextInit(tecla, login.jtxtEmail, "Email Pessoal");
        util.JTextInit(tecla, login.jtxtPassword, "Senha");
        
        util.JTextInit(tecla, cadastro.jtxtCpf, "Cpf");
        util.JTextInit(tecla, cadastro.jtxtNome, "Nome");
        util.JTextInit(tecla, cadastro.jtxtEmail, "Email");
        util.JTextInit(tecla, cadastro.jtxtSenha, "Senha");
        util.JTextInit(tecla, cadastro.jtxtEndereco, "Endereco");
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        util.JTextDelete(login.jtxtEmail, "Email Pessoal");
        util.JTextDelete(login.jtxtPassword, "Senha");
        
        util.JTextDelete(cadastro.jtxtCpf, "Cpf");
        util.JTextDelete(cadastro.jtxtNome, "Nome");
        util.JTextDelete(cadastro.jtxtEmail, "Email");
        util.JTextDelete(cadastro.jtxtSenha, "Senha");
        util.JTextDelete(cadastro.jtxtEndereco, "Endereco");

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == login.jtxtEmail) {
            login.jtxtEmail.setCaretPosition(0);
            clickUser = true;
            clickPassword = false;
        }

        if (e.getSource() == login.jtxtPassword) {
            login.jtxtPassword.setCaretPosition(0);
            clickPassword = true;
            clickUser = false;

        }

    }

    @Override
    public void mousePressed(MouseEvent e) { //se pressionar
        if (e.getSource() == login.jOlho) { //botao bressionado pelo mouse
            if (bot == false && !login.jtxtPassword.getText().equals(" Senha")) {
                login.jtxtPassword.requestFocus();
                login.jOlho.setIcon(null);
                login.jtxtPassword.setEchoChar('\u0000'); //revelar
            }
            bot = !bot;
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == login.jOlho) {
            if (bot && !login.jtxtPassword.getText().equals(" Senha")) {
                login.jOlho.setIcon(login.olhoCorte);
                login.jtxtPassword.requestFocus();
                login.jtxtPassword.setEchoChar('\u2022'); //ocultar
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
