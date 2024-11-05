package Financeiro;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GerenciadorFinanceiro {
    private List<PagamentoFuncionario> pagamentosFuncionarios;
    private List<MensalidadeAluno> mensalidadesAlunos;

    public GerenciadorFinanceiro() {
        this.pagamentosFuncionarios = new ArrayList<>();
        this.mensalidadesAlunos = new ArrayList<>();
    }

    // Métodos para gerenciar pagamentos de funcionários
    public void adicionarPagamentoFuncionario(int funcionarioId, double valor, Date data) {
        PagamentoFuncionario pagamento = new PagamentoFuncionario(funcionarioId, valor, data);
        pagamentosFuncionarios.add(pagamento);
        System.out.println("Pagamento de funcionário adicionado com sucesso.");
    }

    public List<PagamentoFuncionario> consultarPagamentosFuncionario(int funcionarioId) {
        List<PagamentoFuncionario> resultado = new ArrayList<>();
        for (PagamentoFuncionario pagamento : pagamentosFuncionarios) {
            if (pagamento.getFuncionarioId() == funcionarioId) {
                resultado.add(pagamento);
            }
        }
        return resultado;
    }

    // Métodos para gerenciar mensalidades de alunos
    public void adicionarMensalidadeAluno(int alunoId, double valor, Date data) {
        MensalidadeAluno mensalidade = new MensalidadeAluno(alunoId, valor, data);
        mensalidadesAlunos.add(mensalidade);
        System.out.println("Mensalidade de aluno adicionada com sucesso.");
    }

    public List<MensalidadeAluno> consultarMensalidadesAluno(int alunoId) {
        List<MensalidadeAluno> resultado = new ArrayList<>();
        for (MensalidadeAluno mensalidade : mensalidadesAlunos) {
            if (mensalidade.getAlunoId() == alunoId) {
                resultado.add(mensalidade);
            }
        }
        return resultado;
    }

    // Relatório de todos os pagamentos e recebimentos
    public void relatorioFinanceiro() {
        double totalPagamentos = pagamentosFuncionarios.stream().mapToDouble(PagamentoFuncionario::getValorPago).sum();
        double totalRecebimentos = mensalidadesAlunos.stream().mapToDouble(MensalidadeAluno::getValorPago).sum();

        System.out.println("=== Relatório Financeiro ===");
        System.out.println("Total pago aos funcionários: R$" + totalPagamentos);
        System.out.println("Total recebido de mensalidades: R$" + totalRecebimentos);
        System.out.println("Saldo total: R$" + (totalRecebimentos - totalPagamentos));
    }
}
