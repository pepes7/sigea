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
        util.jTextInit(jtxtCpf, util.JTXT_X, 282, util.JTX_TAMANHO_LARG, util.JTXT_TAMANHO_ALT,"Cpf",this);
        util.jTextInit(jtxtNome, util.JTXT_X, 349, util.JTX_TAMANHO_LARG, util.JTXT_TAMANHO_ALT,"Nome",this);
        util.jTextInit(jtxtEmail, util.JTXT_X, 416, util.JTX_TAMANHO_LARG, util.JTXT_TAMANHO_ALT,"Email",this);
        util.jTextInit(jtxtSenha, util.JTXT_X, 483, util.JTX_TAMANHO_LARG, util.JTXT_TAMANHO_ALT,"Senha",this);
        util.jTextInit(jtxtEndereco, util.JTXT_X, 550, util.JTX_TAMANHO_LARG, util.JTXT_TAMANHO_ALT,"Endereço",this);   
        
        //Botao para Cadastrar pessoa             
        jCadastrar = util.jButtonInit(510, 630, 180, 45, this, null);
        jOlho = util.jButtonInit(880, 493, 30, 15, this, util.olhoCorte); 
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
    }
}
