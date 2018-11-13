package tabelas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;

import tabelas.Pessoa;

public class PessoaDAO {

    private static Connection connection = null;
    private static Pessoa pessoa;

    public PessoaDAO() {
        pessoa = new Pessoa();
    }

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/sigea", "root", "");
            connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
        return connection;
    }

    public static void disconnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
    }

    public static Pessoa getPessoa() {
        return pessoa;
    }

    public static void incluir(Pessoa pessoa) {
        String sql = "INSERT INTO Pessoa VALUES(?,?,?,?,?)";
        try (PreparedStatement pst = getConnection().prepareStatement(sql)) {
            pst.setString(1, pessoa.getCpf());
            pst.setString(2, pessoa.getNome());
            pst.setString(3, pessoa.getEmail());
            pst.setString(4, pessoa.getSenha());
            pst.setString(5, pessoa.getEndereco());

            pst.executeUpdate();
            pst.close();
            disconnection();
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
    }

    public static void deletar(String cpf) {
        String sql = "DELETE FROM Pessoa WHERE cpf = " + cpf;
        try (PreparedStatement pst = getConnection().prepareStatement(sql)) {
            pst.executeUpdate(sql);
            pst.close();
            disconnection();
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
    }

    public static void alterar(Pessoa pessoa) {
        String sql = "UPDATE Pessoa SET nome = ?, email = ?, senha = ?,endereco = ? WHERE cpf = ?";
        try (PreparedStatement pst = getConnection().prepareStatement(sql)) {
            pst.setString(1, pessoa.getNome());
            pst.setString(2, pessoa.getEmail());
            pst.setString(3, pessoa.getSenha());
            pst.setString(4, pessoa.getEndereco());
            pst.setString(5, pessoa.getCpf());
            pst.executeUpdate();
            pst.close();
            disconnection();
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
    }

    public static void pesquisar(String cpf, JTextField jTxtCpf, JTextField jTxtNome,JTextField jTxtEmail, JTextField jTxtSenha, JTextField jTxtEndereco) {
        String sql = "SELECT * FROM Pessoa WHERE cpf = " + cpf;
        try (PreparedStatement pst = getConnection().prepareStatement(sql)) {
            ResultSet rs = pst.executeQuery(sql);
            while (rs.next()) {
                jTxtCpf.setText(rs.getString(1));
                jTxtNome.setText(rs.getString(2));
                jTxtEmail.setText(rs.getString(3));
                jTxtSenha.setText(rs.getString(4));
                jTxtEndereco.setText(rs.getString(5));
            }

            pst.close();
            disconnection();
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
    }

    public List<Pessoa> getLista(){
        List<Pessoa> pessoas =new ArrayList<>();
        String sql = "select * from pessoa";
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                Pessoa pessoa=new Pessoa();
                // atribui os valores recuperados do banco 
                // para classe Contato
                pessoa.setCpf(rs.getString("cpf"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setEmail(rs.getString("email"));
                pessoa.setSenha(rs.getString("senha"));
                pessoa.setEndereco(rs.getString("endereco"));
                // adiciona o contato no ArrayList
                pessoas.add(pessoa);
            }
            ps.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return pessoas;
    }
}