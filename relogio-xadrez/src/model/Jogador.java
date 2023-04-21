package model;

public class Jogador {
    private String nome;
    private int tempoPorJogada;

    public Jogador(String nome, int tempoPorJogada) {
        this.nome = nome;
        this.tempoPorJogada = tempoPorJogada;
    }

    public String getNome() {
        return this.nome;
    }

    public int getTempoPorJogada() {
        return this.tempoPorJogada;
    }
}

