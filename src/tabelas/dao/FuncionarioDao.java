package tabelas.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import tabelas.Funcionario;
import static tabelas.dao.Dao.disconnection;
import static tabelas.dao.Dao.getConnection;

public class FuncionarioDao extends Dao{
    private static Funcionario funcionario;
    
    public FuncionarioDao(){
        funcionario = new Funcionario();
    }
    
     public static void incluir(Funcionario funcionario) {
        String sql = "insert into funcionario values (?, ?,?,?)";
        try (PreparedStatement pst = getConnection().prepareStatement(sql)) {
            pst.setInt(1, funcionario.getMatricula());
            pst.setString(2, funcionario.getCpfPessoa());
            pst.setInt(3, funcionario.getCodDepartamento());
            pst.setString(4, funcionario.getSenha());
            
            pst.executeUpdate();
            pst.close();
            disconnection();
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
    }
     
      
    
}
