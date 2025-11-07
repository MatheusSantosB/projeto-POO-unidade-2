package com.sistema;

public class C2 extends C1 {
    private double valor;

    // Sobrecarga de construtores
    public C2() {
        super();
        this.valor = 0.0;
    }

    public C2(String nome, double valor) {
        super(nome);
        this.valor = valor;
    }

    public C2(String nome, int id, double valor) {
        super(nome, id);
        this.valor = valor;
    }

    // Sobreposição de método
    @Override
    public void executar() {
        System.out.println("C2 executando - Valor: " + valor);
    }

    // Método próprio
    public void calcularValor() {
        this.valor *= 1.1; // Aumenta 10%
        System.out.println("Novo valor: " + valor);
    }

    // Sobrecarga de método
    public void calcularValor(double percentual) {
        this.valor *= (1 + percentual / 100);
        System.out.println("Valor com " + percentual + "%: " + valor);
    }

    public double getValor() { return valor; }
}