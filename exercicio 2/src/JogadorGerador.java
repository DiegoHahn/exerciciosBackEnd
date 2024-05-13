import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;

public class JogadorGerador {
    private List<String> nomes;
    private List<String> sobrenomes;
    private List<String> posicoes;
    private List<String> clubes;

    private List<String> carregaLista(String uri) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        return List.of(response.body()
                .replace("\"", "")
                .replace(",", "")
                .replace("-", " ")
                .split("\n"));
    }

    public JogadorGerador() throws Exception {
        nomes = carregaLista("https://venson.net.br/resources/data/nomes.txt");
        sobrenomes = carregaLista("https://venson.net.br/resources/data/sobrenomes.txt");
        posicoes = carregaLista("https://venson.net.br/resources/data/posicoes.txt");
        clubes = carregaLista("https://venson.net.br/resources/data/clubes.txt");
    }

    public Jogador geraJogador() {
        String nome = nomes.get((int) (Math.random() * nomes.size()));
        String sobrenome = sobrenomes.get((int) (Math.random() * sobrenomes.size()));
        String posicao = posicoes.get((int) (Math.random() * posicoes.size()));
        String clube = clubes.get((int) (Math.random() * clubes.size()));
        int idade = 17 + (int) (Math.random() * (40 - 17));

        return new Jogador(nome, sobrenome, posicao, idade, clube);
    }
}
