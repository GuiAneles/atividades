import javax.swing.JOptionPane;

public class ImprimirVetores {
    public static void imprimirVetores(int[] vetorA, int[] vetorB) {
        StringBuilder resultado = new StringBuilder("Vetor A: ");
        for (int i = 0; i < vetorA.length; i++) {
            resultado.append(vetorA[i]).append(" ");
        }
        resultado.append("\nVetor B: ");
        for (int i = 0; i < vetorB.length; i++) {
            resultado.append(vetorB[i]).append(" ");
        }
        JOptionPane.showMessageDialog(null, resultado.toString());
    }
}
