package com.sistema;

public class C5 extends C2 implements I1 {
    private String categoria;

    public C5() {
        super();
        this.categoria = "Geral";
    }

    public C5(String nome, double valor, String categoria) {
        super(nome, valor);
        this.categoria = categoria;
    }

    // Sobreposição de método
    @Override
    public void executar() {
        System.out.println("C5 executando - Categoria: " + categoria);
    }

    // Implementação I1
    @Override
    public void metodoInterface1() {
        System.out.println("Método I1 implementado em C5 - Categoria: " + categoria);
    }

    @Override
    public String processarDados(String dados) {
        return "C5[" + categoria + "] processou: " + dados.toLowerCase();
    }

    // Método próprio
    public void mudarCategoria(String novaCategoria) {
        this.categoria = novaCategoria;
        System.out.println("Categoria alterada para: " + novaCategoria);
    }

    // Sobrecarga de método
    public void mudarCategoria(String novaCategoria, boolean confirmar) {
        if (confirmar) {
            mudarCategoria(novaCategoria);
        } else {
            System.out.println("Mudança de categoria cancelada");
        }
    }

    public String getCategoria() { return categoria; }
}