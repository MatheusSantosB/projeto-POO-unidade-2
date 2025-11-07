package com.jogopersonagens;

public class NaoJogavel extends Personagem {
    private boolean aliado;

    public NaoJogavel(String nome, int vitalidade, Jogo jogo, boolean aliado) {
        super(nome, vitalidade, jogo);
        this.aliado = aliado;
    }

    @Override
    public void aplicarGolpeEspecial(Personagem adversario) {
        int dano = calcularDanoEspecial();
        adversario.receberDano(dano);
        System.out.println(getNome() + " aplicou golpe especial em " + adversario.getNome() + " (-" + dano + ")");
    }

    private int calcularDanoEspecial() {
        Dificuldade dificuldade = getJogo().getDificuldade();
        switch (dificuldade) {
            case EASY: return 20;
            case MEDIUM: return 30;
            case HARD: return 40;
            default: return 30;
        }
    }

    // Getters e Setters
    public boolean isAliado() { return aliado; }
    public void setAliado(boolean aliado) { this.aliado = aliado; }
}