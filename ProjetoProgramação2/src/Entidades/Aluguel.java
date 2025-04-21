package Entidades;

public class Aluguel {
    private double custoAluguel;
    private double custoManutencao;
    private int numeroAluguel;
    

    public Aluguel(int numeroAluguel, double custoAluguel, double custoManutencao){
        this.custoAluguel = custoAluguel;
        this.numeroAluguel = numeroAluguel;
    }

    public void setCustoAluguel(double novocustoAluguel) {
        this.custoAluguel = novocustoAluguel;
    }

    public double getCustoAluguel() {
        return this.custoAluguel;
    }

    public void setCustoManutençao(double novocustoManutencao) {
        this.custoManutencao = novocustoManutencao;
    }

    public double getCustoManutencao() {
        return custoManutencao;
    }

    public void setNumeroAluguel(int numeroAluguel) {
        this.numeroAluguel = numeroAluguel;
    }

    public int getNumeroAluguel() {
        return this.numeroAluguel;
    }

    @Override
    public String toString() {
        return "Aluguel{Custo de aluguel= " + getCustoAluguel() + ", Custo de manutenção= " + getCustoManutencao() + ", Numero do aluguel= " + getNumeroAluguel() + "}";
    }
}
