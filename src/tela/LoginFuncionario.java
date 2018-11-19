package tela;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFuncionario extends JPanel {

    protected Image img;
    protected Util util;
    protected JTextField jtxtEmail;
    protected JPasswordField jtxtSenha;
    protected JButton jEntrar;

    public LoginFuncionario() {
        setLayout(null);
        img = util.backgroundLoginFuncionario.getImage();

        jtxtEmail = new JTextField();
        jtxtSenha = new JPasswordField();

        //Definindo as configurações dos JtextFields
        util.jTextInit(jtxtEmail,util.JTXT_X, 345, util.JTX_TAMANHO_LARG, util.JTXT_TAMANHO_ALT,"Email Pessoal", this);
        util.jTextInit(jtxtSenha,util.JTXT_X, 412, util.JTX_TAMANHO_LARG, util.JTXT_TAMANHO_ALT,"Senha", this);
        
        //Botao para Entrar no Sistema como Funcionario
        jEntrar = new JButton();
        util.jButtonInit(jEntrar,485,510,200,45,false,false,this,null);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
    }

}
