package tela;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FuncionarioAlterar extends JPanel {

    protected Image img;
    protected Util util;
    protected JButton jSair, jAdicionar, jConsultar, jExcluir, jPesquisar;
    protected JTextField jtxtPesquisar;
    protected JLabel jlUsuario;

    public FuncionarioAlterar() {
        setLayout(null);
        img = util.backgroundFuncionarioAlterar.getImage();

        jlUsuario = new JLabel("Bem Vindo " + Util.nomeFuncionario);
        jlUsuario.setBounds(200, 15, 200, 22);
        jlUsuario.setFont(util.FONT_DEFAULT);
        jlUsuario.setForeground(Color.WHITE);

        jtxtPesquisar = new JTextField();
        Util.jTextInit(jtxtPesquisar, 534, 275, 205, 30,"Número do Evento", this);
        
        jSair = util.jButtonInit(1140, 13, 40, 30, this, null);
        jAdicionar = util.jButtonInit(30, 130, 200, 100, this, null);
        jConsultar = util.jButtonInit(30, 470, 200, 100, this, null);
        jExcluir = util.jButtonInit(30, 620, 180, 100, this, null);
        
        jPesquisar = new JButton("Pesquisar");

        
        jPesquisar.setBounds(1035, 715, 150, 45);
        add(jPesquisar);
        add(jlUsuario);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, img.getWidth(this), img.getHeight(this), null);
    }

}
