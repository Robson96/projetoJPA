package infra;


/**
 * @Autor Robson
 */

import model.Produto;
import org.jetbrains.annotations.NotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class DAOv2 {
    private static EntityManagerFactory emf;
    private static EntityManager em;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("JavaJPA");
        } catch (Exception e) {

        }
    }

    private DAOv2() {

    }

    private static void startContext() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }

    public static <T extends Produto> void incluirEntity(T entity) {
        startContext();
        em.persist(entity);
        endContext();
    }

    private static void endContext() {
        em.getTransaction().commit();
        em.close();
    }

    public static <T extends Produto> void remover(T entity) {
        startContext();
        em.persist(entity);
        endContext();
    }

    public static <T> T procurarPorId(@NotNull T entity, long id) {
        startContext();
        Object o = em.find(entity.getClass(), id);
        endContext();
        return (T) o;
    }
}
