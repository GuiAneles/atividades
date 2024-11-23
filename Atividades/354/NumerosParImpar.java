import javax.swing.JOptionPane;

public class NumerosParImpar {
    public static void main(String[] args) {
        int[] num = new int[15];
        String resultado = "Relação Dos Números:\n";
        
        for (int i = 0; i < 15; i++) {
            String s = JOptionPane.showInputDialog("Digite O " + (i + 1) + "º Número:");
            num[i] = Integer.parseInt(s);
        }

        for (int i = 0; i < 15; i++) {
            resultado += (i + 1) + "- " + num[i];
            if (num[i] % 2 == 0) {
                resultado += " É Par\n";
            } else {
                resultado += " É Ímpar\n";
            }
        }

        JOptionPane.showMessageDialog(null, resultado);
    }
}
