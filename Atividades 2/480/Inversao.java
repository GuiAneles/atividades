public class Inversao {

    public int reverso(int num) {
        int soma = 0;
        int r;

        while (num != 0) {
            r = num % 10;
            soma = soma * 10 + r; 
            num = num / 10; 
        }

        return soma;
    }
}