import javax.swing.JOptionPane;

public class DadosVetor {
    public static void dadosVetor(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            String s = JOptionPane.showInputDialog("Digite o valor para a posição " + (i + 1) + " do vetor:");
            vetor[i] = Integer.parseInt(s);
        }
    }
}