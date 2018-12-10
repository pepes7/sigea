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
    protected JButton jCadastrar,jOlho;

    public Cadastro() {
        img = util.backgroundCadastro.getImage();
        setLayout(null);
        
        jtxtCpf = new JTextField();
        jtxtNome = new JTextField();
        jtxtEmail = new JTextField();
        jtxtEndereco = new JTextField();
        jtxtSenha = new JPasswordField();
        
         //Definindo as confihurações dos JtextFields 
        util.jTextInit(jtxtCpf,330, 295, util.JTX_TAMANHO_LARG, util.JTXT_TAMANHO_ALT,"Cpf",this);
        util.jTextInit(jtxtNome, 330, 365, util.JTX_TAMANHO_LARG, util.JTXT_TAMANHO_ALT,"Nome",this);
        util.jTextInit(jtxtEmail, 330, 436, util.JTX_TAMANHO_LARG, util.JTXT_TAMANHO_ALT,"Email",this);
        util.jTextInit(jtxtSenha, 330, 505, util.JTX_TAMANHO_LARG, util.JTXT_TAMANHO_ALT,"Senha",this);
        util.jTextInit(jtxtEndereco, 330, 575, util.JTX_TAMANHO_LARG, util.JTXT_TAMANHO_ALT,"Endereço",this);   
        
        //Botao para Cadastrar pessoa             
        jCadastrar = util.jButtonInit(510, 660, 180, 45, this, null);
        jOlho = util.jButtonInit(885, 517, 30, 15, this, util.olhoCorte); 
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, img.getWidth(this), img.getHeight(this), null);
    }
}
