import java.util.Scanner;

public class Expressao {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite uma expressão aritmética para verificar a parametrização:");
        String expressao = scanner.nextLine();

        if (Verificacao.verificarParametrizacao(expressao)) {
            System.out.println("A expressão está correta!");
        } else {
            System.out.println("A expressão está incorreta!");
        }

        scanner.close();
    }
}