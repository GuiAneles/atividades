public class SomaVetores {
    public static void somaVetores(int[] vetorA, int[] vetorB, int[] resultado) {
        for (int i = 0; i < vetorA.length; i++) {
            resultado[i] = vetorA[i] + vetorB[i];
        }
    }
}
