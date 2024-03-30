package br.com.satc.exercicio3.component;

import br.com.satc.exercicio3.Indicavel;

public class Filme implements Indicavel {
    private String nome;
    private String genero;
    private boolean elegivel;
    private short numeroDeIndicacoes;

    public Filme(){}

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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setNumeroDeIndicacoes(short numeroDeIndicacoes) {
        this.numeroDeIndicacoes = numeroDeIndicacoes;
    }

    @Override
    public String toString() {
        return
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", numeroDeIndicacoes=" + numeroDeIndicacoes;
    }
}


