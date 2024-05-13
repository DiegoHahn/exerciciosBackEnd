package br.com.satc.exercicio3.component;

import br.com.satc.exercicio3.Indicavel;

public class Ator implements Indicavel {
    private String nome;
    private String nacionalidade;
    private boolean elegivel;
    private short numeroDeIndicacoes;

    public Ator() {}

    @Override
    public boolean isElegivel() {
        return elegivel;
    }

    @Override
    public void setElegivel(boolean elegivel) {
        this.elegivel = elegivel;
    }

    @Override
    public short getNumeroDeIndicacoes() {
        return numeroDeIndicacoes;
    }

    @Override
    public void incrementarNumeroDeIndicacoes() {
        this.numeroDeIndicacoes++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public void setNumeroDeIndicacoes(short numeroDeIndicacoes) {
        this.numeroDeIndicacoes = numeroDeIndicacoes;
    }

    @Override
    public String toString() {
        return
                "nome = '" + nome + '\'' +
                ", nacionalidade = '" + nacionalidade + '\'' +
                ", numeroDeIndicacoes = " + numeroDeIndicacoes ;
    }
}
