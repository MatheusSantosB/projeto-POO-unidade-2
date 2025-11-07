package com.jogodados;

public class Jogador {
    private String usuario;
    private int aposta;
    private int vitorias;

    public Jogador(String usuario, int aposta) {
        this.usuario = usuario.toLowerCase();
        this.aposta = aposta;
        this.vitorias = 0;
    }

    public String getUsuario() { return usuario; }
    public int getAposta() { return aposta; }
    public int getVitorias() { return vitorias; }
    public void incrementarVitorias() { vitorias++; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Jogador jogador = (Jogador) obj;
        return usuario.equals(jogador.usuario);
    }
}