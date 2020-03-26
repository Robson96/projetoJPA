package main;

import infra.DAO;
import model.Produto;

public class ProdutoDao extends DAO<Produto> {
    public ProdutoDao() {
        super(Produto.class);
    }
}
