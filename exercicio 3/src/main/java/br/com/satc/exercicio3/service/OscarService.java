package br.com.satc.exercicio3.service;

import br.com.satc.exercicio3.component.Indicacao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OscarService {
    private final List<Indicacao> indicacoes = new ArrayList<>();

    public void adicionarIndicacao(Indicacao indicacao) {
        if (indicacao.getIndicavel().isElegivel()) {
            indicacao.getIndicavel().incrementarNumeroDeIndicacoes();
            indicacoes.add(indicacao);
            System.out.println("Indicação adicionada para " + indicacao.getIndicavel().getNome() + " na categoria " + indicacao.getCategoria() );
        } else
            System.out.print("Esse ator ou filme não é elegivel");
    }

    public List<Indicacao> mostrarListaIndicados() {
        return indicacoes;
    }
}