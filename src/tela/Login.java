package tela;


import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Login extends JPanel{
    protected ImageIcon cadastro,cadastroSublinhado,olhoCorte;
    protected Image img;
    protected JTextField jtxtEmail;
    protected JPasswordField jtxtPassword;
    protected Util util;
    protected JButton jCadastro, jOlho;
    
    int largura, altura;
    
    public Login(){    
        olhoCorte = new ImageIcon("res//olhoCorte.png");
        cadastro = new ImageIcon("res//Cadastre-se.png");
        cadastroSublinhado = new ImageIcon("res//Cadastre-se_Sublinhado.png");
        img = util.background.getImage();
        jtxtEmail = new JTextField();
        jtxtPassword = new JPasswordField();
        setLayout(null);
        
        jtxtEmail.setBounds(417,304,363,31); 
        jtxtEmail.setBorder(null);
        jtxtPassword.setBorder(null);
        jtxtPassword.setBounds(417,363,363,31);
        jtxtEmail.setForeground(util.GRAY_LIGHT);
        jtxtEmail.setFont(util.FONT_FIELDS);
        jtxtPassword.setForeground(util.GRAY_LIGHT);
        jtxtPassword.setFont(util.FONT_FIELDS);
      
        
        jtxtEmail.setText("Email Pessoal");
      
        jtxtPassword.setEchoChar('\u0000');
        jtxtPassword.setText("Senha");
        
        jCadastro = new JButton();       //botao para criar uma conta
        jCadastro.setContentAreaFilled(false);
        jCadastro.setBorderPainted(false);
        jCadastro.setBounds(662,635,160,23);
       
        jOlho = new JButton(); //botao do olho
        jOlho.setIcon(olhoCorte);
        jOlho.setContentAreaFilled(false);
        jOlho.setBorderPainted(false);
        jOlho.setBounds(790,370,30,15);
        
        add(jOlho);
        add(jCadastro);
        add(jtxtEmail);
        add(jtxtPassword);
        jtxtEmail.requestFocus(true);
        
   
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(img, 0, 0,this.getWidth(),this.getHeight(),this);
        //g.setColor(Util.PURPLE);
        //g.fillRect(0,0,getWidth(),getHeight());
        
    }
    
}
