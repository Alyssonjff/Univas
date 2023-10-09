package main;

import models.*;
import mundoVirtual.MundoVirtual;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("RPG - The game!");
        System.out.print("Digite o nome do seu char: ");
        String nomePersonagem = scanner.nextLine();

        Personagem jogador1 = new Personagem(nomePersonagem, 1, 100, 90);
        Habilidade habilidade1 = new Habilidade("Magia de gelo", "Lança uma espada de gelo", 15);
        Item item1 = new Item("Poção de Cura", "Cura 50 pontos de saúde", "Cura", "Cura 50 pontos de saúde");

        MundoVirtual mundo = new MundoVirtual();
        mundo.adicionarPersonagem(jogador1);

        Missao missao1 = new Missao("Coletar armamentos perdidos", "Encontre os armamentos perdidos!",
                List.of(new Item("armamento perdido", "um armamento misterioso", "Armamento", "Armamento misterioso")),
                "Coletar os armamentos perdidos");
        Missao missao2 = new Missao("Derrotar o Dragão", "Enfrente o Dragão!",
                List.of(new Item("Espada Épica", "Uma espada poderosa", "Arma", "Dano +30")),
                "Matar o dragão");
        Missao missao3 = new Missao("Derrotar o Rei Demônio", "Enfrente o Rei Demônio e domine o Reino Demoniaco!",
                List.of(new Item("Espada do Rei Demônio", "Uma espada inbuída em Fogo", "Arma", "Dano +150")),
                "Matar o Rei Demônio e dominar o reino");


        mundo.adicionarMissao(missao1);
        mundo.adicionarMissao(missao2);
        mundo.adicionarMissao(missao3);

        Inimigo inimigo1 = new Inimigo("Elfo", 3, 80, 75, new ArrayList<>());
        Inimigo inimigo2 = new Inimigo("Dragão", 20, 300, 150, new ArrayList<>());
        Inimigo inimigo3 = new Inimigo("Goblin", 1, 40, 20, new ArrayList<>());
        Inimigo inimigo4 = new Inimigo("Lobo", 3, 90, 50, new ArrayList<>());
        Inimigo inimigo5 = new Inimigo("Rei Demônio", 25, 500, 250, new ArrayList<>());

        mundo.adicionarInimigo(inimigo1);
        mundo.adicionarInimigo(inimigo1);
        mundo.adicionarInimigo(inimigo2);
        mundo.adicionarInimigo(inimigo3);
        mundo.adicionarInimigo(inimigo3);
        mundo.adicionarInimigo(inimigo3);
        mundo.adicionarInimigo(inimigo3);
        mundo.adicionarInimigo(inimigo3);
        mundo.adicionarInimigo(inimigo4);
        mundo.adicionarInimigo(inimigo4);
        mundo.adicionarInimigo(inimigo4);
        mundo.adicionarInimigo(inimigo4);
        mundo.adicionarInimigo(inimigo5);

        System.out.println("Você está pronto para começar sua jornada!");
        jogador1.pegarHabilidade(habilidade1);

        while (true) {
            int escolha;
            if (jogador1.getSaude() > 0) {
                System.out.println("\n Opções:");
                System.out.println("1. Ver status do personagem");
                System.out.println("2. Ver missões disponíveis");
                System.out.println("3. Iniciar missão");
                System.out.println("4. Caminhar pelo mapa");
                System.out.println("5. Usar item");
                System.out.println("6. Sair do jogo");
                System.out.print("Escolha uma opção: ");

                escolha = scanner.nextInt();
            } else {
                escolha = 4;
            }

            switch (escolha) {
                case 1 -> {
                    System.out.println(jogador1.getNome() + " - Nível: " + jogador1.getNivel() + " Saúde: "
                            + jogador1.getSaude() + " Energia: " + jogador1.getEnergia());
                    System.out.println("Itens: " + jogador1.getItens());
                    System.out.println("Habilidades: " + jogador1.getHabilidades());
                }
                case 2 -> {
                    System.out.println("Missões disponíveis:");
                    if (mundo.getMissoes().size() > 0) {
                        for (int i = 0; i < mundo.getMissoes().size(); i++) {
                            Missao missao = mundo.getMissoes().get(i);
                            System.out.println(i + 1 + ". " + missao.getTitulo() + ": " + missao.getDescricao());
                        }
                    } else {
                        System.out.println("Não há missões disponíveis");
                    }
                }
                case 3 -> {
                    System.out.println("Missões disponíveis:");
                    if (mundo.getMissoes().size() > 0) {
                        for (int i = 0; i < mundo.getMissoes().size(); i++) {
                            Missao missao = mundo.getMissoes().get(i);
                            System.out.println(i + 1 + ". " + missao.getTitulo() + ": " + missao.getDescricao());
                        }
                        System.out.print("Escolha uma missão para iniciar (Digite o número): ");
                        int escolhaMissao = scanner.nextInt();
                        if (escolhaMissao >= 1 && escolhaMissao <= mundo.getMissoes().size()) {
                            Missao missaoSelecionada = mundo.getMissoes().get(escolhaMissao - 1);
                            jogador1.setMissaoAtiva(missaoSelecionada);
                            jogador1.getMissaoAtiva().iniciar(jogador1);
                        } else {
                            System.out.println("Opção de missão inválida.");
                        }
                    } else {
                        System.out.println("Não há missões disponíveis");
                    }
                }
                case 4 -> {
                    System.out.println("Digite a posição X: ");
                    double posX = scanner.nextDouble();
                    System.out.println("Digite a posição Y: ");
                    double posY = scanner.nextDouble();
                    jogador1.caminhar(posX, posY);
                    double probabilidadeEncontro = 0.3;
                    if (Math.random() < probabilidadeEncontro && mundo.getInimigos().size() > 0) {
                        List<Inimigo> inimigosDisponiveis = mundo.getInimigos();
                        int indiceInimigoEscolhido = (int) (Math.random() * inimigosDisponiveis.size());
                        Inimigo inimigoEscolhido = inimigosDisponiveis.get(indiceInimigoEscolhido);
                        mundo.iniciarCombate(inimigoEscolhido, jogador1);
                        if (jogador1.getMissaoAtiva() != null) {
                            if (inimigoEscolhido.getNome().equals("Dragão") && jogador1.getMissaoAtiva().equals(missao2)) {
                                jogador1.getMissaoAtiva().atualizar(jogador1);
                                jogador1.getMissaoAtiva().completar(jogador1);
                                mundo.removerMissao(jogador1.getMissaoAtiva());
                            } else if (inimigoEscolhido.getNome().equals("Rei Demônio") && jogador1.getMissaoAtiva().equals(missao3)) {
                                jogador1.getMissaoAtiva().atualizar(jogador1);
                                jogador1.getMissaoAtiva().completar(jogador1);
                                mundo.removerMissao(jogador1.getMissaoAtiva());
                            }
                        }
                    } else {
                        if (Math.random() < 0.4 && (jogador1.getMissaoAtiva() == null || !jogador1.getMissaoAtiva().equals(missao1))) {
                            System.out.println("Você encontrou uma poção de cura!");
                            jogador1.pegarItem(item1);
                        } else if (Math.random() < 0.4 && (jogador1.getMissaoAtiva() != null && jogador1.getMissaoAtiva().equals(missao1))) {
                            System.out.println("Você encontrou os armamentos perdidos!");
                            jogador1.getMissaoAtiva().atualizar(jogador1);
                            jogador1.getMissaoAtiva().completar(jogador1);
                            mundo.removerMissao(jogador1.getMissaoAtiva());
                        } else {
                            System.out.println("Você não encontrou nada!");
                        }
                    }
                }
                case 5 -> {
                    if (jogador1.getItens().size() >= 1) {
                        System.out.println("Itens disponíveis:");
                        List<Item> itensDisponiveis = jogador1.getItens();
                        for (int i = 0; i < itensDisponiveis.size(); i++) {
                            Item item = itensDisponiveis.get(i);
                            System.out.println(i + 1 + ". " + item.getNome());
                        }
                        System.out.print("Escolha um item para usar (Digite o número): ");
                        int escolhaItem = scanner.nextInt();
                        if (escolhaItem >= 1 && escolhaItem <= itensDisponiveis.size()) {
                            Item itemSelecionado = itensDisponiveis.get(escolhaItem - 1);
                            jogador1.usarItem(itemSelecionado);
                        } else {
                            System.out.println("Opção de item inválida.");
                        }
                    } else {
                        System.out.println("Não há itens disponíveis");
                    }
                }
                case 6 -> {
                    System.out.println("Obrigado por jogar!");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Opção inválida. Escolha novamente.");
            }
        }
    }
}