package mvc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import mvc.model.Dificuldade;
import mvc.model.Pergunta;

public class PerguntaService {

    private final Random random = new Random();

    public List<Pergunta> gerarPerguntas(List<Pergunta> todas) {

        List<Pergunta> jogo = new ArrayList<>();

        for (Dificuldade nivel : Dificuldade.values()) {
           
            List<Pergunta> filtradas = new ArrayList<>();
            for (Pergunta p : todas) {
                if (p.getDificuldade().equalsIgnoreCase(nivel.name())) {
                    filtradas.add(p);           
                }
            }
        }
        return jogo;
    }

}
