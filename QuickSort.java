public class QuickSort {
    private static long qtempo;

    public static long temp()
    {
        return qtempo;
    }

    public static void quickSort(int[] vetor) {
        long tempo = System.nanoTime();

        quickSort(vetor, 0, vetor.length - 1);
        
        tempo -= System.nanoTime();
        qtempo = tempo * -1;
    }

    public static void quickSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int pivo = Pivo(vetor, inicio, fim);
            quickSort(vetor, inicio, pivo - 1);
            quickSort(vetor, pivo + 1, fim);
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
            if (vetor[j] <= valorPivo) {
                i++;

                temp = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = temp;
            }
        }
        temp = vetor[i + 1];
        vetor[i + 1] = vetor[fim];
        vetor[fim] = temp;
        return (i + 1);
    }
}
