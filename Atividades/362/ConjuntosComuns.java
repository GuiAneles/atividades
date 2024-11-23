import javax.swing.JOptionPane;

public class ConjuntosComuns {
    public static void main(String[] args) {
        Conjunto conjunto1 = new Conjunto(10);
        Conjunto conjunto2 = new Conjunto(20);
        
        for (int i = 0; i < conjunto1.tamanho; i++) {
            String s = JOptionPane.showInputDialog("Digite o " + (i + 1) + "º número do primeiro conjunto:");
            conjunto1.elementos[i] = Integer.parseInt(s);
        }

        for (int i = 0; i < conjunto2.tamanho; i++) {
            String s = JOptionPane.showInputDialog("Digite o " + (i + 1) + "º número do segundo conjunto:");
            conjunto2.elementos[i] = Integer.parseInt(s);
        }

        String resultado = "Elementos comuns aos conjuntos:\n";
        boolean encontrado;

        for (int i = 0; i < conjunto1.tamanho; i++) {
            encontrado = false;
            for (int j = 0; j < conjunto2.tamanho; j++) {
                if (conjunto1.elementos[i] == conjunto2.elementos[j]) {
                    if (!resultado.contains(String.valueOf(conjunto1.elementos[i]))) {
                        resultado += conjunto1.elementos[i] + "\n";
                    }
                    encontrado = true;
                    break;
                }
            }
        }

        if (resultado.equals("Elementos comuns aos conjuntos:\n")) {
            resultado = "Não há elementos comuns entre os conjuntos.";
        }

        JOptionPane.showMessageDialog(null, resultado);
    }
}
