package estados;

import core.Tamagotchi;
import eventos.EventoAleatorio;

public class Brincar implements Estado {
    public void executar(Tamagotchi t) {
        t.alterarFelicidade(20);
        t.alterarEnergia(-30);
        t.alterarFome(20);
        t.alterarHigiene(-15);
        t.alterarSocializacao(15);
        t.envelhecer();
        EventoAleatorio.verificarEvento(t);
    }
}
