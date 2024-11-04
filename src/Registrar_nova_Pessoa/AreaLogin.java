/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Registrar_nova_Pessoa;

import java.util.Scanner;

/**
 *
 * @author davy-garcia
 */
public class AreaLogin {
   public static void arealogin(){
        Scanner scanner = new Scanner(System.in);

        while (true) {
    System.out.println("=== Sistema de Cadastro ===");
    System.out.println("1. Registrar novo Aluno");
    System.out.println("2. Registrar novo Funcionario");
    System.out.println("3. Deletar aluno ou Funcionario");
    System.out.println("4. Sair");
    System.out.print("Escolha uma opção: ");
    int opcao = scanner.nextInt();
    scanner.nextLine(); // Consumir a quebra de linha

    switch (opcao) {
        case 1:
            SCadastroAluno.CadastroA(); // Chama o método CadastroA da classe SCadastroAluno
            break;

        case 2:
            SCadastrofuncionario.CadastroF();
            break;

        case 3:
            System.out.println("=== Deletar aluno ou Funcionario ===");
            System.out.println("1. Remover Aluno");
            System.out.println("2. Remover Funcionario");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao1 = scanner.nextInt();

            switch (opcao1) {
                case 1:
                    System.out.println("Digite o ID do aluno a ser deletado:");
                    int idA = scanner.nextInt();
                    DeletarAluno.deletarAlunoPorId(idA);
                    break;

                case 2:
                    System.out.println("Digite o ID do Funcionario a ser deletado:");
                    int idF = scanner.nextInt();
                    DeletarFuncionario.deletarFuncionarioPorId(idF);
                    break; 

                case 3:
                    System.out.println("Voltando ao menu principal...");
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
            break;

        case 4:            
            return; // Finaliza o programa e sai do loop

        default:
            System.out.println("Opção inválida, tente novamente.");
        }
        }

    }
   
}