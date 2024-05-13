package br.com.satc.exercicio3;

public interface Indicavel {
    boolean isElegivel();
    void setElegivel(boolean elegivel);

    short getNumeroDeIndicacoes();
    void incrementarNumeroDeIndicacoes();

    String getNome();
}
