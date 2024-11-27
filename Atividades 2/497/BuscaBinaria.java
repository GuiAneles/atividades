public class BuscaBinaria {
    public int buscar(int[] vetor, int tamanho, int chave) {
        int inicio = 0;
        int fim = tamanho - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;

            if (vetor[meio] == chave) {
                return meio; 
            } else if (vetor[meio] < chave) {
                inicio = meio + 1; 
            } else {
                fim = meio - 1;
            }
        }

        return -1;
    }
}