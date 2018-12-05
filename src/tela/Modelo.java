package tela;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Modelo extends JPanel{
    protected Image img;
    protected Util util;
    protected JButton jEventos, jInscricao,jSair;
    protected JLabel jlUsuario;
    
    public Modelo(){
        setLayout(null);
        img = util.backgroundModelo.getImage();
        
        jlUsuario = new JLabel();
        jlUsuario.setBounds(200, 15, 200, 22);
        jlUsuario.setFont(util.FONT_DEFAULT);
        jlUsuario.setForeground(Color.WHITE);
        
        jEventos = util.jButtonInit(50, 205, 155, 50,this, null);
        jInscricao = util.jButtonInit( 50, 350, 185, 50,this, null);
        jSair = util.jButtonInit(1140, 13, 40, 30,this, null);    
                
        add(jlUsuario);
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(img, 0, 0,img.getWidth(this), img.getHeight(this), null);
    }
}
