package estados;

import core.Tamagotchi;
import eventos.EventoAleatorio;

public class Comer implements Estado {
    public void executar(Tamagotchi t) {
        t.alterarFome(-50);
        t.alterarEnergia(10);
        t.envelhecer();
        EventoAleatorio.verificarEvento(t);
    }
}
