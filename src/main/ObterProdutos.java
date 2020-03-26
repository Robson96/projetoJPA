package main;

import infra.DAOv2;
import model.Produto;

import java.util.List;

public class ObterProdutos {

    public static void main(String[] args) {
        ProdutoDao dao = new ProdutoDao();

        List<Produto> produtos = dao.obterTodos();

        for (Produto p: produtos) {
            System.out.println(
                    "Id = "    + p.getId() +
                    " Nome: "  + p.getNome() +
                    " Preco: " + p.getPreco());
        }

        double total = produtos.stream()
                               .mapToDouble(Produto::getPreco)
                               .sum();

        System.out.println(total);


        System.out.println("----------------0-00-0-000-000====");
        System.out.println("Incluindo");
        Produto produto = new Produto("Blusa", 9.0);

        DAOv2.incluirEntity(produto);

        System.out.println(DAOv2.procurarPorId(produto, 3).getNome());
    }
}
