package Registrar_nova_Pessoa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class SCadastroAluno extends Pessoa {

    private String email;
    private String endereço;
    private String telefone;

    // Construtor ajustado para incluir email, telefone e endereço
    public SCadastroAluno(String nome, String id, String cpf, String senha, String email, String endereço, String telefone) {
        super(nome, id, cpf, senha);
        this.email = email;
        this.endereço = endereço;
        this.telefone = telefone;
    }

    // Getters e Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public static void CadastroA() {
        Scanner scanner = new Scanner(System.in);
        List<SCadastroAluno> alunos = new ArrayList<>();

        // Tentar ler o arquivo existente
        try (BufferedReader br = new BufferedReader(new FileReader("pessoas.json"))) {
            Gson gson = new Gson();
            Type listType = new TypeToken<List<SCadastroAluno>>() {}.getType();
            alunos = gson.fromJson(br, listType);

            if (alunos == null) {  // Verifica se a lista está nula e inicializa se necessário
                alunos = new ArrayList<>();
            }
        } catch (IOException e) {
            // Se o arquivo não existir, começamos com uma nova lista
            System.out.println("Arquivo não encontrado, começando uma nova lista.");
            alunos = new ArrayList<>();
        }

        // Definir ID com base no tamanho da lista (último ID + 1)
        String id = "ID" + (alunos.size() + 1);

        // Solicitar dados do usuário
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();

        System.out.print("Digite o email: ");
        String email = scanner.nextLine();

        System.out.print("Digite o endereço: ");
        String endereço = scanner.nextLine();

        System.out.print("Digite o telefone: ");
        String telefone = scanner.nextLine();  
        
        

        // Criar um objeto SCadastroAluno e adicionar à lista
        alunos.add(new SCadastroAluno(nome, id, cpf, senha, email, endereço, telefone));

        // Escrever de volta para o arquivo
        try (FileWriter fileWriter = new FileWriter("pessoas.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(alunos);
            fileWriter.write(json);
            fileWriter.flush();
            System.out.println("Dados armazenados em pessoas.json");

        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }
    
}




