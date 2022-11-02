package github.pedrohpalmeida.sistemaDespesas.TesteJPA;

import github.pedrohpalmeida.sistemaDespesas.dao.JPAUtil;
import github.pedrohpalmeida.sistemaDespesas.dao.TipoTransacaoDAO;
import github.pedrohpalmeida.sistemaDespesas.model.TipoTransacao;

import javax.persistence.EntityManager;

public class TipoTransacaoTeste {

    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        TipoTransacaoDAO tipoTransacaoDAO = new TipoTransacaoDAO(em);

        em.getTransaction().begin();
        tipoTransacaoDAO.salvar(new TipoTransacao("salário"));
        tipoTransacaoDAO.salvar(new TipoTransacao("vale"));
        tipoTransacaoDAO.salvar(new TipoTransacao("débito"));
        em.getTransaction().commit();
        em.close();
    }
}
