package Entidades;

public class Funcionario extends Pessoa {
    private String cargo;
    private double salario;
    private int ID;
    private static int contID = 1;

    public Funcionario(String nome, int idade, String cpf, String celular, String email, String cargo, double salario){
        super(nome, idade, cpf, celular, email);
        this.cargo = cargo;
        this.salario = salario;

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

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getSalario() {
        return this.salario;
    }

    @Override
    public String toString() {
        return "Funcionario [ID=" + ID + ", Nome=" + getNomeCompleto() + ", Idade=" + getIdade() + ", CPF=" + getCpf() + ", Celular=" + getCelular() + ", Email=" + getEmail() + ", Cargo=" + getCargo() + ", Salario=" + getSalario() + "]";
    }

}
