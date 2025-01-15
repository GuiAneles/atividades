import java.util.Stack;

public class Calculadora {
    public static double calcularPosfixa(String posfixa) {
        Stack<Double> pilha = new Stack<>();
        for (int i = 0; i < posfixa.length(); i++) {
            char c = posfixa.charAt(i);
            if (Character.isDigit(c)) {
                pilha.push((double) (c - '0'));
            } else {
                double val1 = pilha.pop();
                double val2 = pilha.pop();
                switch (c) {
                    case '+':
                        pilha.push(val2 + val1);
                        break;
                    case '-':
                        pilha.push(val2 - val1);
                        break;
                    case '*':
                        pilha.push(val2 * val1);
                        break;
                    case '/':
                        pilha.push(val2 / val1);
                        break;
                }
            }
        }
        return pilha.pop();
    }
}
