package com.sistema;

public class Principal {
    public static void main(String[] args) {
        System.out.println("=== DEMONSTRAÇÃO DO SISTEMA ===\n");

        // Criando objetos de cada classe concreta
        C2 objC2 = new C2("Objeto C2", 100.0);
        C3 objC3 = new C3("Objeto C3", true);
        C4 objC4 = new C4("Objeto C4", 50.0, 3);
        C5 objC5 = new C5("Objeto C5", 75.0, "Especial");

        System.out.println("=== TESTANDO MÉTODOS EXECUTAR (SOBREPOSIÇÃO) ===");
        objC2.executar();
        objC3.executar();
        objC4.executar();
        objC5.executar();

        System.out.println("\n=== TESTANDO SOBRECARGA DE MÉTODOS ===");
        objC2.exibirInfo();
        objC2.exibirInfo(true);

        System.out.println("\n=== TESTANDO SOBRECARGA DE MÉTODOS PRÓPRIOS ===");
        objC2.calcularValor();
        objC2.calcularValor(20.0);

        System.out.println("\n=== TESTANDO INTERFACES ===");
        // Testando I1 e I2 em C3
        objC3.metodoInterface1();
        System.out.println("Processamento: " + objC3.processarDados("dados de teste"));
        objC3.metodoInterface2();
        System.out.println("Cálculo: " + objC3.calcular(5, 4));
        objC3.configurar("parâmetro especial");

        // Testando I1 em C5
        objC5.metodoInterface1();
        System.out.println("Processamento: " + objC5.processarDados("DADOS MAIÚSCULOS"));

        System.out.println("\n=== TESTANDO MÉTODOS PRÓPRIOS ===");
        objC3.alternarEstado();
        objC4.incrementarQuantidade();
        objC5.mudarCategoria("Premium");
        objC5.mudarCategoria("Ultra", false); // Sobrecarga

        System.out.println("\n=== POLIMORFISMO COM C1 ===");
        C1[] objetos = {objC2, objC3, objC4, objC5};

        for (C1 obj : objetos) {
            System.out.print(obj.getClass().getSimpleName() + ": ");
            obj.executar(); // Chamada polimórfica
        }

        System.out.println("\n=== DEMONSTRAÇÃO DE CONSTRUTORES ===");
        // Sobrecarga de construtores
        C2 construtor1 = new C2();
        C2 construtor2 = new C2("Teste", 200.0);
        C2 construtor3 = new C2("Teste ID", 999, 300.0);

        construtor1.exibirInfo(true);
        construtor2.exibirInfo(true);
        construtor3.exibirInfo(true);

        System.out.println("\n=== PROGRAMA FINALIZADO ===");
    }
}