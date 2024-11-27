import javax.swing.JOptionPane;

public class ImprimirVetor {
    public static void imprimirVetor(int[] vetor) {
        StringBuilder resultado = new StringBuilder("Vetor: ");
        for (int i = 0; i < vetor.length; i++) {
            resultado.append(vetor[i]).append(" ");
        }
        JOptionPane.showMessageDialog(null, resultado.toString());
    }
}