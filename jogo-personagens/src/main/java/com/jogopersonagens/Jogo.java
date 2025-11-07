package com.jogopersonagens;

import java.util.ArrayList;
import java.util.List;

public class Jogo {
    private Dificuldade dificuldade;
    private List<Personagem> listaPersonagens;

    public Jogo(Dificuldade dificuldade) {
        this.dificuldade = dificuldade;
        this.listaPersonagens = new ArrayList<>();
    }

    public void adicionarPersonagem(Personagem personagem) {
        listaPersonagens.add(personagem);
        System.out.println("Personagem " + personagem.getNome() + " adicionado ao jogo");
    }

    public void removerPersonagem(Personagem personagem) {
        listaPersonagens.remove(personagem);
        System.out.println("Personagem " + personagem.getNome() + " removido do jogo");
    }

    // Getters e Setters
    public Dificuldade getDificuldade() { return dificuldade; }
    public List<Personagem> getListaPersonagens() { return listaPersonagens; }

    public void setDificuldade(Dificuldade dificuldade) {
        this.dificuldade = dificuldade;
    }
}