import javax.swing.JOptionPane;

public class DadosVetorA {
    public static void dadosVetorA(int[] vetorA) {
        for (int i = 0; i < vetorA.length; i++) {
            String s = JOptionPane.showInputDialog("Digite O Valor Para A Posição " + (i + 1) + " Do Vetor A:");
            vetorA[i] = Integer.parseInt(s);
        }
    }
}