import javax.swing.JOptionPane;

public class MatrizDiferenca {
    public static void main(String[] args) {
        int[][] matriz1 = new int[5][5]; // Matriz 1 de ordem 5x5
        int[][] matriz2 = new int[5][5]; // Matriz 2 de ordem 5x5
        int[][] matrizDiferenca = new int[5][5]; // Matriz para armazenar a diferença

        // Coleta de dados para as duas matrizes
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                String s = JOptionPane.showInputDialog("Digite o valor da posição (" + (i+1) + ", " + (j+1) + ") da Matriz 1:");
                matriz1[i][j] = Integer.parseInt(s);
                
                s = JOptionPane.showInputDialog("Digite o valor da posição (" + (i+1) + ", " + (j+1) + ") da Matriz 2:");
                matriz2[i][j] = Integer.parseInt(s);
            }
        }

        // Calculando a matriz diferença (matriz1 - matriz2)
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matrizDiferenca[i][j] = matriz1[i][j] - matriz2[i][j];
            }
        }

        // Exibindo a matriz diferença
        String resultado = "Matriz Diferença (Matriz 1 - Matriz 2):\n";
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                resultado += matrizDiferenca[i][j] + "\t"; // Imprime os elementos da matriz diferença
            }
            resultado += "\n";
        }

        JOptionPane.showMessageDialog(null, resultado); // Exibe a matriz diferença
    }
}
