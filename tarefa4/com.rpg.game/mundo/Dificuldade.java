package mundo;

public enum Dificuldade {
    FACIL(1.0),
    MEDIO(1.3),
    DIFICIL(1.5);

    private double mult_dificuldade;
    Dificuldade(double numero){
        this.mult_dificuldade = numero;
    }
    // Getters
    public double getMult_dificuldade() {
        return mult_dificuldade;
    }

}

