package eventos;

import java.util.Random;
import core.Tamagotchi;

public class EventoAleatorio {
    public static void verificarEvento(Tamagotchi t) {
        Random rand = new Random();
        int chance = rand.nextInt(100);

        if (chance < 10) {
            System.out.println("\n[Evento] O Tamagotchi ficou doente! Energia -20");
            t.alterarEnergia(-20);
            t.setDoente(true);
        } else if (chance < 20) {
            System.out.println("\n[Evento] Está chovendo! Felicidade -10");
            t.alterarFelicidade(-10);
        }
    }
}
