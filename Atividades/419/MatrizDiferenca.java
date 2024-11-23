import javax.swing.JOptionPane;

public class MatrizDiferenca {
    public static void main(String[] args) {
        int[][] matriz1 = new int[5][5];
        int[][] matriz2 = new int[5][5];
        int[][] matrizDiferenca = new int[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                String s = JOptionPane.showInputDialog("Digite o valor da posição (" + (i+1) + ", " + (j+1) + ") da Matriz 1:");
                matriz1[i][j] = Integer.parseInt(s);
                
                s = JOptionPane.showInputDialog("Digite o valor da posição (" + (i+1) + ", " + (j+1) + ") da Matriz 2:");
                matriz2[i][j] = Integer.parseInt(s);
            }
        }
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matrizDiferenca[i][j] = matriz1[i][j] - matriz2[i][j];
            }
        }

        String resultado = "Matriz Diferença (Matriz 1 - Matriz 2):\n";
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                resultado += matrizDiferenca[i][j] + "\t";
            }
            resultado += "\n";
        }

        JOptionPane.showMessageDialog(null, resultado);
    }
}
