package Entidades;

public class Equipamento {
    private String nomeEquipamento;
    private String tipoEquipamento;
    private int id;

    public Equipamento(int id, String nomeEquipamento, String tipoEquipamento) {
        this.nomeEquipamento = nomeEquipamento;
        this.tipoEquipamento = tipoEquipamento;
        this.id = id;
    }

    public void setNomeEquipamento(String nomeEquipamento) {
        this.nomeEquipamento = nomeEquipamento;
    }

    public String getNomeEquipamento() {
        return this.nomeEquipamento;
    }

    public void setTipoEquipamento(String tipoEquipamento) {
        this.tipoEquipamento = tipoEquipamento;
    }

    public String getTipoEquipamento() {
        return this.tipoEquipamento;
    }

    public void setId(int novoid) {
        this.id = novoid;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Equipamento{id= " + getId() + ", nome= " + getNomeEquipamento() + ", Tipo= " + getTipoEquipamento()
                + "}";
    }

}
