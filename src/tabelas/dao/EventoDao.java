package tabelas.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import tabelas.Evento;
import tabelas.Funcionario;
import static tabelas.dao.Dao.disconnection;
import static tabelas.dao.Dao.getConnection;

public class EventoDao extends Dao{
     private static Evento evento;
     private Funcionario funcionario;
     
     public  void incluir(Evento evento) {
        String sql = "insert into evento values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement pst = getConnection().prepareStatement(sql)) {
            pst.setInt(1, evento.getNumero());
            pst.setInt(2,evento.getMatFuncSolicita());
            pst.setInt(3, evento.getMatFuncAutoriza());
            pst.setString(4, evento.getNome());
            pst.setInt(5, evento.getQtdePessoas());
            pst.setString(6, evento.getDataInicio());
            pst.setString(7, evento.getDataFim());
            pst.setString(8, evento.getHoraInicio());
            pst.setString(9, evento.getHoraFim());
            pst.setString(10, evento.getHoraInscricaoInicio());
            pst.setString(11, evento.getHoraInscricaoFim());
            pst.setString(12, evento.getDataInscricaoInicio());
            pst.setString(13, evento.getDataInscricaoFim());
            
            pst.executeUpdate();
            pst.close();
            disconnection();
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
    }
     public static void pesquisar(JTextField jtxtPesquisar,JTextField jtxtNumero, JTextField jtxtNome, JTextField jtxtVagas, JTextField jtxtDataInicio,JTextField jtxtDataFim,JTextField jtxtHoraInicio,JTextField jtxtHoraFim,JTextField jtxtInscricaoDataInicio,JTextField jtxtInscricaoDataFim,JTextField jtxtInscricaoHoraInicio,JTextField jtxtInscricaoHoraFim) {
        String sql = "SELECT numero,nome,qtdePessoas,dataInicio,dataFim,horaInicio,horaFim,horaInscricaoInicio,horaInscricaoFim,dataInscricaoInicio,dataInscricaoFim FROM evento WHERE numero = " + jtxtPesquisar.getText();
        try (PreparedStatement pst = getConnection().prepareStatement(sql)) {
            ResultSet rs = pst.executeQuery(sql);
            while (rs.next()) {
                jtxtNumero.setText(rs.getString(1));
                jtxtNome.setText(rs.getString(2));
                jtxtVagas.setText(rs.getString(3));
                jtxtDataInicio.setText(rs.getString(4));
                jtxtDataFim.setText(rs.getString(5));
                jtxtHoraInicio.setText(rs.getString(6));
                jtxtHoraFim.setText(rs.getString(7));
                jtxtInscricaoDataInicio.setText(rs.getString(8));
                jtxtInscricaoDataFim.setText(rs.getString(9));
                jtxtInscricaoHoraInicio.setText(rs.getString(10));
                jtxtInscricaoHoraFim.setText(rs.getString(11));
            }

            pst.close();
            disconnection();
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
    }

    public static boolean pesquisarNumEvento(JTextField jtxtNumero) {
        String sql = "select numero from evento where numero = " + jtxtNumero.getText();
        try (PreparedStatement pst = getConnection().prepareStatement(sql)) {
            ResultSet rs = pst.executeQuery(sql);
            while (rs.next()) {
                if (jtxtNumero.getText().equals(rs.getString(1))){
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
    
     public static void alterar(Evento evento) {
        String sql = "UPDATE evento SET nome = ?, qtdePessoas = ?,dataInicio = ?,dataFim = ? ,horaInicio = ? ,horaFim = ? ,horaInscricaoInicio = ? ,horaInscricaoFim = ?,dataInscricaoInicio = ? ,dataInscricaoFim = ?  WHERE numero = " +evento.getNumero();
        try (PreparedStatement pst = getConnection().prepareStatement(sql)) {
            pst.setString(1, evento.getNome());
            pst.setInt(2, evento.getQtdePessoas());
            pst.setString(3, evento.getDataInicio());
            pst.setString(4, evento.getDataFim());
            pst.setString(5, evento.getHoraInicio());
            pst.setString(6, evento.getHoraFim());
            pst.setString(7, evento.getHoraInscricaoInicio());
            pst.setString(8, evento.getHoraInscricaoFim());
            pst.setString(9, evento.getDataInscricaoInicio());
            pst.setString(10, evento.getDataInscricaoFim());
            
            pst.executeUpdate();
            pst.close();
            disconnection();
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
    }

     
        
}
