package Entidades;

public abstract class Pessoa {
    private String nomeCompleto;
    private int idade;
    private String cpf;
    private String celular;
    private String email;

    public Pessoa(String nomeCompleto, int idade, String cpf, String celular, String email){
        this.nomeCompleto = nomeCompleto;
        this.idade = idade;
        this.cpf = cpf;
        this.celular = celular; 
        this.email = email;

    }

    public void setNomeCompleto(String novonomeCompleto) {
        this.nomeCompleto = novonomeCompleto;
    }

    public String getNomeCompleto() {
        return this.nomeCompleto;
    }

    public void setIdade(int novaidade) {
        this.idade = novaidade;
    }

    public int getIdade() {
        return this.idade;
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
}
