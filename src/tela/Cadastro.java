package tela;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Gabriel
 */
public class Cadastro extends JPanel {

    protected Image img;
    protected Util util;
    protected JTextField jtxtCpf, jtxtNome, jtxtEmail, jtxtEndereco;
    protected JPasswordField jtxtSenha;
    protected JButton jCadastrar;

    public Cadastro() {
        img = util.background_cadastro.getImage();
        setLayout(null);
        
        jCadastrar = new JButton();
        jCadastrar.setContentAreaFilled(false);
        jCadastrar.setBorderPainted(false);
        jCadastrar.setBounds(510,630,180,45);

        jtxtCpf = new JTextField();
        jtxtNome = new JTextField();
        jtxtEmail = new JTextField();
        jtxtEndereco = new JTextField();
        jtxtSenha = new JPasswordField();
        
        //Definindo as confihurações dos JtextFields 
        jtxtCpf.setBounds(util.JTXT_X,282,util.JTX_TAMANHO_LARG,util.JTXT_TAMANHO_ALT);      
        jtxtNome.setBounds(util.JTXT_X,349,util.JTX_TAMANHO_LARG,util.JTXT_TAMANHO_ALT);   
        jtxtEmail.setBounds(util.JTXT_X,416,util.JTX_TAMANHO_LARG,util.JTXT_TAMANHO_ALT);
        jtxtSenha.setBounds(util.JTXT_X,483,util.JTX_TAMANHO_LARG,util.JTXT_TAMANHO_ALT);
        jtxtEndereco.setBounds(util.JTXT_X,550,util.JTX_TAMANHO_LARG,util.JTXT_TAMANHO_ALT);
        
        //Tirando as Bordas dos JTextFields
        jtxtCpf.setBorder(null);
        jtxtNome.setBorder(null);
        jtxtEmail.setBorder(null);
        jtxtSenha.setBorder(null);
        jtxtEndereco.setBorder(null);
        
        //Define o tamanho e fonte dos textos
        jtxtCpf.setFont(util.FONT_DEFAULT);
        jtxtNome.setFont(util.FONT_DEFAULT);
        jtxtEmail.setFont(util.FONT_DEFAULT);
        jtxtSenha.setFont(util.FONT_DEFAULT);
        jtxtEndereco.setFont(util.FONT_DEFAULT);
        
        //Adicionando no JPanel
        add(jtxtCpf);
        add(jtxtNome);
        add(jtxtEmail);
        add(jtxtSenha);
        add(jtxtEndereco);
        add(jCadastrar);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
    }

}
