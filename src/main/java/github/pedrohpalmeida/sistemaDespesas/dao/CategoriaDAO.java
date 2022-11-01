package github.pedrohpalmeida.sistemaDespesas.dao;

import github.pedrohpalmeida.sistemaDespesas.model.Categoria;
import lombok.AllArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;

@AllArgsConstructor
public class CategoriaDAO {

    private EntityManager entityManager;

    public void salvar(Categoria categoria){
        this.entityManager.persist(categoria);
    }

    public void alterar(Categoria categoria){
        this.entityManager.merge(categoria);
    }

    public void remover(Categoria categoria){
        categoria = this.entityManager.merge(categoria);
        this.entityManager.remove(categoria);
    }

    public Categoria buscarPorId(Long id){
        return this.entityManager.find(Categoria.class, id);
    }

    public List<Categoria> listarCategorias() {
        String jpql = "SELECT c FROM Categoria as c";
        return this.entityManager.createQuery(jpql, Categoria.class).getResultList();
    }
}
