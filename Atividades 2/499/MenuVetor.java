import javax.swing.JOptionPane;

public class MenuVetor {

    public static void main(String[] args) {
        int[] vetor = new int[5];
        int opcao;

        do {
            String menu = "MENU VETOR - FUNCAO\n" +
                          "1. Dados do VETOR\n" +
                          "2. Ordena VETOR\n" +
                          "3. Imprime VETOR\n" +
                          "4. Sair Do Programa";
            String opcaoStr = JOptionPane.showInputDialog(menu + "\n\nOpção:");
            opcao = Integer.parseInt(opcaoStr);

            switch (opcao) {
                case 1:
                    DadosVetor.dadosVetor(vetor);
                    break;
                case 2:
                    OrdenarVetor.ordenarVetor(vetor);
                    break;
                case 3:
                    ImprimirVetor.imprimirVetor(vetor);
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Saindo Do Programa...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida! Tente Novamente.");
            }
        } while (opcao != 4);
    }
}
