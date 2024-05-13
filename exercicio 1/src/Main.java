import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Main {
    public static String retornaListaDaURI(String minhaUri) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(minhaUri)).build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        return response.body();
    }

    public static String retornaIndiceAleatorio(String stringao) {
        String[] listaDeNomes = stringao.split("\n");
        int indiceAleatorio = (int) Math.floor(Math.random() * listaDeNomes.length);
        return listaDeNomes[indiceAleatorio];
    }

    public static int geraIdadeAleatoria() {
        return 17 + (int) (Math.random() * (24));
    }

    public static void main(String[] args) throws Exception {
        String listaDeNomes = retornaListaDaURI("https://venson.net.br/resources/data/nomes.txt");
        String nome = retornaIndiceAleatorio(listaDeNomes);

        String listaDeSobrenomes = retornaListaDaURI("https://venson.net.br/resources/data/sobrenomes.txt");
        String sobrenome = retornaIndiceAleatorio(listaDeSobrenomes);

        String listaDePosicoes = retornaListaDaURI("https://venson.net.br/resources/data/posicoes.txt");
        String posicao = retornaIndiceAleatorio(listaDePosicoes);
        posicao = posicao.replace("\"", "");
        posicao = posicao.replace(",", "");

        String listaDeClubes = retornaListaDaURI("https://venson.net.br/resources/data/clubes.txt");
        String clube = retornaIndiceAleatorio(listaDeClubes);

        int idade = geraIdadeAleatoria();

        System.out.printf("%s %s é um futebolista brasileiro de %s anos que atua como %s. Atualmente defende o %s.\n",
                nome, sobrenome, idade, posicao, clube);
    }
}
