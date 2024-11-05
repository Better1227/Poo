package Financeiro;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import Registrar_nova_Pessoa.Pessoa;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GerenciadorMensalidades {
    private List<MensalidadeAluno> mensalidades;
    private Gson gson;
    private static final String ARQUIVO_MENSALIDADES = "mensalidades.json";

    public GerenciadorMensalidades() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.mensalidades = carregarMensalidadesDoArquivo();
    }

    // Carrega as mensalidades do arquivo JSON
    private List<MensalidadeAluno> carregarMensalidadesDoArquivo() {
        try (FileReader reader = new FileReader(ARQUIVO_MENSALIDADES)) {
            Type tipoListaMensalidade = new TypeToken<List<MensalidadeAluno>>() {}.getType();
            List<MensalidadeAluno> lista = gson.fromJson(reader, tipoListaMensalidade);
            return lista != null ? lista : new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Erro ao carregar mensalidades: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // Verifica se o aluno está registrado (para simulação, usaremos um simples método com ID)
    public boolean verificarAlunoRegistrado(int alunoId) {
        // Supondo que temos um arquivo "alunos.json" que contém os registros de alunos
        try (FileReader reader = new FileReader("alunos.json")) {
            Type listType = new TypeToken<List<Pessoa>>() {}.getType();
            List<Pessoa> alunos = gson.fromJson(reader, listType);
            return alunos.stream().anyMatch(aluno -> aluno.getId() == alunoId);
        } catch (IOException e) {
            System.out.println("Erro ao carregar alunos: " + e.getMessage());
            return false;
        }
    }

    // Lista todas as mensalidades pagas por um aluno específico
    public List<MensalidadeAluno> listarMensalidadesPorAluno(int alunoId) {
        List<MensalidadeAluno> resultado = new ArrayList<>();
        for (MensalidadeAluno mensalidade : mensalidades) {
            if (mensalidade.getAlunoId() == alunoId) {
                resultado.add(mensalidade);
            }
        }
        return resultado;
    }

    // Exibe um relatório financeiro de todas as mensalidades
    public void relatorioFinanceiroAlunos() {
        double totalRecebido = calcularTotalMensalidades();
        System.out.println("=== Relatório Financeiro dos Alunos ===");
        System.out.println("Total recebido em mensalidades: R$" + totalRecebido);
    }

    // Calcula o total de mensalidades
    public double calcularTotalMensalidades() {
        double total = 0;
        for (MensalidadeAluno mensalidade : mensalidades) {
            total += mensalidade.getValorPago();
        }
        return total;
    }

    // Adiciona uma nova mensalidade para um aluno e salva no arquivo JSON
    public void adicionarMensalidade(int alunoId, double valorPago) {
        MensalidadeAluno mensalidade = new MensalidadeAluno(alunoId, valorPago, new Date());
        mensalidades.add(mensalidade);
        salvarMensalidadesParaArquivo();
    }

    // Salva as mensalidades no arquivo JSON
    private void salvarMensalidadesParaArquivo() {
        try (FileWriter writer = new FileWriter(ARQUIVO_MENSALIDADES)) {
            gson.toJson(mensalidades, writer);
        } catch (IOException e) {
            System.out.println("Erro ao salvar mensalidades: " + e.getMessage());
        }
    }
}
