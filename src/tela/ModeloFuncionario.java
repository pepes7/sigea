package tela;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ModeloFuncionario extends JPanel {

    protected Image img;
    protected Util util;
    protected JButton jSair,jAdicionar,jAlterar, jConsultar,jExcluir,jSalvar;
    protected JTextField jtxtNumero, jtxtNome, jtxtVagas;
    protected JTextField jtxtDataInicio, jtxtDataFim,jtxtHoraInicio, jtxtHoraFim;
    protected JTextField jtxtInscricaoDataInicio, jtxtInscricaoDataFim,jtxtInscricaoHoraInicio, jtxtInscricaoHoraFim;
    protected JLabel jlUsuario;

    public ModeloFuncionario() {
        setLayout(null);
        img = util.backgroundModeloFuncionario.getImage();
        
        jlUsuario = new JLabel();
        jlUsuario.setBounds(200, 15, 200, 22);
        jlUsuario.setFont(util.FONT_DEFAULT);
        jlUsuario.setForeground(Color.WHITE);
        
        
        jSair = util.jButtonInit(1140, 13, 40, 30,this, null);
        jAdicionar = util.jButtonInit(30, 130, 200, 100,this, null);
        jAlterar = util.jButtonInit(30, 300, 180, 100,this, null);
        jConsultar = util.jButtonInit(30, 470, 200, 100,this, null);
        jExcluir = util.jButtonInit(30, 620, 180, 100,this, null);
        jSalvar = new JButton("Salvar");

        
        jtxtNumero = new JTextField();
        jtxtNome = new JTextField();
        jtxtVagas = new JTextField();
        jtxtDataInicio = new JTextField();
        jtxtDataFim = new JTextField();
        jtxtHoraInicio = new JTextField();
        jtxtHoraFim = new JTextField();
        
        jtxtInscricaoDataInicio = new JTextField();
        jtxtInscricaoDataFim = new JTextField();
        jtxtInscricaoHoraInicio = new JTextField();
        jtxtInscricaoHoraFim = new JTextField();
        
        util.jTextInit(jtxtNumero, 320, 185, 415, 30, "Número", this);
        util.jTextInit(jtxtNome, 320, 285, 415, 30, "Nome", this);
        util.jTextInit(jtxtVagas, 320, 386, 415, 30, "Vagas", this);
        util.jTextInit(jtxtDataInicio, 320, 554, 125, 30, "02/12/2018", this);
        util.jTextInit(jtxtDataFim, 557, 554, 125, 30, "04/12/2018", this);
        util.jTextInit(jtxtHoraInicio, 320, 634, 125, 30, "16:40", this);
        util.jTextInit(jtxtHoraFim, 557, 634, 125, 30, "20:00", this);
        
        util.jTextInit(jtxtInscricaoDataInicio, 803, 554, 125, 30, "10/10/2018", this);
        util.jTextInit(jtxtInscricaoDataFim, 1039, 554, 125, 30, "28/11/2018", this);
        util.jTextInit(jtxtInscricaoHoraInicio, 803, 634, 125, 30, "10:00", this);
        util.jTextInit(jtxtInscricaoHoraFim, 1039, 634, 125, 30, "23:59", this);
        
               
        jSalvar.setBounds(1035,715,150,45);
        add(jSalvar);
        add(jlUsuario);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, img.getWidth(this), img.getHeight(this), null);
    }

}
