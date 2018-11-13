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

        jParticipante = new JButton();
        jParticipante.setContentAreaFilled(false);
        jParticipante.setBorderPainted(false);
        jParticipante.setBounds(82, 340, 465,55);
        
        jFuncionario = new JButton();
        jFuncionario.setContentAreaFilled(false);
        jFuncionario.setBorderPainted(false);
        jFuncionario.setBounds(690, 340, 465,55);
        
        add(jParticipante);
        add(jFuncionario);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
    }

}
