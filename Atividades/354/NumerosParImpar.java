import javax.swing.JOptionPane;

public class NumerosParImpar {
    public static void main(String[] args) {
        int[] num = new int[15]; // Vetor para armazenar 15 números inteiros
        String resultado = "Relação Dos Números:\n";

        // Trecho de entrada
        for (int i = 0; i < 15; i++) {
            String s = JOptionPane.showInputDialog("Digite O " + (i + 1) + "º Número:");
            num[i] = Integer.parseInt(s);
        }

        // Trecho de saída
        for (int i = 0; i < 15; i++) {
            resultado += (i + 1) + "- " + num[i];
            if (num[i] % 2 == 0) {
                resultado += " É Par\n";
            } else {
                resultado += " É Ímpar\n";
            }
        }

        // Exibir a listagem completa
        JOptionPane.showMessageDialog(null, resultado);
    }
}