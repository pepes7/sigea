package tela;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Modelo extends JPanel{
    protected Image img;
    protected Util util;
    protected JButton jEventos, jInscricao,jSair;
    public Modelo(){
        setLayout(null);
        img = util.backgroundModelo.getImage();
        
        
        jEventos = new JButton();
        jInscricao = new JButton();
        jSair = new JButton();
        
        util.jButtonInit(jEventos, 50, 205, 155, 50, false, true, this, null);
        util.jButtonInit(jInscricao, 50, 350, 185, 50, false, true, this, null);
        util.jButtonInit(jSair, 1140, 13, 40, 30, false, true, this, null);
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(img, 0, 0,img.getWidth(this), img.getHeight(this), null);
    }
}
