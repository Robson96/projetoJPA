package main;

import infra.DAO;
import model.Produto;

public class NovoProduto {
    public static void main(String[] args) {
        Produto produto = new Produto("Caderno", 10.03);

        DAO<Produto> dao = new DAO<>();

        dao.abrirT().incluir(produto).fecharT().fecharDao();
    }
}
