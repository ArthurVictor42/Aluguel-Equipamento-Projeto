package Entidades;

import java.util.Date;

public class Funcionario extends Pessoa {
    private String cargo;
    private double salario;

    public Funcionario(int id, String nome, Date dataNascimento, String cpf, String celular, String email, String cargo, double salario){
        super(id, nome, dataNascimento, cpf, celular, email);
        this.cargo = cargo;
        this.salario = salario;

    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCargo() {
        return this.cargo;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getSalario() {
        return this.salario;
    }

    @Override
    public String toString() {
        return "Funcionario [ID=" + getId() + ", Nome=" + getNomeCompleto() + ", Data de Nascimento=" + getDatanascimento() + ", CPF=" + getCpf() + ", Celular=" + getCelular() + ", Email=" + getEmail() + ", Cargo=" + getCargo() + ", Salario=" + getSalario() + "]";
    }

}
