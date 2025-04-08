package jokenpo;

public class Pedra implements JokenpoStrategy {
    public String jogarContra(JokenpoStrategy o) {
        return (o instanceof Tesoura) ? "Ganhou" : (o instanceof Papel) ? "Perdeu" : "Empate";
    }
    public String getNome() { return "Pedra"; }
}
