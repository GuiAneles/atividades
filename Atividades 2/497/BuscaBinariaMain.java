import java.util.Arrays;
import javax.swing.JOptionPane;

public class BuscaBinariaMain {
    public static void main(String[] args) {
        BuscaBinaria busca = new BuscaBinaria();

        String s = JOptionPane.showInputDialog("Digite O Tamanho Do Vetor:");
        int tamanho = Integer.parseInt(s);

        int[] vetor = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            s = JOptionPane.showInputDialog("Digite O " + (i + 1) + "º Número:");
            vetor[i] = Integer.parseInt(s);
        }

        Arrays.sort(vetor);

        System.out.println("Vetor Ordenado: " + Arrays.toString(vetor));

        s = JOptionPane.showInputDialog("Digite O Número Que Deseja Buscar No Vetor:");
        int chave = Integer.parseInt(s);

        int posicao = busca.buscar(vetor, tamanho, chave);

        if (posicao != -1) {
            System.out.println("Numero " + chave + " Encontrado Na Posicao " + posicao + " Do Vetor.");
        } else {
            System.out.println("Numero " + chave + " Nao Encontrado No Vetor.");
        }
    }
}