package jokenpo;

import java.util.Random;
import java.util.Scanner;

public class JokenpoGame {
    private static final JokenpoStrategy[] jogadas = {
            new Pedra(), new Papel(), new Tesoura()
    };

    public static void jogar(Scanner scanner) {
        System.out.println("\n--- JOKENPÔ ---");
        System.out.println("Escolha sua jogada:");
        System.out.println("1. Pedra  2. Papel  3. Tesoura");
        int escolha = scanner.nextInt() - 1;

        if (escolha < 0 || escolha > 2) {
            System.out.println("Jogada inválida!");
            return;
        }

        JokenpoStrategy jogador = jogadas[escolha];
        JokenpoStrategy tamagotchi = jogadas[new Random().nextInt(3)];

        System.out.println("Você: " + jogador.getNome());
        System.out.println("Tamagotchi: " + tamagotchi.getNome());

        String resultado = jogador.jogarContra(tamagotchi);
        System.out.println("Resultado: " + resultado);
    }
}
