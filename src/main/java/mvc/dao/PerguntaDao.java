package mvc.dao;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mvc.model.Pergunta;;

public class PerguntaDao {
    Connection connec;

    public PerguntaDao(Connection connec) {
        this.connec = connec;
    }


 public List<Pergunta> lista() throws SQLException {
    List<Pergunta> perg = new ArrayList<>();
    String sql = "SELECT * FROM pergunta";

    Statement stm = connec.createStatement();
    ResultSet rs = stm.executeQuery(sql);

    while (rs.next()) {
        Pergunta pergunta = new Pergunta(
                rs.getLong("id_pergunta"),         
                rs.getString("texto"),
                rs.getString("dificuldade")
        );
        perg.add(pergunta);
    }

    rs.close();
    stm.close();
    return perg;
}

    
}
