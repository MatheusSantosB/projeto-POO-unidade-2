package com.jogodados;

import java.io.*;
import java.util.*;

public class GerenciadorArquivo {
    private static final String ARQUIVO_RANKING = "data/ranking.txt";

    public void salvarVencedor(Jogador jogador) {
        try {
            File diretorioData = new File("data");
            if (!diretorioData.exists()) diretorioData.mkdirs();

            Map<String, Integer> ranking = carregarRanking();
            ranking.put(jogador.getUsuario(), ranking.getOrDefault(jogador.getUsuario(), 0) + 1);

            try (PrintWriter writer = new PrintWriter(new FileWriter(ARQUIVO_RANKING))) {
                for (Map.Entry<String, Integer> entry : ranking.entrySet()) {
                    writer.println(entry.getKey() + ":" + entry.getValue());
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar ranking: " + e.getMessage());
        }
    }

    public Map<String, Integer> carregarRanking() {
        Map<String, Integer> ranking = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_RANKING))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(":");
                if (partes.length == 2) {
                    ranking.put(partes[0], Integer.parseInt(partes[1]));
                }
            }
        } catch (IOException e) {
        }
        return ranking;
    }

    public List<Map.Entry<String, Integer>> getTopCinco() {
        Map<String, Integer> ranking = carregarRanking();
        return ranking.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .limit(5)
                .toList();
    }
}