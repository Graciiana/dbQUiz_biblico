package mvc.model;

public enum Dificuldade {
    FACIL(2),
    MEDIO(2),
    DIFICIL(1);


    private final int quantidade;

    Dificuldade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
