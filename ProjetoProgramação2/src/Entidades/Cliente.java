package Entidades;

public class Cliente extends Pessoa {
    private String endereco;
    private int id;
    private static int contID = 1;

    public Cliente( String endereco, String nomeCompleto, int idade, String cpf, String celular, String email){
        super(nomeCompleto, idade, cpf, celular, email);
        this.endereco = endereco;
        this.id = contID++;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setID(int novoid) {
        this.id = novoid;
    }

    public int getID() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Cliente{id=" + id + ", nome=" + getNomeCompleto() + ", idade=" + getIdade() + ", cpf=" + getCpf() + ", telefone=" + getCelular() + ", email=" +  getEmail() + "}";
    }
}

