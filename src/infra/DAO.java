package infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class DAO<T> {
    private static EntityManagerFactory emf;
    private EntityManager em;
    private Class<T> tClass;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("JavaJPA");
        } catch (Exception e) {

        }
    }

    public DAO() {
        this(null);
    }

    public DAO(Class<T> tClass) {
        this.tClass = tClass;
        em = emf.createEntityManager();
    }

    public DAO<T> abrirT() {
        em.getTransaction().begin();
        return this;
    }

    public DAO<T> fecharT() {
        em.getTransaction().commit();
        return this;
    }

    public DAO<T> incluir(T entity) {
        em.persist(entity);
        return this;
    }

    public DAO<T> incluirAtamico(T entity) {
        return this.abrirT().incluir(entity).fecharT();
    }

    public List<T> obterTodos(int limit, int des) {
        if (tClass == null) {
            throw new UnsupportedOperationException("Operacao nao suportada");
        }

        String jpql = "select u from " + tClass.getName() + " u";

        TypedQuery<T> tTypedQuery = em.createQuery(jpql, tClass);
        tTypedQuery.setMaxResults(limit);
        tTypedQuery.setFirstResult(des);

        return tTypedQuery.getResultList();
    }

    public List<T> obterTodos() {
        return this.obterTodos(10, 0);
    }

    public void fecharDao() {
        em.close();
    }
}
