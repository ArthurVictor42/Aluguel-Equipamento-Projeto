package Entidades;

public class Funcionario extends Pessoa {
    private String cargo;
    private int ID;
    private static int contID = 1;

    public Funcionario(String nome, int idade, String cpf, String celular, String email, String cargo){
        super(nome, idade, cpf, celular, email);
        this.cargo = cargo;
        this.ID = contID++;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCargo() {
        return this.cargo;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public int getID() {
        return this.ID;
    }
}
