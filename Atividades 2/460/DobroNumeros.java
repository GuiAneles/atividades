import javax.swing.JOptionPane;

public class DobroNumeros {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora(); 

        for (int i = 1; i <= 3; i++) {
            String s = JOptionPane.showInputDialog("Digite O " + i + "º Número:");
            int numero = Integer.parseInt(s);

            int dobro = calculadora.calcularDobro(numero);

            System.out.println("Numero: " + numero);
            System.out.println("Dobro: " + dobro);
        }
    }
}
