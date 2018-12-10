package tela;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Entrada extends JPanel {

    protected Image img;
    protected Util util;
    protected JButton jParticipante, jFuncionario;

    public Entrada() {
        setLayout(null);
        img = util.backgroundEntrada.getImage();

        //Botão para entrar como Participante
        jParticipante = util.jButtonInit(82, 347, 465, 55, this, null);
        
        //Botão para entrar como Funcionario
        jFuncionario = util.jButtonInit(690, 347, 465, 55,this, null);
        
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0,img.getWidth(this), img.getHeight(this), null);
    }

}
