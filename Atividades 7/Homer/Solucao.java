import java.util.LinkedList;
import java.util.Scanner;

public class Solucao {
    public static void main(String[] args) {
        LinkedList<String> lista = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        String comando, nome;
        int posicao;

        while (true) {
            System.out.println("\nEscolha uma ação: adicionar, remover, esvaziar, imprimir, tamanho, verificar, sair");
            comando = scanner.nextLine().toLowerCase();

            switch (comando) {
                case "adicionar":
                    System.out.println("Digite o nome a ser adicionado:");
                    nome = scanner.nextLine();
                    System.out.println("Digite a posição (ou 'inicio' ou 'fim'):");
                    String pos = scanner.nextLine().toLowerCase();
                    if (pos.equals("inicio")) {
                        lista.addFirst(nome);
                    } else if (pos.equals("fim")) {
                        lista.addLast(nome);
                    } else {
                        try {
                            posicao = Integer.parseInt(pos);
                            lista.add(posicao, nome);
                        } catch (NumberFormatException e) {
                            System.out.println("Posição inválida!");
                        }
                    }
                    break;

                case "remover":
                    System.out.println("Digite a posição a ser removida (ou 'inicio' ou 'fim'):");
                    pos = scanner.nextLine().toLowerCase();
                    if (pos.equals("inicio")) {
                        lista.removeFirst();
                    } else if (pos.equals("fim")) {
                        lista.removeLast();
                    } else {
                        try {
                            posicao = Integer.parseInt(pos);
                            lista.remove(posicao);
                        } catch (NumberFormatException e) {
                            System.out.println("Posição inválida!");
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Posição fora dos limites da lista!");
                        }
                    }
                    break;

                case "esvaziar":
                    lista.clear();
                    System.out.println("Lista esvaziada.");
                    break;

                case "imprimir":
                    System.out.println("Lista: " + lista);
                    break;

                case "tamanho":
                    System.out.println("Tamanho da lista: " + lista.size());
                    break;

                case "verificar":
                    System.out.println("Digite o nome a ser verificado:");
                    nome = scanner.nextLine();
                    if (lista.contains(nome)) {
                        System.out.println(nome + " está na lista.");
                    } else {
                        System.out.println(nome + " não está na lista.");
                    }
                    break;

                case "sair":
                    System.out.println("Encerrando o programa.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Comando desconhecido.");
                    break;
            }
        }
    }
}