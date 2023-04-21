package main;

import model.Jogador;
import model.Partida;

public class Main {
    public static void main(String[] args) {
        Jogador jogador1 = new Jogador("Caio",2);
        Jogador jogador2 = new Jogador("Fernanda",3);

        Partida partidaUnica = new Partida(jogador1,jogador2,60);

        partidaUnica.iniciarPartida();

        partidaUnica.realizarJogada(); //Player1
        partidaUnica.realizarJogada(); //Player2
        partidaUnica.realizarJogada(); //Player1
        partidaUnica.realizarJogada(); //Player2
        partidaUnica.realizarJogada(); //Player1
        partidaUnica.realizarJogada(); //Player2
        partidaUnica.realizarJogada(); //Player1
        partidaUnica.realizarJogada(); //Player2
        partidaUnica.realizarJogada(); //Player1
        partidaUnica.realizarJogada(); //Player2
        partidaUnica.realizarJogada(); //Player1
        partidaUnica.realizarJogada(); //Player2
        partidaUnica.pararPartida();

        System.out.println("-----------INFORMAÇÕES SOBRE A PARTIDA-----------");
        System.out.println("Hora de inicio da partida: " + partidaUnica.getHoraInicio());
        System.out.println("Hora de fim da partida: " + partidaUnica.getHoraFim());
        System.out.println("Número total de jogadas da partida: " + partidaUnica.getNumJogadas() + "\n");

        System.out.println("----------- "+jogador1.getNome()+" -----------");
        System.out.println("Tempo total que foi gasto por " + jogador1.getNome() + " foi: " + partidaUnica.getTempoGastoJogador1() + "min");
        System.out.println("Tempo restante jogador 1: " + partidaUnica.getRelogio1().getTempoRestante() + "min" +"\n");

        System.out.println("----------- "+jogador2.getNome()+" -----------");
        System.out.println("Tempo total que foi gasto por " + jogador2.getNome() + " foi: " + partidaUnica.getTempoGastoJogador2() + "min");
        System.out.println("Tempo restante jogador 2: " + partidaUnica.getRelogio2().getTempoRestante() + "min");
    }
}