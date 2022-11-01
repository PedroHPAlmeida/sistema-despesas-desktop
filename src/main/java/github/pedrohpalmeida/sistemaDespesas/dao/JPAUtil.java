package github.pedrohpalmeida.sistemaDespesas.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private JPAUtil(){}

    private static final EntityManagerFactory FACTORY = Persistence
            .createEntityManagerFactory("despesas");

    public static EntityManager getEntityManager(){
        return FACTORY.createEntityManager();
    }

}
