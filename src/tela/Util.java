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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Gabriel
 */
public class Util {

    public final static Color GRAY_LIGHT = new Color(157, 156, 156);
    public final static Font FONT_FIELDS = new Font("Arial Narrow", Font.ITALIC, 25); //fonte para os jtextField
    public final static Font FONT_DEFAULT = new Font("Arial Narrow", Font.PLAIN, 25); //fonte padrão de escrita

    public static JPanel TELA_ATUAL;
    public static JPanel ULTIMA_TELA;

    public final static ImageIcon backgroundLogin = new ImageIcon("res//back.png");
    public final static ImageIcon backgroundEntrada = new ImageIcon("res//Entrada.png");
    public final static ImageIcon backgroundLoginFuncionario = new ImageIcon("res//LoginFuncionario.png");
    public final static ImageIcon backgroundCadastro = new ImageIcon("res//back_Cadastro.png");
    public final static ImageIcon backgroundModelo = new ImageIcon("res//Modelo.png");
    public final static ImageIcon backgroundModeloFuncionario = new ImageIcon("res//ModeloFuncionario.png");
    
    public final static ImageIcon cadastroSublinhado = new ImageIcon("res//sublinhado.png");
    public final static ImageIcon olhoCorte = new ImageIcon("res//olhoCorte.png");
    
    public final static int JTX_TAMANHO_LARG = 543; //tamanho da Largura dos JTextFields da Classe Cadastro
    public final static int JTXT_TAMANHO_ALT = 35; //tamanho da Altura dos JTextFields da Classe Cadastro
    public final static int JTXT_X = 328;    // X  dos JTextFields da Classe Cadastro

    //metodo para Configurar um botao
    public static void jButtonInit(JButton button, int x, int y, int tamLarg, int tamAlt, boolean area, boolean borda, JPanel panel, ImageIcon icon) {
        button.setIcon(icon);
        button.setContentAreaFilled(area);
        button.setBorderPainted(borda);
        button.setBounds(x, y, tamLarg, tamAlt);
        panel.add(button);
    }

    public static void jTextInit(JTextField txt, int x, int y, int tamLarg, int tamAlt, String st, JPanel panel) {
        txt.setBounds(x, y, tamLarg, tamAlt);
        txt.setBorder(null);
        txt.setFont(FONT_FIELDS);
        txt.setForeground(GRAY_LIGHT);
        txt.setText(st);
        panel.add(txt);

    }

    public static void jTextInit(JPasswordField txt, int x, int y, int tamLarg, int tamAlt, String st, JPanel panel) {
        txt.setBounds(x, y, tamLarg, tamAlt);
        txt.setBorder(null);
        txt.setFont(FONT_FIELDS);
        txt.setForeground(GRAY_LIGHT);
        txt.setEchoChar('\u0000');
        txt.setText(st);
        panel.add(txt);
    }

    //metodo para rescrever o texto padrao no JTextField caso esteja vazio o campo
    public static void jTextRewrite(JTextField txt, String st) {
        if (txt.getText().isEmpty()) {
            txt.setFont(FONT_FIELDS);
            txt.setForeground(GRAY_LIGHT);
            txt.setText(st);
            txt.setCaretPosition(0);
        }
    }

    //metodo para rescrever o texto padrao no JPasswordField caso esteja vazio o campo
    public static void jTextRewrite(JPasswordField txt, String st) {
        if (txt.getText().isEmpty()) {
            txt.setEchoChar('\u0000');
            txt.setFont(FONT_FIELDS);
            txt.setForeground(GRAY_LIGHT);
            txt.setText(st);
            txt.setCaretPosition(0);
        }
    }

    //metodo para apagar o texto no JTextField para o usuario digitar
    public static void jTextDelete(int tecla, JTextField txt, String st) {
        if (tecla != 0 && txt.getText().equals(st) && txt.isFocusOwner()) {
            txt.setText("");
            txt.setFont(FONT_DEFAULT);
            txt.setForeground(Color.BLACK);
        }
    }

    //metodo para apagar o texto no JPasswordField para o usuario digitar
    public static void jTextDelete(int tecla, JPasswordField txt, String st) {
        if (tecla != 0 && txt.getText().equals(st) && txt.isFocusOwner()) {
            txt.setText("");
            txt.setEchoChar('\u2022');
            txt.setFont(FONT_DEFAULT);
            txt.setForeground(Color.BLACK);
        }
    }

}
