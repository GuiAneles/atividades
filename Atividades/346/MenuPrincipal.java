import javax.swing.JOptionPane;

public class MenuPrincipal {
    public static void main(String[] args) {
        Menu menuop = new Menu();
        String frase = JOptionPane.showInputDialog("Digite uma frase:");

        do {
            menuop.opcao = Byte.parseByte(JOptionPane.showInputDialog(
                "MENU\n" +
                "1 - Imprime O Comprimento da Frase\n" +
                "2 - Imprime Os Dois Primeiros E Os Dois Ultimos Caracteres Da Frase\n" +
                "3 - Imprime A Frase Espelhada\n" +
                "4 - Termina O Algoritmo\n" +
                "OPÇÃO:"
            ));

            switch (menuop.opcao) {
                case 1:
                    JOptionPane.showMessageDialog(null, "O comprimento da frase é: " + frase.length());
                    break;
                case 2:
                    if (frase.length() >= 2) {
                        String doisPrimeiros = frase.substring(0, 2);
                        String doisUltimos = frase.substring(frase.length() - 2);
                        JOptionPane.showMessageDialog(null, "Dois primeiros caracteres: " + doisPrimeiros +
                                "\nDois últimos caracteres: " + doisUltimos);
                    } else {
                        JOptionPane.showMessageDialog(null, "A frase é muito curta para exibir os dois primeiros e dois últimos caracteres.");
                    }
                    break;
                case 3:
                    String fraseEspelhada = new StringBuilder(frase).reverse().toString();
                    JOptionPane.showMessageDialog(null, "A frase espelhada é: " + fraseEspelhada);
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Encerrando o programa. Até logo!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida! Tente novamente.");
            }
        } while (menuop.opcao != 4);
    }
}
