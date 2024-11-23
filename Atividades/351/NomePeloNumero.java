import javax.swing.JOptionPane;

public class NomePeloNumero {
    public static void main(String[] args) {
        String[] nomes = new String[5];
        int num;

        for (int i = 0; i < 5; i++) {
            nomes[i] = JOptionPane.showInputDialog("Digite O Nome Da Pessoa " + (i + 1) + ":");
        }

        do {
            String s = JOptionPane.showInputDialog("Digite O Número Da Pessoa (1 a 5):");
            num = Integer.parseInt(s);

            if (num < 1 || num > 5) {
                JOptionPane.showMessageDialog(null, "Número Fora Do Intervalo! Digite Novamente.");
            }
        } while (num < 1 || num > 5);

        JOptionPane.showMessageDialog(null, "O Nome Correspondente Ao Número " + num + " É: " + nomes[num - 1]);
    }
}
