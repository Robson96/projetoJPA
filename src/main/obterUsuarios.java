package main;

import model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class obterUsuarios {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaJPA");
        EntityManager        em  = emf.createEntityManager();

        em.getTransaction().begin();

        //Java programming query langague
        String jpql = "select u from Usuario u";

        TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
        //query.getSingleResult();

        //Seta o numero maximo de Usuarios
        query.setMaxResults(5);


        List<Usuario> usuarioList = query.getResultList();


        em.getTransaction().commit();

        usuarioList.forEach(System.out::println);

        em.close();
        emf.close();
    }
}
