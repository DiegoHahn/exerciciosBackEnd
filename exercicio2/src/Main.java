public class Main {
    public static void main(String[] args) throws Exception {
        JogadorGerador gerador = new JogadorGerador();
        Jogador jogador = gerador.geraJogador();

        System.out.println(jogador.getDescricao());
    }
}
