package github.pedrohpalmeida.sistemaDespesas.dao;

import github.pedrohpalmeida.sistemaDespesas.model.Transacao;
import lombok.AllArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;

@AllArgsConstructor
public class TransacaoDAO {

    private EntityManager entityManager;

    public void salvar(Transacao transacao){
        this.entityManager.persist(transacao);
    }

    public void remover(Transacao transacao){
        transacao = this.entityManager.merge(transacao);
        this.entityManager.remove(transacao);
    }

    public Transacao buscarPorId(Long id){
        return this.entityManager.find(Transacao.class, id);
    }

    public List<Transacao> listarTransacoes() {
        String jpql = "SELECT t FROM Transacao as t";
        return this.entityManager.createQuery(jpql, Transacao.class).getResultList();
    }
}
