import javax.swing.JOptionPane;

public class FraseReversa {

    public static void main(String[] args) {
        String frase = JOptionPane.showInputDialog(null, "Digite Uma Frase Para Reverter:", "Reverter Palavras", JOptionPane.QUESTION_MESSAGE);

        if (frase != null && !frase.trim().isEmpty()) {
            String fraseReversa = Reversor.reverterPalavras(frase);

            JOptionPane.showMessageDialog(null, "Frase Original: " + frase + "\n Frase Revertida: " + fraseReversa, "Resultado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma Frase Válida Foi Fornecida.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}