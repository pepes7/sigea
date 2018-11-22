package tela;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ModeloFuncionario extends JPanel {

    protected Image img;
    protected Util util;
    protected JButton jSair,jAdicionar,jAlterar, jConsultar,jExcluir;

    public ModeloFuncionario() {
        setLayout(null);
        img = util.backgroundModeloFuncionario.getImage();
        
        jSair = new JButton();
        jAdicionar = new JButton();
        jAlterar = new JButton();
        jConsultar = new JButton();
        jExcluir = new JButton();
        
        util.jButtonInit(jSair, 1140, 13, 40, 30, false, true, this, null);
        util.jButtonInit(jAdicionar, 30, 130, 200, 100, false, true, this, null);
        util.jButtonInit(jAlterar, 30, 300, 180, 100, false, true, this, null);
        util.jButtonInit(jConsultar, 30, 470, 200, 100, false, true, this, null);
        util.jButtonInit(jExcluir, 30, 620, 180, 100, false, true, this, null);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, img.getWidth(this), img.getHeight(this), null);
    }

}
