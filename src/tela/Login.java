package tela;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JPanel {
    protected Image img;
    protected JTextField jtxtCpf;
    protected JPasswordField jtxtPassword;
    protected Util util;
    protected JButton jCadastro, jOlho, jEntrar;

    public Login() {
        setLayout(null);
        img = util.backgroundLogin.getImage();

        jtxtCpf = new JTextField();
        jtxtPassword = new JPasswordField();
        
         //Definindo as configurações dos JtextFields 
        util.jTextInit(jtxtCpf, 419,320,363, 31,"CPF", this);
        util.jTextInit(jtxtPassword, 420,379,363, 31,"Senha", this);

        jCadastro = util.jButtonInit(662, 665, 160, 23,this, null);//botao para criar uma conta
        jOlho = util.jButtonInit(794, 387, 30, 15, this, util.olhoCorte);//botao do olho para revelar senha
        jEntrar = util.jButtonInit(550, 500, 110, 50,this, null);       
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, img.getWidth(this), img.getHeight(this), null);
    }

}
