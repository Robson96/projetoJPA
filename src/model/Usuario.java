package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    public Usuario() {}

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(getId(), usuario.getId()) &&
                Objects.equals(getNome(), usuario.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome());
    }

    public static Usuario createUser(
                            BiFunction<String,
                            String,
                            Usuario> biFun, String nome, String email)
    {

        return biFun.apply(nome, email);

    }

    public static Usuario createUser(String nome, String email)
    {
        BiFunction<String, String, Usuario> biFun = Usuario::new;
        //return biFun.apply(nome, email);
        return createUser(biFun, nome, email);

    }

    @Override
    public String toString() {
        return "id=" + id +
                ", nome='" + nome + '\'';
    }
}
