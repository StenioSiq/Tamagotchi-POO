package jokenpo;

public class Papel implements JokenpoStrategy {
    public String jogarContra(JokenpoStrategy o) {
        return (o instanceof Pedra) ? "Ganhou" : (o instanceof Tesoura) ? "Perdeu" : "Empate";
    }
    public String getNome() { return "Papel"; }
}
