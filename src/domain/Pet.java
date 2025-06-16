package src.domain;

public class Pet {
    private String nome;
    private TipoPet tipo;
    private SexoPet sexo;
    private Endereco endereco;
    private int idade;
    private double peso;
    private String raca;

    public Pet(String nome, TipoPet tipo, SexoPet sexo, Endereco endereco, int idade, double peso, String raca) {
        this.nome = nome;
        this.tipo = tipo;
        this.sexo = sexo;
        this.endereco = endereco;
        this.idade = idade;
        this.peso = peso;
        this.raca = raca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoPet getTipo() {
        return tipo;
    }

    public void setTipo(TipoPet tipo) {
        this.tipo = tipo;
    }

    public SexoPet getSexo() {
        return sexo;
    }

    public void setSexo(SexoPet sexo) {
        this.sexo = sexo;
    }

    public Endereco getEndereço() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public void showDetails() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Tipo: " + this.tipo);
        System.out.println("Sexo: " + this.sexo);
        System.out.println("Endereço: " + this.endereco);
        System.out.println("Idade: " + this.idade);
        System.out.println("Peso: " + this.peso);
        System.out.println("Raça: " + this.raca);
    }
}
