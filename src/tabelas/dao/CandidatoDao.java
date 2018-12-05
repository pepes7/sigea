package tabelas.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import tabelas.Candidato;

public class CandidatoDao extends Dao{
    private static Candidato candidato;

    public CandidatoDao(){
        candidato = new Candidato();
    }
    
     public static void incluir(Candidato candidato) {
        String sql = "INSERT INTO candidato (cpfPessoa,senha) VALUES(?,?)";
        try (PreparedStatement pst = getConnection().prepareStatement(sql)) {
            pst.setString(1, candidato.getCpfPessoa());
            pst.setString(2, candidato.getSenha());
            
            pst.executeUpdate();
            pst.close();
            disconnection();
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
    }

    
}
