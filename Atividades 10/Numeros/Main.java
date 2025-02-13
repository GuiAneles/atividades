//n usei JOptionPane pq é biblioteca nativa
public class Main {
    public static void main(String[] args) {
        int[] vetor = new int[1000];

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = gerarNumeroAleatorio(-9999, 9999);
        }

        /*na atividade o senhor fala pra: "Faça a impressão desses números na sua ordem de geração."
        e no exemplo imprime numero por numero, como são mil numeros vou só imprimir a lista toda mesmo*/
        
        System.out.println("Numeros Gerados:");
        for (int num : vetor) {
            System.out.print(num + " ");
        }
        System.out.println();

        ListaDE lista = new ListaDE();
        for (int num : vetor) {
            lista.inserirOrdenado(num);
        }

        System.out.println("Lista Em Ordem Crescente:");
        lista.imprimirCrescente();

        System.out.println("Lista Em Ordem Decrescente:");
        lista.imprimirDecrescente();

        lista.removerPrimos();

        System.out.println("Lista Apos Remover Numeros Primos:");
        lista.imprimirCrescente();
    }


    private static int gerarNumeroAleatorio(int min, int max) {
        long tempo = System.nanoTime();
        int numero = (int) ((tempo % (max - min + 1))) + min;
        return numero;
    }
}
