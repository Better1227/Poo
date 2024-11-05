package Financeiro;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class AreaFinancas {
    private GerenciadorFinanceiro gerenciadorFinanceiro;
    private Scanner scanner;

    public AreaFinancas() {
        this.gerenciadorFinanceiro = new GerenciadorFinanceiro();
        this.scanner = new Scanner(System.in); // Inicialização do Scanner
    }

    public void iniciar(LoginFinanceiro loginFinanceiro) {
        if (loginFinanceiro.autenticar()) {
            System.out.println("=== Acesso ao Sistema de Gerenciamento Financeiro Concedido ===");
            exibirMenu();
        } else {
            System.out.println("Acesso negado.");
        }
    }

    private void exibirMenu() {
        while (true) {
            System.out.println("=== Sistema de Gerenciamento Financeiro ===");
            System.out.println("1. Adicionar Pagamento de Funcionário");
            System.out.println("2. Adicionar Mensalidade de Aluno");
            System.out.println("3. Consultar Pagamentos de Funcionário");
            System.out.println("4. Consultar Mensalidades de Aluno");
            System.out.println("5. Relatório Financeiro");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    adicionarPagamentoFuncionario();
                    break;
                case 2:
                    adicionarMensalidadeAluno();
                    break;
                case 3:
                    consultarPagamentosFuncionario();
                    break;
                case 4:
                    consultarMensalidadesAluno();
                    break;
                case 5:
                    relatorioFinanceiro();
                    break;
                case 6:
                    System.out.println("Saindo do sistema financeiro...");
                    return;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }

    private void adicionarPagamentoFuncionario() {
        System.out.print("Digite o ID do funcionário: ");
        int funcionarioId = scanner.nextInt();
        System.out.print("Digite o valor do pagamento: ");
        double valor = scanner.nextDouble();
        Date data = new Date(); // Data atual

        gerenciadorFinanceiro.adicionarPagamentoFuncionario(funcionarioId, valor, data);
        System.out.println("Pagamento registrado com sucesso.");
    }

    private void adicionarMensalidadeAluno() {
        System.out.print("Digite o ID do aluno: ");
        int alunoId = scanner.nextInt();
        System.out.print("Digite o valor da mensalidade: ");
        double valor = scanner.nextDouble();
        Date data = new Date(); // Data atual

        gerenciadorFinanceiro.adicionarMensalidadeAluno(alunoId, valor, data);
        System.out.println("Mensalidade registrada com sucesso.");
    }

    private void consultarPagamentosFuncionario() {
        System.out.print("Digite o ID do funcionário: ");
        int funcionarioId = scanner.nextInt();

        List<PagamentoFuncionario> pagamentos = gerenciadorFinanceiro.consultarPagamentosFuncionario(funcionarioId);
        if (pagamentos.isEmpty()) {
            System.out.println("Nenhum pagamento encontrado para o funcionário com ID: " + funcionarioId);
        } else {
            System.out.println("Pagamentos do funcionário com ID " + funcionarioId + ":");
            for (PagamentoFuncionario pagamento : pagamentos) {
                System.out.println("Data: " + pagamento.getDataPagamento() + " | Valor: R$" + pagamento.getValorPago());
            }
        }
    }

    private void consultarMensalidadesAluno() {
        System.out.print("Digite o ID do aluno: ");
        int alunoId = scanner.nextInt();

        List<MensalidadeAluno> mensalidades = gerenciadorFinanceiro.consultarMensalidadesAluno(alunoId);
        if (mensalidades.isEmpty()) {
            System.out.println("Nenhuma mensalidade encontrada para o aluno com ID: " + alunoId);
        } else {
            System.out.println("Mensalidades do aluno com ID " + alunoId + ":");
            for (MensalidadeAluno mensalidade : mensalidades) {
                System.out.println("Data: " + mensalidade.getDataPagamento() + " | Valor: R$" + mensalidade.getValorPago());
            }
        }
    }

    private void relatorioFinanceiro() {
        gerenciadorFinanceiro.relatorioFinanceiro();
    }
}
