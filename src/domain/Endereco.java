package src.domain;

public class Endereco {
    int numero;
    String rua;
    String cidade;

    public Endereco(int numero, String rua, String cidade) {
        this.numero = numero;
        this.rua = rua;
        this.cidade = cidade;
    }

    public int getNumero() {
        return numero;
    }

    public String getRua() {
        return rua;
    }

    public String getCidade() {
        return cidade;
    }
}
