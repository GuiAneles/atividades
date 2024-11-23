import javax.swing.JOptionPane;

public class Matriz {
    public static void main(String[] args) {
        int[][] n = new int[5][5];
        int soma = 0;

        for (int l = 0; l < 5; l++) {
            for (int c = 0; c < 5; c++) {
                String s = JOptionPane.showInputDialog("Digite O Elemento Da Posição [" + (l + 1) + "][" + (c + 1) + "]:");
                n[l][c] = Integer.parseInt(s);
            }
        }

        String resultado = "\nToda A Matriz:\n";
        for (int l = 0; l < 5; l++) {
            for (int c = 0; c < 5; c++) {
                resultado += n[l][c] + "\t";
            }
            resultado += "\n";
        }

        for (int l = 1; l < 5; l++) {
            for (int c = 0; c < 5 - l; c++) {
                if (n[l][c] % 2 == 1) {
                    soma += n[l][c] * n[l][c];
                }
            }
        }

        double raizQuadrada = Math.sqrt(soma);

        resultado += "\nRaiz Quadrada Da Soma Dos Quadrados Dos Números Ímpares: " + raizQuadrada + "\n";

        JOptionPane.showMessageDialog(null, resultado);
    }
}
