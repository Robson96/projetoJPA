package main;

import model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class obterUsuario {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaJPA");
        EntityManager        em  = emf.createEntityManager();

        em.getTransaction().begin();

        Usuario usuario = em.find(Usuario.class, 1L);
        //Verifica se a transacao de escrita no banco esta ocorrendo isActive()
        //System.out.println(em.getTransaction().isActive());
        System.out.println(usuario.getNome());

        em.getTransaction().commit();
        System.out.println(em.getTransaction().isActive());
        em.close();
        emf.close();
    }
}
