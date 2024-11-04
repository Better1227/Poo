package projetoacademia;

import Registrar_nova_Pessoa.AreaLogin;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       
        while (true) {            
            System.out.println("=== Academia do Vale ===");
            System.out.println("1. Registrar nova Pessoa");
            System.out.println("2. Gerenciamento de aulas");
            System.out.println("3. Lojas");
            System.out.println("4. Finanças");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    AreaLogin.arealogin(); // Chama o método CadastroA da classe SCadastroAluno
               
                    break;

                case 2:
                    
                case 3:
                    
                case 4:
                                   
                case 5: 
                    System.out.println("Encerrando o sistema...");
                    scanner.close();
                    System.exit(0); //
                    
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }       
               
        
    }
}






