package br.com.satc.exercicio3;

import br.com.satc.exercicio3.component.Ator;
import br.com.satc.exercicio3.component.Filme;
import br.com.satc.exercicio3.component.Indicacao;
import br.com.satc.exercicio3.service.OscarService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class Principal implements CommandLineRunner {

    private final OscarService oscarService;
    private final Scanner scanner = new Scanner(System.in);
    private List<Ator> listaAtores = new ArrayList<>();
    private List<Filme>listaFilmes = new ArrayList<>();

    public Principal(OscarService oscarService) {
        this.oscarService = oscarService;
    }

    @Override
    public void run(String... args) {
        exibeMenu();
    }

    private void exibeMenu() {
        int opcao = -1;
        String menu = """
                1 - Adicionar Ator
                2 - Adicionar Filme
                3 - Adicionar Indicação
                4 - Listar Indicações
                
                0 - Sair
                """;

        while (opcao != 0) {
            System.out.println(menu);
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    adicionarAtor();
                    break;
                case 2:
                    adicionarFilme();
                    break;
                case 3:
                    adicionarIndicacao();
                    break;
                case 4:
                    listarIndicacoes();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }


    private void adicionarAtor() {
        System.out.println("Digite o nome do ator:");
        String nome = scanner.nextLine();
        System.out.println("Digite a nacionalidade do ator:");
        String nacionalidade = scanner.nextLine();
        System.out.println("Esse ator é elegível? (S/N)");
        String elegivelInput = scanner.nextLine();

        Ator ator = new Ator();
        ator.setNome(nome);
        ator.setNacionalidade(nacionalidade);
        ator.setElegivel("S".equalsIgnoreCase(elegivelInput));
        listaAtores.add(ator);
        System.out.println("Ator adicionado: " + nome);
    }

    private void adicionarFilme() {
        System.out.println("Digite o nome do filme:");
        String nome = scanner.nextLine();
        System.out.println("Digite o gênero do filme");
        String genero = scanner.nextLine();
        System.out.println("Esse filme é elegível? (S/N)");
        String elegivelInput = scanner.nextLine();

        Filme filme = new Filme();
        filme.setNome(nome);
        filme.setGenero(genero);
        filme.setElegivel("S".equalsIgnoreCase(elegivelInput));
        listaFilmes.add(filme);
        System.out.println("Filme adicionado: " + nome);
    }


    private void adicionarIndicacao() {
        System.out.println("Você deseja adicionar uma indicação para um Ator ou um Filme? (A/F):");
        String tipo = scanner.nextLine();

        if ("A".equalsIgnoreCase(tipo)) {
            listaAtores.forEach(ator -> System.out.println(ator.getNome()));
            System.out.println("Digite o nome de um ator da lista para indicação:");
        } else if ("F".equalsIgnoreCase(tipo)) {
            listaFilmes.forEach(filme -> System.out.println(filme.getNome()));
            System.out.println("Digite o nome de um filme da lista para indicação:");
        } else {
            System.out.println("Opção inválida.");
            return;
        }

        String nome = scanner.nextLine();
        Indicavel indicavel = "A".equalsIgnoreCase(tipo) ?
                listaAtores.stream().filter(ator -> ator.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null) :
                listaFilmes.stream().filter(filme -> filme.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);

        if (indicavel == null) {
            System.out.println("Não foi possível encontrar o ator ou filme especificado.");
            return;
        }

        System.out.println("Digite a categoria da indicação:");
        String categoria = scanner.nextLine();

        Indicacao indicacao = new Indicacao();
        indicacao.setIndicavel(indicavel);
        indicacao.setCategoria(categoria);
        oscarService.adicionarIndicacao(indicacao);

    }

    private void listarIndicacoes() {
        oscarService.mostrarListaIndicados().forEach(indicacao -> {
            System.out.println("Indicado: " + indicacao.getIndicavel().getNome());
            System.out.println("Categoria: " + indicacao.getCategoria());
            System.out.println("Número de indicações: " + indicacao.getIndicavel().getNumeroDeIndicacoes());
            System.out.println();
        });
    }
}
