package mvc.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Resposta {
    private long idResposta;
    private String texto;
    private int correta;
    private Pergunta pergunta;
}
