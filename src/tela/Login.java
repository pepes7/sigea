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
        util.jTextInit(jtxtCpf, 417,304,363, 31,"Cpf", this);
        util.jTextInit(jtxtPassword, 417,363,363, 31,"Senha", this);

        jCadastro = new JButton();//botao para criar uma conta
        jOlho = new JButton();  //botao do olho para revelar senha
        jEntrar = new JButton();
        
        //Definindo as configurações para os Botões 
        util.jButtonInit(jCadastro, 662, 635, 160, 23, false, false, this, null);
        util.jButtonInit(jOlho, 790, 370, 30, 15, false, false, this, util.olhoCorte);
        util.jButtonInit(jEntrar, 550, 470, 110, 50, false, false, this, null);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
    }

}
