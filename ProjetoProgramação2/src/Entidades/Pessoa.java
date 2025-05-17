package Entidades;

import java.util.Date;

public abstract class Pessoa {
    private String nomeCompleto;
    private Date dataNascimento;
    private String cpf;
    private String celular;
    private String email;
    private int id;

    public Pessoa(int id, String nomeCompleto, Date dataNascimento, String cpf, String celular, String email) {
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.celular = celular;
        this.email = email;
        this.id = id;
    }

    public void setNomeCompleto(String novonomeCompleto) {
        this.nomeCompleto = novonomeCompleto;
    }

    public String getNomeCompleto() {
        return this.nomeCompleto;
    }

    public void setDataNascimento(Date novaData) {
        this.dataNascimento = novaData;
    }

    public Date getDatanascimento() {
        return this.dataNascimento;
    }

    public void setEmail(String novoemail) {
        this.email = novoemail;
    }

    public String getEmail() {
        return this.email;
    }

    public void setCpf(String novocpf) {
        this.cpf = novocpf;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCelular(String novocelular) {
        this.celular = novocelular;
    }

    public String getCelular() {
        return this.celular;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}
