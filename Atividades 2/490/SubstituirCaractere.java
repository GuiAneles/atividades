public class SubstituirCaractere {
    public static int substituirCaractere(char[] palavra, char caractere) {
        int count = 0;

        for (int i = 0; i < palavra.length; i++) {
            if (palavra[i] == caractere) {
                palavra[i] = '*';
                count++;
            }
        }
        return count;
    }
}