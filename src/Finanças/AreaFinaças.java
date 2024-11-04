/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Finanças;

import java.util.Scanner;

/**
 *
 * @author davy-garcia
 */
public class AreaFinaças {
    
    public static void areafinanças() {
        Scanner scanner = new Scanner(System.in);

         while (true) {
            System.out.println("=== Finanças ===");
            System.out.println("1. Registrar novo Aluno");
            System.out.println("2. Registrar novo Funcionario");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                   
               
                    break;

                case 2:
                    
                    break;
                case 3:
                   
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }
}
