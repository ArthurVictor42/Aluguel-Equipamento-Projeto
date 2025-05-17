package Entidades;

import java.util.Date;

public class Cliente extends Pessoa {
    private String endereco;

    public Cliente(int id, String nomeCompleto, Date dataNascimento, String cpf, String celular, String email,
            String endereco) {
        super(id, nomeCompleto, dataNascimento, cpf, celular, email);
        this.endereco = endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEndereco() {
        return this.endereco;
    }

    @Override
    public String toString() {
        return "Cliente{ ID= " + getId() + ", nome=" + getNomeCompleto() + ", idade=" + getDatanascimento() + ", cpf="
                + getCpf() + ", telefone=" + getCelular() + ", email=" + getEmail() + "}";
    }
}
