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
        util.jTextInit(jtxtMatricula,330, 360, util.JTX_TAMANHO_LARG, util.JTXT_TAMANHO_ALT,"Matricula", this);
        util.jTextInit(jtxtSenha,330, 430, util.JTX_TAMANHO_LARG, util.JTXT_TAMANHO_ALT,"Senha", this);
        
        //Botao para Entrar no Sistema como Funcionario
        jEntrar = util.jButtonInit(485,532,200,45,this,null);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, img.getWidth(this), img.getHeight(this), null);
    }

}
