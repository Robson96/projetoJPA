package main;

import model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class alterarUsuario {
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
        EntityManager         em = emf.createEntityManager();

        em.getTransaction().begin();

        Usuario usuario = em.find(Usuario.class, 3L);

        usuario.setNome("Joao batista");
        //em.merge(usuario);

        em.getTransaction().commit();


        em.close();
        emf.close();
    }
}
