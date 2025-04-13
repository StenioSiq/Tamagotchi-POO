package core;

import estados.Estado;

public class Tamagotchi {
    private String nome = "Tama";
    private int fome = 50;
    private int energia = 50;
    private int felicidade = 50;
    private int higiene = 50;
    private int socializacao = 50;
    private int idade = 0;
    private boolean doente = false;
    private boolean vivo = true;
    private CicloDeVida fase = CicloDeVida.BEBE;

    // Novo método para definir o nome do Tamagotchi
    public void setNome(String nome) {
        this.nome = nome;
    }


    public void setDoente(boolean doente) {
        this.doente = doente;
    }

    public void alterarFome(int v) {
        fome = Math.max(0, Math.min(100, fome + v));
    }

    public void alterarEnergia(int v) {
        energia = Math.max(0, Math.min(100, energia + v));
    }

    public void alterarFelicidade(int v) {
        felicidade = Math.max(0, Math.min(100, felicidade + v));
    }

    public void alterarHigiene(int v) {
        higiene = Math.max(0, Math.min(100, higiene + v));
    }

    public void alterarSocializacao(int v) {
        socializacao = Math.max(0, Math.min(100, socializacao + v));
    }

    // Método para executar uma ação utilizando a interface Estado
    public void executarAcao(Estado acao) {
        if (vivo) {
            acao.executar(this);
            envelhecer();  // Envelhecer após cada ação para verificar mudanças de fase
        }
    }

    public void verificarSeMorreu() {
        if (fome >= 100 || energia <= 0 || felicidade <= 0 || higiene <= 0) {
            vivo = false;
            System.out.println("💀 O Tamagotchi morreu!");
        }
    }

    public boolean isVivo() {
        return vivo;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public int getFome() {
        return fome;
    }

    public int getEnergia() {
        return energia;
    }

    public int getFelicidade() {
        return felicidade;
    }

    public int getHigiene() {
        return higiene;
    }

    public int getSocializacao() {
        return socializacao;
    }

    public boolean isDoente() {
        return doente;
    }

    public CicloDeVida getEstado() {
        return fase;
    }

    public void envelhecer() {
        idade++;
        if (idade >= 10 && idade < 20) {
            fase = CicloDeVida.ADOLESCENTE;
        } else if (idade >= 20) {
            fase = CicloDeVida.ADULTO;
        }
    }

}