package mvc.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import mvc.model.Resposta;

public class RespostaDao {
    Connection connec;

    public RespostaDao(Connection connec) {
        this.connec = connec;
    }

    public void resposta(Resposta resposta, long Idpergunta)throws SQLException {
         String sql = "INSERT INTO resposta VALUES(?,?,?,?)";
         PreparedStatement ps = connec.prepareStatement(sql);
         ps.setLong(1, resposta.getIdResposta());
         ps.setString(2, resposta.getTexto());
         ps.setInt(3, resposta.getCorreta());
         ps.setLong(4, Idpergunta);
         ps.executeUpdate();
         ps.close();


    }
    
}
