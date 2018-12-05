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
    protected JTextField jtxtMatricula;
    protected JPasswordField jtxtSenha;
    protected JButton jEntrar;

    public LoginFuncionario() {
        setLayout(null);
        img = util.backgroundLoginFuncionario.getImage();

        jtxtMatricula = new JTextField();
        jtxtSenha = new JPasswordField();

        //Definindo as configurações dos JtextFields
        util.jTextInit(jtxtMatricula,util.JTXT_X, 345, util.JTX_TAMANHO_LARG, util.JTXT_TAMANHO_ALT,"Matricula", this);
        util.jTextInit(jtxtSenha,util.JTXT_X, 412, util.JTX_TAMANHO_LARG, util.JTXT_TAMANHO_ALT,"Senha", this);
        
        //Botao para Entrar no Sistema como Funcionario
        jEntrar = util.jButtonInit(485,510,200,45,this,null);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
    }

}
