import java.util.LinkedList;

class Reversor {

    public static String reverterPalavras(String frase) {
        StringBuilder resultado = new StringBuilder();
        String[] palavras = frase.split(" ");
        for (String palavra : palavras) {
            LinkedList<Character> lista = new LinkedList<>();

            for (char c : palavra.toCharArray()) {
                lista.push(c);
            }

            while (!lista.isEmpty()) {
                resultado.append(lista.poll());
            }

            resultado.append(" ");
        }

        return resultado.toString().trim();
    }
}