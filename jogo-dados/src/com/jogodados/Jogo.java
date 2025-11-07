package com.jogodados;

import java.util.*;

public class Jogo {
    private List<Jogador> jogadores;
    private Dado dado1;
    private Dado dado2;
    private GerenciadorArquivo gerenciadorArquivo;
    private Scanner scanner;

    public Jogo() {
        jogadores = new ArrayList<>();
        dado1 = new Dado();
        dado2 = new Dado();
        gerenciadorArquivo = new GerenciadorArquivo();
        scanner = new Scanner(System.in);
    }

    public void iniciar() {
        mostrarRanking();
        coletarDadosJogadores();
        executarRodada();
    }

    private void mostrarRanking() {
        System.out.println("=== TOP FIVE RANKING ===");
        List<Map.Entry<String, Integer>> topCinco = gerenciadorArquivo.getTopCinco();

        if (topCinco.isEmpty()) {
            System.out.println("Nenhum vencedor ainda!");
        } else {
            for (int i = 0; i < topCinco.size(); i++) {
                Map.Entry<String, Integer> entry = topCinco.get(i);
                System.out.println((i + 1) + ". " + entry.getKey() + " - " + entry.getValue() + " vitórias");
            }
        }

        System.out.println("\nPressione ENTER para continuar...");
        scanner.nextLine();
    }

    private void coletarDadosJogadores() {
        System.out.println("\n=== CADASTRO DE JOGADORES ===");

        while (jogadores.size() < 11) {
            System.out.print("Usuário (ou 'sair' para finalizar): ");
            String usuario = scanner.nextLine().trim();

            if (usuario.equalsIgnoreCase("sair")) break;
            if (usuario.isEmpty()) continue;

            if (jogadores.stream().anyMatch(p -> p.getUsuario().equals(usuario.toLowerCase()))) {
                System.out.println("Usuário já existe! Use outro.");
                continue;
            }

            int aposta = obterApostaValida();
            if (aposta == -1) break;

            jogadores.add(new Jogador(usuario, aposta));
            System.out.println("Jogador " + usuario + " cadastrado com aposta " + aposta);

            if (jogadores.size() >= 11) {
                System.out.println("Máximo de jogadores atingido!");
                break;
            }
        }
    }

    private int obterApostaValida() {
        while (true) {
            System.out.print("Aposta (2-12, ou 0 para sair): ");
            try {
                int aposta = Integer.parseInt(scanner.nextLine());
                if (aposta == 0) return -1;
                if (aposta >= 2 && aposta <= 12) return aposta;
                System.out.println("Aposta deve ser entre 2 e 12!");
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido!");
            }
        }
    }

    private void executarRodada() {
        if (jogadores.isEmpty()) {
            System.out.println("Nenhum jogador cadastrado. Jogo encerrado.");
            return;
        }

        System.out.println("\n=== RODADA DO JOGO ===");
        int valorDado1 = dado1.rolar();
        int valorDado2 = dado2.rolar();
        int soma = valorDado1 + valorDado2;

        System.out.println("Dado 1: " + valorDado1);
        System.out.println("Dado 2: " + valorDado2);
        System.out.println("SOMA SORTEADA: " + soma);

        List<Jogador> vencedores = jogadores.stream()
                .filter(p -> p.getAposta() == soma)
                .toList();

        if (vencedores.isEmpty()) {
            System.out.println("A MÁQUINA VENCEU! Nenhum jogador acertou a soma.");
        } else {
            System.out.println("VENCEDORES:");
            for (Jogador vencedor : vencedores) {
                System.out.println("- " + vencedor.getUsuario());
                gerenciadorArquivo.salvarVencedor(vencedor);
            }
        }
    }
}