import java.util.Stack;

public class Verificacao {

    // Função para verificar a parametrização da expressão
    public static boolean verificarParametrizacao(String expressao) {
        Stack<Character> pilha = new Stack<>();

        // Percorre cada caractere da expressão
        for (int i = 0; i < expressao.length(); i++) {
            char caractere = expressao.charAt(i);

            // Se for um caractere de abertura, empilha
            if (caractere == '(' || caractere == '[' || caractere == '{') {
                pilha.push(caractere);
            }
            // Se for um caractere de fechamento, verifica correspondência
            else if (caractere == ')' || caractere == ']' || caractere == '}') {
                // Se a pilha estiver vazia, não há correspondência
                if (pilha.isEmpty()) {
                    return false;
                }

                // Remove o topo da pilha e verifica se corresponde ao caractere de fechamento
                char topo = pilha.pop();
                if (!corresponde(topo, caractere)) {
                    return false;
                }
            }
        }

        // Se a pilha estiver vazia no final, a expressão está correta
        return pilha.isEmpty();
    }

    // Função para verificar se os caracteres de abertura e fechamento correspondem
    private static boolean corresponde(char abertura, char fechamento) {
        return (abertura == '(' && fechamento == ')') ||
               (abertura == '[' && fechamento == ']') ||
               (abertura == '{' && fechamento == '}');
    }
}