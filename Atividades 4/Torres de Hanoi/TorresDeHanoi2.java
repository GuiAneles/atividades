import javax.swing.JOptionPane;

public class TorresDeHanoi2 {

    // Método recursivo para resolver as Torres de Hanói
    public static void resolverTorresDeHanoi(long n, char origem, char destino, char auxiliar) {
        if (n == 1) {
            System.out.println("Mover disco 1 de " + origem + " para " + destino);
            return;
        }
        resolverTorresDeHanoi(n - 1, origem, auxiliar, destino);
        System.out.println("Mover disco " + n + " de " + origem + " para " + destino);
        resolverTorresDeHanoi(n - 1, auxiliar, destino, origem);
    }

    public static void main(String[] args) {
        // Solicita ao usuário o número de discos
        String input = JOptionPane.showInputDialog("Informe o número de discos:");
        long n = Long.parseLong(input); // Converte a entrada para um número long

        resolverTorresDeHanoi(n, 'A', 'C', 'B'); // A, B e C são as hastes
    }
}

/*1) 1 disco

2) 10 discos

3) 20 discos

4) 30 discos

5) 40 discos

6) 41 discos
*/