package main;

import java.util.Scanner;
import core.Tamagotchi;
import estados.*;
import jokenpo.JokenpoGame;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tamagotchi t = new Tamagotchi();

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Alimentar");
            System.out.println("2. Dormir");
            System.out.println("3. Brincar");
            System.out.println("4. Tomar banho");
            System.out.println("5. Conversar");
            System.out.println("6. Jogar Jokenpô");
            System.out.println("7. Ver status");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");

            int opcao = scanner.nextInt();
            Estado acao = null;

            switch (opcao) {
                case 1: acao = new Comer(); break;
                case 2: acao = new Dormir(); break;
                case 3: acao = new Brincar(); break;
                case 4: acao = new TomarBanho(); break;
                case 5: acao = new Conversar(); break;
                case 6: JokenpoGame.jogar(scanner); continue;
                case 7: t.status(); continue;
                case 0: System.out.println("Saindo..."); return;
                default: System.out.println("Opção inválida."); continue;
            }

            if (acao != null) acao.executar(t);
        }
    }
}
