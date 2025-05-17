package Interface;

import Entidades.Equipamento;
import java.util.List;
import java.util.ArrayList;

public interface IEquipamentoRepositorio {
    // Interface do repositorio do Equipamento
    void salvar(Equipamento equipamento);

    boolean remover(int id);

    List<Equipamento> listar();

    boolean alterar(Equipamento equipamento);

    boolean buscarID(int id);

}
