import javax.swing.JOptionPane;

public class DadosVetorB {
    public static void dadosVetorB(int[] vetorB) {
        for (int i = 0; i < vetorB.length; i++) {
            String s = JOptionPane.showInputDialog("Digite o valor para a posição " + (i + 1) + " do Vetor B:");
            vetorB[i] = Integer.parseInt(s);
        }
    }
}
