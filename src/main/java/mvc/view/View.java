package mvc.view;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.sql.Connection;

import mvc.Conector;
import mvc.dao.PerguntaDao;
import mvc.dao.RespostaDao;
import mvc.model.Pergunta;

public class View {

    public static void view() {
        Boolean carregar = true;
        Scanner teclado = new Scanner(System.in);

        try {
            Connection con = Conector.conectar();
            PerguntaDao perguntaDao = new PerguntaDao(con);
            RespostaDao respostaDao = new RespostaDao(con);

            while (carregar) {
                System.out.println("================== Menu ==================");
                System.out.println("[1]- Jogar");
                System.out.println("[2]- Sair");

                int opc = teclado.nextInt();
                teclado.nextLine();

                switch (opc) {
                    case 1:
                        List<Pergunta> perguntas = perguntaDao.lista();
                        for(Pergunta p: perguntas) {
                            System.out.println(p);
                        }
                        System.out.println("deia Enter caso deseje continuar!");
                        teclado.nextLine();
                       
                        break;

                    case 2:
                        carregar = false;
                    default:
                        break;
                }

            }

        } catch (SQLException e) {
            System.err.println("Erro de base de dados."+e.getMessage());
        }
    }

}
