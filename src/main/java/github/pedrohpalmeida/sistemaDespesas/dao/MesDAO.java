package github.pedrohpalmeida.sistemaDespesas.dao;

import github.pedrohpalmeida.sistemaDespesas.model.Mes;
import lombok.AllArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;

@AllArgsConstructor
public class MesDAO {

    private EntityManager entityManager;

    public void salvar(Mes mes){
        this.entityManager.persist(mes);
    }

    public Mes buscarPorId(Long id){
        return this.entityManager.find(Mes.class, id);
    }

    public List<Mes> listarMeses() {
        String jpql = "SELECT m FROM Mes as m";
        return this.entityManager.createQuery(jpql, Mes.class).getResultList();
    }
}
