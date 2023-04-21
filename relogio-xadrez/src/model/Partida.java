package model;

import java.util.Date;

public class Partida {
    private Jogador jogador1;
    private Jogador jogador2;
    private Relogio relogio1;
    private Relogio relogio2;
    private int numJogadas;
    private Date horaInicio;
    private Date horaFim;

    public Partida(Jogador jogador1, Jogador jogador2, int tempoMaximo) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.relogio1 = new Relogio(tempoMaximo);
        this.relogio2 = new Relogio(tempoMaximo);
        this.numJogadas = 0;
        this.horaInicio = null;
        this.horaFim = null;
    }

    public void iniciarPartida() {
        this.horaInicio = new Date();
        this.relogio1.iniciarContagem();
        this.relogio2.iniciarContagem();
    }

    public void realizarJogada() {
        // L�gica para alternar entre jogadores e decrementar o tempo do jogador da vez
        Jogador jogadorDaVez;
        Relogio relogioDaVez;
        if (this.numJogadas % 2 == 0) {
            jogadorDaVez = this.jogador1;
            relogioDaVez = this.relogio1;
        } else {
            jogadorDaVez = this.jogador2;
            relogioDaVez = this.relogio2;
        }
        relogioDaVez.decrementarTempo(jogadorDaVez.getTempoPorJogada());
        this.numJogadas++;
    }

    public void pararPartida() {
        this.horaFim = new Date();
        this.relogio1.pausarContagem();
        this.relogio2.pausarContagem();
    }

    public int getNumJogadas() {
        return this.numJogadas;
    }

    public Date getHoraInicio() {
        return this.horaInicio;
    }

    public Date getHoraFim() {
        return this.horaFim;
    }

    public Relogio getRelogio1(){
        return this.relogio1;
    }

    public Relogio getRelogio2(){
        return this.relogio2;
    }
    public int getTempoGastoJogador1() {
        return this.relogio1.getTempoMaximo() - this.relogio1.getTempoRestante();
    }

    public int getTempoGastoJogador2() {
        return this.relogio2.getTempoMaximo() - this.relogio2.getTempoRestante();
    }




}

