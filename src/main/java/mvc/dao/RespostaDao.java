package mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mvc.model.Pergunta;
import mvc.model.Resposta;

public class RespostaDao {
    Connection connec;

    public RespostaDao(Connection connec) {
        this.connec = connec;
    }

    public List<Resposta> buscarRespostas(long idPergunta) throws SQLException {
        List<Resposta> respostas = new ArrayList<>();

        String sql = """
                    SELECT id_resposta, texto, correta
                    FROM resposta
                    WHERE id_pergunta = ?
                """;

        PreparedStatement ps = connec.prepareStatement(sql);
        ps.setLong(1, idPergunta);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Resposta r = new Resposta();
            r.setIdResposta(rs.getInt("id_resposta"));
            r.setTexto(rs.getString("texto"));
            r.setCorreta(rs.getInt("correta"));
            respostas.add(r);

            Pergunta p = new Pergunta();
            p.setId_pergunta(idPergunta);
            r.setPergunta(p);

        }

        return respostas;
    }

}
