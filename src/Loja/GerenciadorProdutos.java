package loja;
import Loja.ProdutosLoja;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GerenciadorProdutos {
    private List<ProdutosLoja> produtos;
    private Gson gson;

    public GerenciadorProdutos() {
        produtos = new ArrayList<>();
        gson = new Gson(); // Inicializa o Gson
    }

    public void adicionarProduto(ProdutosLoja produto) {
        produtos.add(produto);
    }

    public boolean removerProdutoPorId(int id) {
        Iterator<ProdutosLoja> iterator = produtos.iterator();
        while (iterator.hasNext()) {
            ProdutosLoja produto = iterator.next();
            if (produto.getId() == id) {
                iterator.remove();
                return true; // Produto removido com sucesso
            }
        }
        return false; // Produto não encontrado
    }

    public void listarProdutos() {
        for (ProdutosLoja produto : produtos) {
            System.out.println("ID: " + produto.getId() + ", Nome: " + produto.getNome() +
                               ", Quantidade: " + produto.getQuantidade() + ", Preço: " + produto.getPreco());
        }
    }

    // Converte a lista de produtos para JSON
    public String produtosParaJson() {
        return gson.toJson(produtos);
    }

    // Carrega produtos a partir de um JSON
    public void carregarProdutosDeJson(String json) {
        Type produtoListType = new TypeToken<ArrayList<ProdutosLoja>>(){}.getType();
        List<ProdutosLoja> produtosCarregados = gson.fromJson(json, produtoListType);
        produtos.addAll(produtosCarregados);
    }
}