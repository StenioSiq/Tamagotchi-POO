package core;

import core.CicloDeVida;

public class Tamagotchi {
    private int fome = 50;
    private int energia = 50;
    private int felicidade = 50;
    private int higiene = 50;
    private int socializacao = 50;
    private int idade = 0;
    private CicloDeVida fase = CicloDeVida.BEBE;

    public void alterarFome(int v) { fome = Math.max(0, Math.min(100, fome + v)); }
    public void alterarEnergia(int v) { energia = Math.max(0, Math.min(100, energia + v)); }
    public void alterarFelicidade(int v) { felicidade = Math.max(0, Math.min(100, felicidade + v)); }
    public void alterarHigiene(int v) { higiene = Math.max(0, Math.min(100, higiene + v)); }
    public void alterarSocializacao(int v) { socializacao = Math.max(0, Math.min(100, socializacao + v)); }

    public void envelhecer() {
        idade++;
        if (idade >= 10 && idade < 20) fase = CicloDeVida.ADOLESCENTE;
        else if (idade >= 20) fase = CicloDeVida.ADULTO;
    }

    public void status() {
        System.out.println("\n=== STATUS TAMAGOTCHI ===");
        System.out.println("Fome: " + fome);
        System.out.println("Energia: " + energia);
        System.out.println("Felicidade: " + felicidade);
        System.out.println("Higiene: " + higiene);
        System.out.println("Socialização: " + socializacao);
        System.out.println("Fase: " + fase);
        System.out.println("Idade: " + idade);
    }
}
