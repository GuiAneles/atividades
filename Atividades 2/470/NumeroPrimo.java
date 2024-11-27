import javax.swing.JOptionPane;

public class NumeroPrimo {
    public static void main(String[] args) {
        CalcPrimos calc = new CalcPrimos(); 

        String s = JOptionPane.showInputDialog("Digite Um Número Para Verificar Se É Primo:");
        int numero = Integer.parseInt(s);

        int resultado = calc.primo(numero);

        if (resultado == 0) {
            JOptionPane.showMessageDialog(null, "O Número " + numero + " É Primo.");
        } else {
            JOptionPane.showMessageDialog(null, "O Número " + numero + " Não É Primo.");
        }
    }
}