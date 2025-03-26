package Interface;

import Entidades.Equipamento;
import java.util.ArrayList;

public interface IEquipamentoRepositorio {
    // Interface do repositorio do Equipamento
    void salvar(Equipamento equipamento);

    boolean remover(Equipamento Equipamento);

    ArrayList<Equipamento> listarEquipamento();

    void alteraNome(Equipamento equipamento);
    
}
