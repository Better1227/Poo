package projetoacademia;

import com.google.gson.Gson;
import java.util.List;
/**
 *
 * @author davyc joao pedro
 */
class Loja {
    private String nome;
    private double preco;
    private int estoqueItens;

    public Loja(String nome, double preco, int estoqueItens) {
        this.nome = nome;
        this.preco = preco;
        this.estoqueItens = estoqueItens;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getEstoque() {
        return estoqueItens;
    }

    public void vender(int quantidade) {
        if (quantidade <= estoqueItens) {
            estoqueItens -= quantidade;
        } else {
            System.out.println("Estoque insuficiente para " + nome);
        }
    }

    public void repor(int quantidade) {
        estoqueItens += quantidade;
    }

    @Override
    public String toString() {
        return "Produto: " + nome + ", Preço: R$" + preco + ", Estoque: " + estoqueItens;
    }
}

class LojaAcademia {
    private final List<Loja> produtos = null;
    private final Gson gson;
    private final String caminhoArquivo = null;

    LojaAcademia() {
        this.gson = null;
    }

}
  
    
