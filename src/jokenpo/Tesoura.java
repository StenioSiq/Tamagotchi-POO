package jokenpo;

public class Tesoura implements JokenpoStrategy {
    public String jogarContra(JokenpoStrategy o) {
        return (o instanceof Papel) ? "Ganhou" : (o instanceof Pedra) ? "Perdeu" : "Empate";
    }
    public String getNome() { return "Tesoura"; }
}
