import java.util.Stack;

public class Conversao {
    // Método para converter de notação infixa para pós-fixa
    public static String infixaParaPosfixa(String infixa) {
        StringBuilder posfixa = new StringBuilder();
        Stack<Character> pilha = new Stack<>();
        for (int i = 0; i < infixa.length(); i++) {
            char c = infixa.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                posfixa.append(c); // Adiciona operandos diretamente à saída
            } else if (c == '(') {
                pilha.push(c); // Empilha '('
            } else if (c == ')') {
                while (!pilha.isEmpty() && pilha.peek() != '(') {
                    posfixa.append(pilha.pop()); // Desempilha até '('
                }
                pilha.pop(); // Remove '(' da pilha
            } else {
                while (!pilha.isEmpty() && precedencia(c) <= precedencia(pilha.peek())) {
                    posfixa.append(pilha.pop()); // Desempilha operadores de maior ou igual precedência
                }
                pilha.push(c); // Empilha o operador atual
            }
        }
        while (!pilha.isEmpty()) {
            posfixa.append(pilha.pop()); // Desempilha operadores restantes
        }
        return posfixa.toString(); // Retorna a expressão pós-fixa
    }

    // Método para definir a precedência dos operadores
    public static int precedencia(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    // Método para converter de notação infixa para pré-fixa
    public static String infixaParaPrefixa(String infixa) {
        StringBuilder prefixa = new StringBuilder();
        StringBuilder infixaReversa = new StringBuilder(infixa).reverse();
        Stack<Character> pilha = new Stack<>();

        for (int i = 0; i < infixaReversa.length(); i++) {
            char c = infixaReversa.charAt(i);
            if (c == '(') {
                c = ')';
            } else if (c == ')') {
                c = '(';
            }
            infixaReversa.setCharAt(i, c);
        }

        String posfixaReversa = infixaParaPosfixa(infixaReversa.toString());
        prefixa.append(new StringBuilder(posfixaReversa).reverse());

        return prefixa.toString(); // Retorna a expressão pré-fixa
    }

    // Método para converter de notação pós-fixa para infixa
    public static String posfixaParaInfixa(String posfixa) {
        Stack<String> pilha = new Stack<>();
        for (int i = 0; i < posfixa.length(); i++) {
            char c = posfixa.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                pilha.push(c + ""); // Empilha operandos
            } else {
                String op1 = pilha.pop();
                String op2 = pilha.pop();
                pilha.push("(" + op2 + c + op1 + ")"); // Combina operandos e operadores
            }
        }
        return pilha.pop(); // Retorna a expressão infixa
    }

    // Método para converter de notação pré-fixa para infixa
    public static String prefixaParaInfixa(String prefixa) {
        Stack<String> pilha = new Stack<>();
        for (int i = prefixa.length() - 1; i >= 0; i--) {
            char c = prefixa.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                pilha.push(c + ""); // Empilha operandos
            } else {
                String op1 = pilha.pop();
                String op2 = pilha.pop();
                pilha.push("(" + op1 + c + op2 + ")"); // Combina operandos e operadores
            }
        }
        return pilha.pop(); // Retorna a expressão infixa
    }
}
