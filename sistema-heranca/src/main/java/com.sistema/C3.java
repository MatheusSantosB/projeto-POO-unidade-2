package com.sistema;

public class C3 extends C1 implements I1, I2 {
    private boolean ativo;

    public C3() {
        super();
        this.ativo = true;
    }

    public C3(String nome, boolean ativo) {
        super(nome);
        this.ativo = ativo;
    }

    // Sobreposição de método
    @Override
    public void executar() {
        System.out.println("C3 executando - Ativo: " + ativo);
    }

    // Implementação I1
    @Override
    public void metodoInterface1() {
        System.out.println("Método da Interface I1 implementado em C3");
    }

    @Override
    public String processarDados(String dados) {
        return "C3 processou: " + dados.toUpperCase();
    }

    // Implementação I2
    @Override
    public void metodoInterface2() {
        System.out.println("Método da Interface I2 implementado em C3");
    }

    @Override
    public int calcular(int a, int b) {
        return a * b; // Multiplicação
    }

    @Override
    public void configurar(String parametro) {
        System.out.println("C3 configurado com: " + parametro);
    }

    // Método próprio
    public void alternarEstado() {
        this.ativo = !this.ativo;
        System.out.println("Novo estado: " + (ativo ? "ATIVO" : "INATIVO"));
    }

    public boolean isAtivo() { return ativo; }
}