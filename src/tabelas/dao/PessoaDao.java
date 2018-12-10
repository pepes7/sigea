package tabelas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import tabelas.Pessoa;

public class PessoaDao extends Dao{

    private static Connection connection = null;
    private static Pessoa pessoa;
    
    public PessoaDao() {
        pessoa = new Pessoa();
    }

    public static void incluir(Pessoa pessoa) {
        String sql = "INSERT INTO Pessoa VALUES(?,?,?,?)";
        try (PreparedStatement pst = getConnection().prepareStatement(sql)) {
            pst.setString(1, pessoa.getCpf());
            pst.setString(2, pessoa.getNome());
            pst.setString(3, pessoa.getEmail());
            pst.setString(4, pessoa.getEndereco());
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
        String sql = "UPDATE Pessoa SET nome = ?, email = ?,endereco = ? WHERE cpf = ?";
        try (PreparedStatement pst = getConnection().prepareStatement(sql)) {
            pst.setString(1, pessoa.getNome());
            pst.setString(2, pessoa.getEmail());
            pst.setString(3, pessoa.getEndereco());
            pst.setString(4, pessoa.getCpf());
            pst.executeUpdate();
            pst.close();
            disconnection();
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
    }

    public static void pesquisar(String cpf, JTextField jTxtCpf, JTextField jTxtNome, JTextField jTxtEmail, JTextField jTxtEndereco) {
        String sql = "SELECT * FROM Pessoa WHERE cpf = " + cpf;
        try (PreparedStatement pst = getConnection().prepareStatement(sql)) {
            ResultSet rs = pst.executeQuery(sql);
            while (rs.next()) {
                jTxtCpf.setText(rs.getString(1));
                jTxtNome.setText(rs.getString(2));
                jTxtEmail.setText(rs.getString(3));
                jTxtEndereco.setText(rs.getString(4));
            }

            pst.close();
            disconnection();
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
    }

    public static boolean loginCandidato(JTextField jtxtCpf, JPasswordField jtxtSenha) {
        String sql = "select cpf,senha from pessoa join candidato on cpfPessoa = cpf and cpf = " + jtxtCpf.getText();
        try (PreparedStatement pst = getConnection().prepareStatement(sql)) {
            ResultSet rs = pst.executeQuery(sql);
            while (rs.next()) {
                if (jtxtCpf.getText().equals(rs.getString(1)) && jtxtSenha.getText().equals(rs.getString(2))) {
                    pst.close();
                    disconnection();
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
        return false;
    }

    public static boolean loginFuncionario(JTextField jtxtMatricula, JPasswordField jtxtSenha){
        String sql = "select matricula,senha from Funcionario where matricula = " + jtxtMatricula.getText();
        try (PreparedStatement pst = getConnection().prepareStatement(sql)) {
            ResultSet rs = pst.executeQuery(sql);
            while (rs.next()){
 
                if (jtxtMatricula.getText().equals(rs.getString(1)) && jtxtSenha.getText().equals(rs.getString(2))) {
                    pst.close();
                    disconnection();
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
        return false;
    }

    public List<Pessoa> getLista() {
        List<Pessoa> pessoas = new ArrayList<>();
        String sql = "select * from pessoa";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pessoa pessoa = new Pessoa();
                // atribui os valores recuperados do banco 
                // para classe Contato
                pessoa.setCpf(rs.getString("cpf"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setEmail(rs.getString("email"));
                pessoa.setEndereco(rs.getString("endereco"));
                // adiciona o contato no ArrayList
                pessoas.add(pessoa);
            }
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pessoas;
    }

    public static String nomeFuncionario(JTextField jtxtMatricula) {
        String st = "";
        String sql = "select nome from pessoa join Funcionario on cpfPessoa = cpf and matricula = " + jtxtMatricula.getText();
        try (PreparedStatement pst = getConnection().prepareStatement(sql)) {
            ResultSet rs = pst.executeQuery(sql);
            while (rs.next()) {
                st = rs.getString(1);
                pst.close();
                disconnection();
                return st;

            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
        return st;
    }
    
    public static String nomeCandidato(JTextField jtxtCpf) {
        String st = "";
        String sql = " select nome from pessoa where  cpf = " + jtxtCpf.getText();
        try (PreparedStatement pst = getConnection().prepareStatement(sql)) {
            ResultSet rs = pst.executeQuery(sql);
            while (rs.next()) {
                st = rs.getString(1);
                pst.close();
                disconnection();
                return st;

            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
        return st;
    }
}
