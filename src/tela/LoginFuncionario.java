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
    JButton jEntrar;

    public LoginFuncionario() {
        setLayout(null);
        img = util.backgroundLoginFuncionario.getImage();

        jtxtEmail = new JTextField();
        jtxtSenha = new JPasswordField();

        jtxtEmail.setBounds(util.JTXT_X, 345, util.JTX_TAMANHO_LARG, util.JTXT_TAMANHO_ALT);
        jtxtSenha.setBounds(util.JTXT_X, 412, util.JTX_TAMANHO_LARG, util.JTXT_TAMANHO_ALT);

        jtxtEmail.setBorder(null);
        jtxtSenha.setBorder(null);

        jtxtEmail.setFont(util.FONT_DEFAULT);
        jtxtSenha.setFont(util.FONT_DEFAULT);
        
        util.JButtonInit(jEntrar,485,510,200,45,false,false,this);
        
        

        add(jtxtEmail);
        add(jtxtSenha);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
    }

}
