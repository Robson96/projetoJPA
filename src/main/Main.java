package main;

import model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.function.BiFunction;
import java.util.function.Function;

import static model.Usuario.*;

public class Main {
    public static void main(String[] args) {

        //Responsavel por criar a conecao com o banco
        EntityManagerFactory emf = Persistence
                //Retorna a conecao
                .createEntityManagerFactory("JavaJPA");

        //Encapsula as conecoes
        EntityManager em = emf.createEntityManager();

        //BiFunction<String, String, Usuario> createUser = Usuario::new;

        //em.persist(Usuario.createUser(createUser, "Robson", "Email"));
        //em.persist(Usuario.createUser((n, e) -> new Usuario(n, e), "Robson", "Email"));
        Usuario usuario = createUser("Jesus", "mateus24@gmail.com");

        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
