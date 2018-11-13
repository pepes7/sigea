/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Gabriel
 */
public class Util {

    public final static Color GRAY_LIGHT = new Color(157, 156, 156);
    public final static Color PURPLE = new Color(168,102,237);
    public final static Font FONT_FIELDS =  new Font("Arial Narrow", Font.ITALIC, 20); //fonte para os jtextField
    public final static Font FONT_DEFAULT =  new Font("Arial Narrow", Font.PLAIN, 25); //fonte padrão de escrita
    public static JPanel TELA_ATUAL;
    public static JPanel ULTIMA_TELA;
    public final static ImageIcon background = new ImageIcon("res//back.png");
    public final static ImageIcon cadastroSublinhado = new ImageIcon("res//sublinhado.png");
    public final static ImageIcon background_cadastro = new ImageIcon("res//back_Cadastro.png");
    public final static int JTX_TAMANHO_LARG = 543; //tamanho da Largura dos JTextFields da Classe Cadastro
    public final static int JTXT_TAMANHO_ALT = 35; //tamanho da Altura dos JTextFields da Classe Cadastro
    public final static int JTXT_X = 328;    // X  dos JTextFields da Classe Cadastro
    public final static ImageIcon backgroundEntrada = new ImageIcon("res//Entrada.png");
    

}
