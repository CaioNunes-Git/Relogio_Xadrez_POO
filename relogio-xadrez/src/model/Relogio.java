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

    public void iniciarContagem() {
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
    public void reiniciar() {
        this.relogioPausado = false;
        this.tempoRestante = tempoMaximo;
    }

    public void pausarContagem() {
        this.relogioPausado = true;
    }

    public int getTempoMaximo() {
        return tempoMaximo;
    }

    public int getTempoRestante() {
        return tempoRestante;
    }

    public void decrementadorTempo(int tempoPorJogada) {
        if (this.tempoRestante >= tempoPorJogada) {
            this.tempoRestante -= tempoPorJogada;
        } else {
            this.tempoRestante = 0;
        }
    }
}
