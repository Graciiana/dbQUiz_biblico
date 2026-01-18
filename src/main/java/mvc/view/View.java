package mvc.view;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.sql.Connection;

import mvc.Conector;
import mvc.dao.PerguntaDao;
import mvc.dao.RespostaDao;
import mvc.model.Pergunta;
import mvc.model.Resposta;
import mvc.service.PerguntaService;
import mvc.service.RespostaService;
import mvc.service.ResultadoResposta;

public class View {

    public static void view() {
        Boolean carregar = true;
        Scanner teclado = new Scanner(System.in);

        try (Connection con = Conector.conectar();) {

            PerguntaDao perguntaDao = new PerguntaDao(con);
            RespostaDao respostaDao = new RespostaDao(con);
            RespostaService respostaService = new RespostaService(con);

            while (carregar) {
                System.out.println("================== Menu ==================");
                System.out.println("[1]- Jogar");
                System.out.println("[2]- Sair");

                int opc = teclado.nextInt();
                teclado.nextLine();

                switch (opc) {
                    case 1:

                        List<Pergunta> perguntas = perguntaDao.lista();
                        Collections.shuffle(perguntas);

                        int opcao1 = 1;

                        System.out.println("Jogue connosco, responda as perguntas \n");

                        for (Pergunta p : perguntas) {
                            System.out.println(opcao1 + "--" + p);
                            opcao1++;

                            List<Resposta> respostas = respostaDao.buscarRespostas(p.getId_pergunta());
                            Collections.shuffle(respostas);

                            int opcao = 1;
                            for (Resposta r : respostas) {
                                System.out.println(opcao + " - " + r.getTexto());
                                opcao++;
                            }
                            // Service

                            int escolha = teclado.nextInt();
                            teclado.nextLine();

                            long idRespostaEscolhida = respostas.get(escolha - 1).getIdResposta();

                            ResultadoResposta resultado = respostaService.responder(idRespostaEscolhida);

                            if (resultado == ResultadoResposta.CORRETA) {
                                System.out.println("✅");
                            } else {
                                System.out.println("❌");
                            }

                            System.out.println("deia Enter caso deseje continuar!");
                            teclado.nextLine();
                        }

                        break;

                    case 2:
                        carregar = false;
                    default:
                        break;
                }

            }

        } catch (SQLException e) {
            System.err.println("Erro de base de dados." + e.getMessage());
        }

    }

}
