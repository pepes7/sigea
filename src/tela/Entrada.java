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
        jParticipante = new JButton();
        util.jButtonInit(jParticipante, 82, 340, 465, 55, false, false, this, null);

        //Botão para entrar como Funcionario
        jFuncionario = new JButton();
        util.jButtonInit(jFuncionario, 690, 340, 465, 55, false, false, this, null);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
    }

}
