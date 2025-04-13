package main;

import javax.swing.*;
import java.awt.*;

import core.Tamagotchi;
import estados.Estado;
import estados.Comer;
import estados.Dormir;
import estados.Brincar;
import estados.TomarBanho;
import estados.Conversar;
import javax.swing.Timer;
import eventos.EventoAleatorio;
import jokenpo.JokenpoGUI;

public class Main {

    private static Tamagotchi tamagotchi = new Tamagotchi();
    private static JLabel statusLabel;

    public static void main(String[] args) {
        // Solicita o nome do Tamagotchi ao iniciar o jogo
        String nome = JOptionPane.showInputDialog("Digite o nome do seu Tamagotchi:");
        if (nome != null && !nome.trim().isEmpty()) {
            tamagotchi.setNome(nome);
        }

        // Cria a janela principal com o nome no título
        JFrame frame = new JFrame("Tamagotchi POO - " + tamagotchi.getNome());
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Cria o painel principal com layout em grade
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1, 10, 10));

        // Label para exibir o status do Tamagotchi
        statusLabel = new JLabel(getStatusText(), SwingConstants.CENTER);
        panel.add(statusLabel);

        // Botões para as ações do Tamagotchi
        JButton btnComer = new JButton("🍖 Comer");
        JButton btnDormir = new JButton("😴 Dormir");
        JButton btnBrincar = new JButton("⚽ Brincar");
        JButton btnBanho = new JButton("🛁 Tomar Banho");
        JButton btnConversar = new JButton("💬 Conversar");
        JButton btnJokenpo = new JButton("🎮 Jokenpô");

        // Configura os listeners para chamar as ações do Tamagotchi
        btnComer.addActionListener(e -> executarAcao(new Comer()));
        btnDormir.addActionListener(e -> executarAcao(new Dormir()));
        btnBrincar.addActionListener(e -> executarAcao(new Brincar()));
        btnBanho.addActionListener(e -> executarAcao(new TomarBanho()));
        btnConversar.addActionListener(e -> executarAcao(new Conversar()));
        // Listener para iniciar o Jokenpô
        btnJokenpo.addActionListener(e -> iniciarJokenpo());

        // Adiciona os botões no painel
        panel.add(btnComer);
        panel.add(btnDormir);
        panel.add(btnBrincar);
        panel.add(btnBanho);
        panel.add(btnConversar);
        panel.add(btnJokenpo);

        frame.add(panel);
        frame.setVisible(true);

        // Inicia o ciclo automático de atualização do Tamagotchi
        iniciarCicloAutomatico();
    }

    // Executa uma ação recebida pela interface Estado e atualiza o status
    private static void executarAcao(Estado acao) {
        tamagotchi.executarAcao(acao);
        atualizarStatus();
    }

    // Atualiza a label de status na interface
    private static void atualizarStatus() {
        statusLabel.setText(getStatusText());
    }

    // Formata o texto de status para exibição na interface
    private static String getStatusText() {
        return "<html><b>Nome:</b> " + tamagotchi.getNome() +
                " | <b>Idade:</b> " + tamagotchi.getIdade() +
                "<br><b>Fome:</b> " + tamagotchi.getFome() +
                " | <b>Energia:</b> " + tamagotchi.getEnergia() +
                " | <b>Felicidade:</b> " + tamagotchi.getFelicidade() +
                " | <b>Higiene:</b> " + tamagotchi.getHigiene() +
                " | <b>Socialização:</b> " + tamagotchi.getSocializacao() +
                "<br><b>Doente:</b> " + (tamagotchi.isDoente() ? "Sim" : "Não") +
                " | <b>Estado:</b> " + getEstadoTexto() +
                "</html>";
    }

    // Converte o enum CicloDeVida para uma string legível
    private static String getEstadoTexto() {
        switch (tamagotchi.getEstado()) {
            case BEBE:
                return "Bebê";
            case ADOLESCENTE:
                return "Adolescente";
            case ADULTO:
                return "Adulto";
            default:
                return "Desconhecido";
        }
    }

    // Inicia o ciclo automático com um Timer que atualiza os status a cada 5 segundos
    private static void iniciarCicloAutomatico() {
        Timer timer = new Timer(5000, e -> {
            if (!tamagotchi.isVivo()) {
                JOptionPane.showMessageDialog(null, "💀 O Tamagotchi morreu. Fim de jogo!");
                ((Timer) e.getSource()).stop();
                return;
            }

            tamagotchi.envelhecer();
            tamagotchi.alterarFome(5);
            tamagotchi.alterarEnergia(-5);
            tamagotchi.alterarHigiene(-3);
            tamagotchi.alterarSocializacao(-2);
            EventoAleatorio.verificarEvento(tamagotchi);
            tamagotchi.verificarSeMorreu();
            atualizarStatus();
        });
        timer.start();
    }

    // Método que inicia a interface do jogo Jokenpô
    private static void iniciarJokenpo() {
        // Abre a interface gráfica do Jokenpô invocando a main de JokenpoGUI
        JokenpoGUI.main(null);
    }
}