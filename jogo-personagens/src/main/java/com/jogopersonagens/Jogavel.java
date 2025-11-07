package com.jogopersonagens;

public class Jogavel extends Personagem implements Controle {
    private int nivel;

    public Jogavel(String nome, int vitalidade, Jogo jogo, int nivel) {
        super(nome, vitalidade, jogo);
        setNivel(nivel);
    }

    public void setNivel(int nivel) {
        if (nivel < 1) {
            this.nivel = 1;
        } else if (nivel > 5) {
            this.nivel = 5;
        } else {
            this.nivel = nivel;
        }
    }

    @Override
    public void aplicarGolpeEspecial(Personagem adversario) {
        int dano = 10 * nivel;
        adversario.receberDano(dano);
        System.out.println(getNome() + " aplicou golpe especial em " + adversario.getNome() + " (-" + dano + ")");
    }

    // Implementação da interface Controle
    @Override
    public void botaoA(Personagem adversario) {
        aplicarGolpeNormal(adversario);
    }

    @Override
    public void botaoB(Personagem adversario) {
        aplicarGolpeEspecial(adversario);
    }

    public int getNivel() { return nivel; }
}