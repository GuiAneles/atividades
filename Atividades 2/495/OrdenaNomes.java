import javax.swing.JOptionPane;

public class OrdenaNomes {
    public static void main(String[] args) {
        Ordenador ordenador = new Ordenador();

        int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Quantos Nomes Você Quer Ordenar?"));

        String[] nomes = new String[quantidade];

        for (int i = 0; i < quantidade; i++) {
            nomes[i] = JOptionPane.showInputDialog("Digite O " + (i + 1) + "º Nome:");
        }

        String[] nomesOrdenados = ordenador.ordenarNomes(nomes);

        String resultado = "Nomes Ordenados:\n";
        for (String nome : nomesOrdenados) {
            resultado += nome + "\n";
        }
        JOptionPane.showMessageDialog(null, resultado);
    }
}
