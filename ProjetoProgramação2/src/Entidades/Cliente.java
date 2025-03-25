package Entidades;

public class Cliente extends Pessoa {
    private int id;
    private static int contID = 1;

    public Cliente(String nomeCompleto, int idade, String cpf, String celular, String email){
        super(nomeCompleto, idade, cpf, celular, email);
        this.id = contID++;
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

