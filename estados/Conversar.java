package estados;

import core.Tamagotchi;
import eventos.EventoAleatorio;

public class Conversar implements Estado {
    public void executar(Tamagotchi t) {
        t.alterarSocializacao(30);
        t.alterarEnergia(-15);
        t.envelhecer();
        EventoAleatorio.verificarEvento(t);
    }
}
