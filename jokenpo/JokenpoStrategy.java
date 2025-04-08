package jokenpo;

public interface JokenpoStrategy {
    String jogarContra(JokenpoStrategy oponente);
    String getNome();
}