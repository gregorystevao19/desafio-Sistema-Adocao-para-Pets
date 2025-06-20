package src.domain;

public enum TipoPet {
    CACHORRO("Cachorro"),
    GATO("Gato"),
    NAO_INFORMADO("Não Informado");

    private final String descricao;

    TipoPet(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
