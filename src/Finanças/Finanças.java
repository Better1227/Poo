package Finanças;
/**
 *
 * @author davyc joao pedro
 */
class Finanças {
    
   
    private String descricao;
    private float valor;

    public Finanças(String descricao, float valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public float getValor() {
        return valor;
    }
  
    @Override
    public String toString() {
        return "Despesa: " + descricao + ", Valor: R$" + valor;
    }
}

class Receita {
    private  String descricao;
    private  float valor;

    public Receita(String descricao, float valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public float getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Receita: " + descricao + ", Valor: R$" + valor;
    }
}

    