package model;

public class Relogio {
    private final int tempoMaximo;
    private int tempoRestante;
    private boolean emAndamento;
    private boolean relogioPausado;

    public Relogio(int tempoMaximo) {
        this.tempoMaximo = tempoMaximo;
        this.tempoRestante = tempoMaximo;
        this.emAndamento = false;
        this.relogioPausado = false;
    }

    public synchronized void iniciarContagem() {
        if (!this.emAndamento || this.relogioPausado || this.tempoRestante == tempoMaximo) {
            this.emAndamento = true;
            this.relogioPausado = false;
            Thread thread = new Thread(() -> {
                while (this.tempoRestante > 0 && this.emAndamento) {
                    if (!this.relogioPausado) {
                        try {
                            Thread.sleep(1000);
                            this.tempoRestante--;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            thread.start();
        }
    }
    public synchronized void reiniciar() {
        this.relogioPausado = false;
        this.tempoRestante = tempoMaximo;
    }

    public synchronized void pausarContagem() {
        this.relogioPausado = true;
    }

    public synchronized boolean isEmAndamento() {
        return emAndamento;
    }

    public synchronized boolean isRelogioPausado() {
        return relogioPausado;
    }

    public int getTempoMaximo() {
        return tempoMaximo;
    }

    public synchronized int getTempoRestante() {
        return tempoRestante;
    }

    public synchronized void decrementarTempo(int tempoPorJogada) {
        if (this.tempoRestante >= tempoPorJogada) {
            this.tempoRestante -= tempoPorJogada;
        } else {
            this.tempoRestante = 0;
        }
    }
}
