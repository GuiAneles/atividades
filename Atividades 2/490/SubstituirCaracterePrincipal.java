import javax.swing.JOptionPane;

public class SubstituirCaracterePrincipal {
    public static void main(String[] args) {
        SubstituirCaractere substituidor = new SubstituirCaractere();
        int numPalavras = 10;
        StringBuilder resultado = new StringBuilder();

        for (int i = 1; i <= numPalavras; i++) {
            String palavra = JOptionPane.showInputDialog("Digite Palavra Em Letras Minúsculas " + i + ":");
            char caractere = JOptionPane.showInputDialog("Digite O Caractere A Ser Retirado:").charAt(0);

            char[] vetorPalavra = palavra.toCharArray();

            int totalSubstituicoes = substituidor.substituirCaractere(vetorPalavra, caractere);

            resultado.append(i)
                     .append(" - ")
                     .append(new String(vetorPalavra))
                     .append("\n");

            resultado.append("Total De Caracteres Retirados: ").append(totalSubstituicoes).append("\n\n");
        }

        JOptionPane.showMessageDialog(null, resultado.toString());
    }
}
