import java.util.Stack;

public class Conversao {
    public static String infixaParaPosfixa(String infixa) {
        StringBuilder posfixa = new StringBuilder();
        Stack<Character> pilha = new Stack<>();
        for (int i = 0; i < infixa.length(); i++) {
            char c = infixa.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                posfixa.append(c);
            } else if (c == '(') {
                pilha.push(c);
            } else if (c == ')') {
                while (!pilha.isEmpty() && pilha.peek() != '(') {
                    posfixa.append(pilha.pop());
                }
                pilha.pop();
            } else {
                while (!pilha.isEmpty() && precedencia(c) <= precedencia(pilha.peek())) {
                    posfixa.append(pilha.pop());
                }
                pilha.push(c);
            }
        }
        while (!pilha.isEmpty()) {
            posfixa.append(pilha.pop());
        }
        return posfixa.toString();
    }

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

        return prefixa.toString();
    }

    public static String posfixaParaInfixa(String posfixa) {
        Stack<String> pilha = new Stack<>();
        for (int i = 0; i < posfixa.length(); i++) {
            char c = posfixa.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                pilha.push(c + "");
            } else {
                String op1 = pilha.pop();
                String op2 = pilha.pop();
                pilha.push("(" + op2 + c + op1 + ")");
            }
        }
        return pilha.pop();
    }

    public static String prefixaParaInfixa(String prefixa) {
        Stack<String> pilha = new Stack<>();
        for (int i = prefixa.length() - 1; i >= 0; i--) {
            char c = prefixa.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                pilha.push(c + "");
            } else {
                String op1 = pilha.pop();
                String op2 = pilha.pop();
                pilha.push("(" + op1 + c + op2 + ")");
            }
        }
        return pilha.pop();
    }
}
