package com.sistema;

public abstract class C1 {
    protected String nome;
    protected int id;

    // Sobrecarga de construtores
    public C1() {
        this.nome = "Sem nome";
        this.id = 0;
    }

    public C1(String nome) {
        this.nome = nome;
        this.id = 0;
    }

    public C1(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    // Método abstrato
    public abstract void executar();

    // Sobrecarga de métodos
    public void exibirInfo() {
        System.out.println("Nome: " + nome + ", ID: " + id);
    }

    public void exibirInfo(boolean detalhado) {
        if (detalhado) {
            System.out.println("=== INFO DETALHADA ===");
            System.out.println("Nome: " + nome);
            System.out.println("ID: " + id);
            System.out.println("Classe: " + this.getClass().getSimpleName());
        } else {
            exibirInfo();
        }
    }

    // Getter e Setter
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
}