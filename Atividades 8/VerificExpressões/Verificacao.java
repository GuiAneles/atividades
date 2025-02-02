import java.util.Stack;

public class Verificacao {

    public static boolean verificarParametrizacao(String expressao) {
        Stack<Character> pilha = new Stack<>();

        for (int i = 0; i < expressao.length(); i++) {
            char caractere = expressao.charAt(i);

            if (caractere == ' ' || caractere == '\t' || caractere == '\n') {
                continue;
            }

            if (caractere == '(' || caractere == '[' || caractere == '{') {
                pilha.push(caractere);
            }

            else if (caractere == ')' || caractere == ']' || caractere == '}') {

                if (pilha.isEmpty()) {
                    System.out.println("Erro: Fechamento De Parenteses, Colchete Ou Chave Sem Correspondencia.");
                    return false;
                }

                char topo = pilha.pop();
                if (!corresponde(topo, caractere)) {
                    System.out.println("Erro: O Caractere '" + topo + "' Nao Corresponde Com '" + caractere + "'.");
                    return false;
                }
            }
        }

        if (!pilha.isEmpty()) {
            System.out.println("Erro: Existem Parenteses, Colchetes Ou Chaves De Abertura Sem Fechamento.");
            return false;
        }

        return true;
    }

    private static boolean corresponde(char abertura, char fechamento) {
        return (abertura == '(' && fechamento == ')') ||
               (abertura == '[' && fechamento == ']') ||
               (abertura == '{' && fechamento == '}');
    }
}
