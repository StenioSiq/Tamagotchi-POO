package jokenpo;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class JokenpoGUI {

    private static final JokenpoStrategy[] jogadas = {
            new Pedra(), new Papel(), new Tesoura()
    };

    public static void main(String[] args) {
        // Criação da janela principal
        JFrame frame = new JFrame("Jokenpô");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Painel de botões para escolher as jogadas
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3));

        // Botões de jogadas
        JButton pedraButton = new JButton("Pedra");
        JButton papelButton = new JButton("Papel");
        JButton tesouraButton = new JButton("Tesoura");

        // Label para exibir o resultado
        JLabel resultLabel = new JLabel("Escolha sua jogada!", SwingConstants.CENTER);

        // Adicionando ação aos botões
        pedraButton.addActionListener(e -> jogar(0, resultLabel));
        papelButton.addActionListener(e -> jogar(1, resultLabel));
        tesouraButton.addActionListener(e -> jogar(2, resultLabel));

        // Adicionando botões ao painel
        panel.add(pedraButton);
        panel.add(papelButton);
        panel.add(tesouraButton);

        // Configurando a exibição da interface
        frame.add(resultLabel, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    // Método para gerenciar a jogada e exibir o resultado
    private static void jogar(int escolhaJogador, JLabel resultLabel) {
        JokenpoStrategy jogador = jogadas[escolhaJogador];
        JokenpoStrategy tamagotchi = jogadas[new Random().nextInt(3)];

        // Resultado da partida
        String resultado = jogador.jogarContra(tamagotchi);

        // Exibindo o resultado na interface gráfica
        resultLabel.setText("<html>Você: " + jogador.getNome() + "<br>" +
                "Tamagotchi: " + tamagotchi.getNome() + "<br>" +
                "Resultado: " + resultado + "</html>");
    }
}