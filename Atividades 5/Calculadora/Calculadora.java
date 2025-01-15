import java.util.Stack;

public class Calculadora {
    // Função que calcula o resultado de uma expressão em notação pós-fixa
    public static double calcularPosfixa(String posfixa) {
        Stack<Double> pilha = new Stack<>();  // Pilha para armazenar os operandos

        for (int i = 0; i < posfixa.length(); i++) {
            char c = posfixa.charAt(i);  // Obtém o próximo caractere da expressão

            // Se for um número, empilha
            if (Character.isDigit(c)) {
                pilha.push((double) (c - '0'));  // Converte o caractere para número e empilha
            } else {
                // Se for um operador, desempilha dois operandos e realiza a operação
                double val1 = pilha.pop();
                double val2 = pilha.pop();

                switch (c) {
                    case '+':  // Soma
                        pilha.push(val2 + val1);
                        break;
                    case '-':  // Subtração
                        pilha.push(val2 - val1);
                        break;
                    case '*':  // Multiplicação
                        pilha.push(val2 * val1);
                        break;
                    case '/':  // Divisão
                        pilha.push(val2 / val1);
                        break;
                }
            }
        }
        return pilha.pop();  // Retorna o resultado final da pilha
    }
}
