package com.jogopersonagens;

public class Principal {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE JOGO DE PERSONAGENS ===\n");

        // Criar jogo no nível MÉDIO
        Jogo jogo = new Jogo(Dificuldade.MEDIUM);
        System.out.println("Jogo criado com dificuldade: " + jogo.getDificuldade().getDescricao());

        // Criar personagens
        Jogavel p1 = new Jogavel("Paulo", 100, jogo, 3);
        NaoJogavel p2 = new NaoJogavel("Luísa", 100, jogo, false);

        // Adicionar personagens ao jogo
        jogo.adicionarPersonagem(p1);
        jogo.adicionarPersonagem(p2);

        System.out.println("\n=== TESTE 1 ===");
        System.out.println("Jogador aplica 2 golpes normais e 1 especial no Não-Jogável");
        System.out.println("Vitalidade inicial de " + p2.getNome() + ": " + p2.getVitalidade());

        // TESTE 1: Jogavel ataca NaoJogavel
        p1.botaoA(p2); // Golpe normal
        p1.botaoA(p2); // Golpe normal
        p1.botaoB(p2); // Golpe especial

        System.out.println("Vitalidade final de " + p2.getNome() + ": " + p2.getVitalidade());

        System.out.println("\n=== TESTE 2 ===");
        System.out.println("Não-Jogável aplica 1 golpe especial e 1 normal no Jogável");
        System.out.println("Vitalidade inicial de " + p1.getNome() + ": " + p1.getVitalidade());

        // TESTE 2: NaoJogavel ataca Jogavel
        p2.aplicarGolpeEspecial(p1); // Golpe especial
        p2.aplicarGolpeNormal(p1);   // Golpe normal

        System.out.println("Vitalidade final de " + p1.getNome() + ": " + p1.getVitalidade());

        System.out.println("\n=== RESUMO FINAL ===");
        System.out.println(p1.getNome() + " (Jogável): " + p1.getVitalidade() + " de vitalidade");
        System.out.println(p2.getNome() + " (Não-Jogável): " + p2.getVitalidade() + " de vitalidade");

        System.out.println("\n=== FIM DOS TESTES ===");
    }
}