import javax.swing.JOptionPane;

public class Matriz {
    public static void main(String[] args) {
        int[][] n = new int[5][5]; // Matriz 5x5
        int soma = 0;

        // Preenchendo a matriz com valores inteiros
        for (int l = 0; l < 5; l++) {
            for (int c = 0; c < 5; c++) {
                String s = JOptionPane.showInputDialog("Digite O Elemento Da Posição [" + (l + 1) + "][" + (c + 1) + "]:");
                n[l][c] = Integer.parseInt(s); // Armazena o número na matriz
            }
        }

        // Exibindo toda a matriz
        String resultado = "\nToda A Matriz:\n";
        for (int l = 0; l < 5; l++) {
            for (int c = 0; c < 5; c++) {
                resultado += n[l][c] + "\t"; // Exibe o valor da matriz
            }
            resultado += "\n";
        }

        // Calculando a soma dos quadrados dos números ímpares abaixo da diagonal secundária
        for (int l = 1; l < 5; l++) { // Começa da linha 1 para ficar abaixo da diagonal secundária
            for (int c = 0; c < 5 - l; c++) { // Colunas limitadas para ficarem abaixo da diagonal secundária
                if (n[l][c] % 2 == 1) { // Verifica se o número é ímpar
                    soma += n[l][c] * n[l][c]; // Soma o quadrado do número ímpar
                }
            }
        }

        // Calculando a raiz quadrada da soma
        double raizQuadrada = Math.sqrt(soma);

        // Exibindo o resultado final
        resultado += "\nRaiz Quadrada Da Soma Dos Quadrados Dos Números Ímpares: " + raizQuadrada + "\n";

        JOptionPane.showMessageDialog(null, resultado); // Exibe toda a matriz e o resultado
    }
}