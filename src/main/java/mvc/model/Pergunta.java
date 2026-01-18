package mvc.model;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class Pergunta {
    private long id_pergunta;
    private String texto;
    private String dificuldade;

@Override
public String toString() {
    return getTexto()+ " | Nivel-- "+getDificuldade();
}
}