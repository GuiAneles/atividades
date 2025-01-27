public class Solucao {
    public static int josephus(int n, int m) {
        if (n == 1) {
            return 0;
        } else {
            return (josephus(n - 1, m) + m) % n;
        }
    }

    public static void main(String[] args) {
        int n = 20; 
        int m = 3; 
        int sobrevivente = josephus(n, m) + 1; 
        System.out.println("A pessoa sobrevivente é a de número: " + sobrevivente);
    }
}
