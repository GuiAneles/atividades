import javax.swing.JOptionPane;

public class LucroMercadorias {
    public static void main(String[] args) {
        Mercadoria[] mercadorias = new Mercadoria[100];
        int lucroMenor10 = 0, lucroEntre10e20 = 0, lucroMaior20 = 0; // Contadores

        for (int i = 0; i < 100; i++) {
            mercadorias[i] = new Mercadoria();

            String s = JOptionPane.showInputDialog("Digite o preço de compra da mercadoria " + (i + 1) + ":");
            mercadorias[i].precoCompra = Double.parseDouble(s);

            s = JOptionPane.showInputDialog("Digite o preço de venda da mercadoria " + (i + 1) + ":");
            mercadorias[i].precoVenda = Double.parseDouble(s);

            mercadorias[i].lucroPercentual = ((mercadorias[i].precoVenda - mercadorias[i].precoCompra) / mercadorias[i].precoCompra) * 100;

            if (mercadorias[i].lucroPercentual < 10) {
                lucroMenor10++;
            } else if (mercadorias[i].lucroPercentual <= 20) {
                lucroEntre10e20++;
            } else {
                lucroMaior20++;
            }
        }

        String resultado = "Resumo das Mercadorias:\n" +
                           "Lucro < 10%: " + lucroMenor10 + " mercadorias\n" +
                           "10% <= Lucro <= 20%: " + lucroEntre10e20 + " mercadorias\n" +
                           "Lucro > 20%: " + lucroMaior20 + " mercadorias\n";

        JOptionPane.showMessageDialog(null, resultado);
    }
}
