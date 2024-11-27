import javax.swing.JOptionPane;

public class MenuVetores {

    public static void main(String[] args) {
        int[] vetorA = new int[5];
        int[] vetorB = new int[5];
        int[] resultado = new int[5];
        int opcao;

        do {
            String menu = "VETORES\n" +
                          "1. Dados do VETOR A\n" +
                          "2. Dados do VETOR B\n" +
                          "3. Imprime VETORES\n" +
                          "4. Soma VETORES\n" +
                          "5. Subtrai VETORES\n" +
                          "6. Sai do programa";
            String opcaoStr = JOptionPane.showInputDialog(menu + "\n\nOpção:");
            opcao = Integer.parseInt(opcaoStr);

            switch (opcao) {
                case 1:
                    DadosVetorA.dadosVetorA(vetorA);
                    break;
                case 2:
                    DadosVetorB.dadosVetorB(vetorB);
                    break;
                case 3:
                    ImprimirVetores.imprimirVetores(vetorA, vetorB);
                    break;
                case 4:
                    SomaVetores.somaVetores(vetorA, vetorB, resultado);
                    StringBuilder somaResultado = new StringBuilder("Soma dos Vetores: ");
                    for (int i = 0; i < resultado.length; i++) {
                        somaResultado.append(resultado[i]).append(" ");
                    }
                    JOptionPane.showMessageDialog(null, somaResultado.toString());
                    break;
                case 5:
                    SubtraiVetores.subtraiVetores(vetorA, vetorB, resultado);
                    StringBuilder subtracaoResultado = new StringBuilder("Subtração dos Vetores: ");
                    for (int i = 0; i < resultado.length; i++) {
                        subtracaoResultado.append(resultado[i]).append(" ");
                    }
                    JOptionPane.showMessageDialog(null, subtracaoResultado.toString());
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Saindo do programa...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida! Tente novamente.");
            }
        } while (opcao != 6);
    }
}