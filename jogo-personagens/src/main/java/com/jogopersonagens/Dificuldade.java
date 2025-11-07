package com.jogopersonagens;

public enum Dificuldade {
    EASY("Easy"),
    MEDIUM("Medium"),
    HARD("Hard");

    private String descricao;

    Dificuldade(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}