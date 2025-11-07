package com.sistema;

public class C4 extends C2 {
    private int quantidade;

    public C4() {
        super();
        this.quantidade = 1;
    }

    public C4(String nome, double valor, int quantidade) {
        super(nome, valor);
        this.quantidade = quantidade;
    }

    // Sobreposição de método
    @Override
    public void executar() {
        System.out.println("C4 executando - Quantidade: " + quantidade + ", Valor total: " + (getValor() * quantidade));
    }

    // Sobreposição com chamada ao super
    @Override
    public void exibirInfo(boolean detalhado) {
        if (detalhado) {
            super.exibirInfo(detalhado);
            System.out.println("Quantidade: " + quantidade);
        } else {
            System.out.println("C4 - Nome: " + getNome() + ", Qtd: " + quantidade);
        }
    }

    // Método próprio
    public void incrementarQuantidade() {
        quantidade++;
        System.out.println("Quantidade incrementada para: " + quantidade);
    }

    public int getQuantidade() { return quantidade; }
}