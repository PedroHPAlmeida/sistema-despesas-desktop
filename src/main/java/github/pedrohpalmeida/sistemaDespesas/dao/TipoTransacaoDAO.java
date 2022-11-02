package github.pedrohpalmeida.sistemaDespesas.dao;

import github.pedrohpalmeida.sistemaDespesas.model.TipoTransacao;
import lombok.AllArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;

@AllArgsConstructor
public class TipoTransacaoDAO {

    private EntityManager entityManager;

    public void salvar(TipoTransacao tipoTransacao){
        this.entityManager.persist(tipoTransacao);
    }

    public void alterar(TipoTransacao tipoTransacao){
        this.entityManager.merge(tipoTransacao);
    }

    public void remover(TipoTransacao tipoTransacao){
        tipoTransacao = this.entityManager.merge(tipoTransacao);
        this.entityManager.remove(tipoTransacao);
    }

    public TipoTransacao buscarPorId(Long id){
        return this.entityManager.find(TipoTransacao.class, id);
    }

    public List<TipoTransacao> listarTiposTransacoes() {
        String jpql = "SELECT t FROM TipoTransacao as t";
        return this.entityManager.createQuery(jpql, TipoTransacao.class).getResultList();
    }
}
