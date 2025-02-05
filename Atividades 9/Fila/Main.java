import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        FilaDinamica fila = new FilaDinamica();
        boolean continuar = true;

        while (continuar) {
            String opcao = JOptionPane.showInputDialog(
                "Escolha Uma Opção:\n" +
                "1 - Enfileirar\n" +
                "2 - Desenfileirar\n" +
                "3 - Exibir Fila\n" +
                "4 - Sair"
            );

            if (opcao == null) continue;

            switch (opcao) {
                case "1":
                    String valorStr = JOptionPane.showInputDialog("Digite Um Número Para Enfileirar:");
                    if (valorStr != null) {
                        try {
                            int valor = Integer.parseInt(valorStr);
                            fila.enfileirar(valor);
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Entrada Inválida! Digite Um Número Inteiro.");
                        }
                    }
                    break;

                case "2":
                    fila.desenfileirar();
                    break;

                case "3":
                    fila.exibir();
                    break;

                case "4":
                    continuar = false;
                    JOptionPane.showMessageDialog(null, "Programa Encerrado.");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida! Escolha Entre 1 E 4.");
            }
        }
    }
}
