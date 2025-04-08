package estados;

import core.Tamagotchi;
import eventos.EventoAleatorio;

public class Dormir implements Estado {
    public void executar(Tamagotchi t) {
        t.alterarEnergia(100);
        t.alterarHigiene(-10);
        t.envelhecer();
        EventoAleatorio.verificarEvento(t);
    }
}
