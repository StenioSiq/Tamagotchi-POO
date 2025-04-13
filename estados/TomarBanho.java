package estados;

import core.Tamagotchi;
import eventos.EventoAleatorio;

public class TomarBanho implements Estado {
    public void executar(Tamagotchi t) {
        t.alterarHigiene(50);
        t.alterarEnergia(-10);
        t.envelhecer();
        t.setDoente(false);
        EventoAleatorio.verificarEvento(t);
    }
}
