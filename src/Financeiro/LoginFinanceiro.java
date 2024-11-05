package Financeiro;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoginFinanceiro {
    private Map<String, String> usuarios; // Armazena usuários e senhas
    private Scanner scanner;

    public LoginFinanceiro() {
        this.usuarios = new HashMap<>();
        this.scanner = new Scanner(System.in);
        inicializarUsuarios(); // Inicializa usuários padrão
    }

    // Método para inicializar alguns usuários padrão (pode ser ajustado conforme necessidade)
    private void inicializarUsuarios() {
        usuarios.put("admin", "admin123"); // Exemplo de usuário administrador
        usuarios.put("user", "user123");   // Exemplo de usuário comum
    }

    // Método de login
    public boolean autenticar() {
        System.out.print("Digite o nome de usuário: ");
        String usuario = scanner.nextLine();
        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();

        if (usuarios.containsKey(usuario) && usuarios.get(usuario).equals(senha)) {
            System.out.println("Login bem-sucedido. Bem-vindo, " + usuario + "!");
            return true;
        } else {
            System.out.println("Nome de usuário ou senha incorretos.");
            return false;
        }
    }
}
