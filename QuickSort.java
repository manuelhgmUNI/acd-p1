public class QuickSort {
    public static void QuickSort(int[] vetor) {
        QuickSort(vetor, 0, vetor.length - 1);
    }

    public static void QuickSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int pivo = Pivo(vetor, inicio, fim);
            QuickSort(vetor, inicio, pivo - 1);
            QuickSort(vetor, pivo + 1, fim);
        }
    }

    public static int Pivo(int[] vetor, int inicio, int fim) {
        int meio = inicio + (fim - inicio) / 2;
        int valorPivo = vetor[meio];
        int temp = vetor[meio];
        vetor[meio] = vetor[fim];
        vetor[fim] = temp;
        int i = inicio - 1;

        for (int j = inicio; j < fim; j++) {
            if (vetor[i] <= valorPivo) {
                i++;
                vetor[i] = temp;
                vetor[i] = vetor[j];
                vetor[j] = temp;
            }
            temp = vetor[i + 1];
            vetor[i + 1] = vetor[fim];
            vetor[fim] = temp;
            return i + 1;
        }
    }
}
