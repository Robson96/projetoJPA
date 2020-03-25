package main;

import model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class alterarUsuario2 {
    public static void main(String[] args) {
        /**
         * Todo obj que estiver no contexto gerenciavel vai ser secronizado
         * com o banco de dados.
         *
         *
         * Todo contexto de percistencia esta dentro dessas classe que gerencia o banco
         * EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaJPA");
         * EntityManager         em = emf.createEntityManager();
         */

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaJPA");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Usuario usuario = em.find(Usuario.class, 3L);


        /**
         *     void detach(Object entity)
         *
         * Remova a entidade especificada do contexto de persistência,
         * fazendo com que uma entidade gerenciada seja desanexada.
         * As alterações não liberadas feitas na entidade,
         * se houver alguma (incluindo a remoção da entidade),
         * não serão sincronizadas com o banco de dados.
         * As entidades que fizeram referência anteriormente à entidade
         * desanexada continuarão fazendo referência a ela.
         */
        em.detach(usuario);

        usuario.setNome("Joao batista");

        //em.merge(usuario);

        em.getTransaction().commit();


        em.close();
        emf.close();
    }
}
