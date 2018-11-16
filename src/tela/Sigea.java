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
        login.user.addKeyListener(this);
        login.password.addKeyListener(this);

        setTitle("SIGEA");
        setSize(login.img.getWidth(this), login.img.getHeight(this));
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        add(login);

        this.login.jCadastro.addActionListener(this);
        this.login.jCadastro.addMouseListener(this);
        this.login.jOlho.addMouseListener(this);
        this.login.user.addMouseListener(this);
        this.login.password.addMouseListener(this);

        this.cadastro.jCadastrar.addActionListener(this);
        this.entrada.jParticipante.addActionListener(this);
        this.entrada.jFuncionario.addActionListener(this);

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
    
        JTextInit(tecla,login.user,"Email Pessoal");
        JTextInit(tecla,login.password,"Senha");
    }

    @Override
    public void keyReleased(KeyEvent e){
        JTextDelete(login.user,"Email Pessoal");
        JTextDelete(login.password,"Senha");

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == login.user) {
            login.user.setCaretPosition(0);
            clickUser = true;
            clickPassword = false;
        }

        if (e.getSource() == login.password) {
            login.password.setCaretPosition(0);
            clickPassword = true;
            clickUser = false;

        }

    }

    @Override
    public void mousePressed(MouseEvent e) { //se pressionar
        if (e.getSource() == login.jOlho) { //botao bressionado pelo mouse
            if (bot == false && !login.password.getText().equals(" Senha")) {
                login.password.requestFocus();
                login.jOlho.setIcon(null);
                login.password.setEchoChar('\u0000'); //revelar
            }
            bot = !bot;
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == login.jOlho) {
            if (bot && !login.password.getText().equals(" Senha")) {
                login.jOlho.setIcon(login.olhoCorte);
                login.password.requestFocus();
                login.password.setEchoChar('\u2022'); //ocultar
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
    
    public static void updateText(){
        
    
    }
    
    public static void JTextDelete(JTextField txt, String st) { //metodo para rescrever o texto padrao no JTextField caso esteja vazio o campo
        if (txt.getText().isEmpty()) {
            txt.setFont(FONT_FIELDS);
            txt.setForeground(GRAY_LIGHT);
            txt.setText(st);
        }
    }
    public static void JTextDelete(JPasswordField txt, String st) { //metodo para rescrever o texto padrao no JPasswordField caso esteja vazio o campo
        if (txt.getText().isEmpty()) {
            txt.setFont(FONT_FIELDS);
            txt.setForeground(GRAY_LIGHT);
            txt.setText(st);
        }
    }

    public static void JTextInit(int tecla, JTextField txt, String st) { //metodo para apagar o texto no JTextField para o usuario digitar
        if (tecla != 0 && txt.getText().equals(st)) {
            txt.setText("");
            txt.setFont(FONT_DEFAULT);
            txt.setForeground(Color.BLACK);
        }
    }
    
    public static void JTextInit(int tecla, JPasswordField txt, String st) { //metodo para apagar o texto no JPasswordField para o usuario digitar
        if (tecla != 0 && txt.getText().equals(st)) {
            txt.setText("");
            txt.setFont(FONT_DEFAULT);
            txt.setForeground(Color.BLACK);
        }
    }


}
