package mvc.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import mvc.dao.RespostaDao;
import mvc.model.Resposta;

public class RespostaService {
    private RespostaDao respostaDao;

    public RespostaService (Connection con) {
        this.respostaDao = new RespostaDao(con);
    }

     public ResultadoResposta responder(long idResposta) throws SQLException {

        boolean correta = respostaDao.respostaEstaCorreta(idResposta);

        if (correta) {
            return ResultadoResposta.CORRETA;
        } else {
            return ResultadoResposta.INCORRETA;
        }
    }
}

