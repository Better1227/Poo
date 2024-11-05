package Loja;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

public class GerenciamentoProduto {
    private List<ProdutosLoja> produtos;
    private Gson gson;

    public GerenciamentoProduto(List<ProdutosLoja> produtos) {
        this.produtos = produtos;
        this.gson = new Gson(); // Inicializando o Gson
    }

    // Método para adicionar um novo produto ao estoque
    public void adicionarProduto(ProdutosLoja produto) {
        produtos.add(produto);
    }

    // Método para remover um produto do estoque pelo ID
    public boolean removerProdutoPorId(int id) {
        for (ProdutosLoja produto : produtos) {
            if (produto.getId() == id) {
                produtos.remove(produto);
                return true; // Produto removido com sucesso
            }
        }
        return false; // Produto não encontrado
    }

    // Método para atualizar a quantidade de um produto no estoque
    public boolean atualizarQuantidade(int id, int novaQuantidade) {
        for (ProdutosLoja produto : produtos) {
            if (produto.getId() == id) {
                produto.setQuantidade(novaQuantidade);
                return true; // Quantidade atualizada com sucesso
            }
        }
        return false; // Produto não encontrado
    }

    // Método para converter a lista de produtos para JSON
    public String produtosParaJson() {
        return gson.toJson(produtos);
    }

    // Método para carregar produtos a partir de um JSON
    public void carregarProdutosDeJson(String json) {
        Type produtoListType = new TypeToken<List<ProdutosLoja>>(){}.getType();
        List<ProdutosLoja> produtosCarregados = gson.fromJson(json, produtoListType);
        produtos.clear();
        produtos.addAll(produtosCarregados);
    }
}