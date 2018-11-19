package tela;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JPanel {
    protected Image img;
    protected JTextField jtxtEmail;
    protected JPasswordField jtxtPassword;
    protected Util util;
    protected JButton jCadastro, jOlho;

    public Login() {
        setLayout(null);
        img = util.backgroundLogin.getImage();

        jtxtEmail = new JTextField();
        jtxtPassword = new JPasswordField();
        
         //Definindo as configurações dos JtextFields 
        util.jTextInit(jtxtEmail, 417,304,363, 31,"Email Pessoal", this);
        util.jTextInit(jtxtPassword, 417,363,363, 31,"Senha", this);

        jCadastro = new JButton();//botao para criar uma conta
        jOlho = new JButton();  //botao do olho para revelar senha
        
        //Definindo as configurações para os Botões 
        util.jButtonInit(jCadastro, 662, 635, 160, 23, false, false, this, null);
        util.jButtonInit(jOlho, 790, 370, 30, 15, false, false, this, util.olhoCorte);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
    }

}
