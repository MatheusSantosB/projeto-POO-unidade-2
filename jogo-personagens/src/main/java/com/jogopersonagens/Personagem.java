package com.jogopersonagens;

public abstract class Personagem {
    private String nome;
    private int vitalidade;
    private Jogo jogo;

    public Personagem(String nome, int vitalidade, Jogo jogo) {
        this.nome = nome;
        setVitalidade(vitalidade);
        this.jogo = jogo;
    }

    public void setVitalidade(int vitalidade) {
        if (vitalidade < 0) {
            this.vitalidade = 0;
        } else if (vitalidade > 100) {
            this.vitalidade = 100;
        } else {
            this.vitalidade = vitalidade;
        }
    }

    public void aplicarGolpeNormal(Personagem adversario) {
        adversario.receberDano(10);
        System.out.println(nome + " aplicou golpe normal em " + adversario.getNome() + " (-10)");
    }

    public void receberDano(int dano) {
        this.vitalidade -= dano;
        if (this.vitalidade < 0) {
            this.vitalidade = 0;
        }
    }

    public abstract void aplicarGolpeEspecial(Personagem adversario);

    // Getters e Setters
    public String getNome() { return nome; }
    public int getVitalidade() { return vitalidade; }
    public Jogo getJogo() { return jogo; }

    public void setNome(String nome) { this.nome = nome; }
    public void setJogo(Jogo jogo) { this.jogo = jogo; }
}