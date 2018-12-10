package tabelas.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
