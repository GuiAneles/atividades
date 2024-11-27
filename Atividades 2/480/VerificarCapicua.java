import javax.swing.JOptionPane;

public class VerificarCapicua {
    public static void main(String[] args) {
        int n, x;

        String input = JOptionPane.showInputDialog("Digite Um Número:");
        n = Integer.parseInt(input);

        Inversao inversao = new Inversao();

        x = inversao.reverso(n);

        JOptionPane.showMessageDialog(null, n + " - " + x);

        if (x == n) {
            JOptionPane.showMessageDialog(null, "É Um Número Capicua");
        } else {
            JOptionPane.showMessageDialog(null, "Não É Um Número Capicua");
        }
    }
}
