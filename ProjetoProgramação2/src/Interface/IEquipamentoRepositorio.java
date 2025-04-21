package Interface;

import Entidades.Equipamento;
import java.util.List;
import java.util.ArrayList;

public interface IEquipamentoRepositorio {
    // Interface do repositorio do Equipamento
    void salvar(Equipamento equipamento);

    void remover(int id);

    List<Equipamento> listar();

    void alterar(Equipamento equipamento);

    Equipamento buscarID(int id);
    
}
