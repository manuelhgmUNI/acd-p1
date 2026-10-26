public class HeapSort {
    private static long heaptempo;
    public static long temp()
    {
        return heaptempo;
    }

    public static int[] heapSort(int[] vetor) {
        int n = vetor.length;
        int [] cvetor = vetor.clone();

        long tempo = System.nanoTime();
        for (int i = n / 2 - 1; i >= 0; i--) {
            ajustarheap(cvetor, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            int temp = cvetor[0];
            cvetor[0] = cvetor[i];
            cvetor[i] = temp;
            ajustarheap(cvetor, i, 0);
        }
        heaptempo = System.nanoTime() - tempo;
        return cvetor;
    }

    public static void ajustarheap(int[] vetor, int n, int pai) {
        int maior = pai;
        int esquerda = 2 * pai + 1;
        int direita = 2 * pai + 2;

        if (esquerda < n && vetor[esquerda] > vetor[maior]) {
            maior = esquerda;
        }

        if (direita < n && vetor[direita] > vetor[maior]) {
            maior = direita;
        }

        if (maior != pai) {
            int temp = vetor[pai];
            vetor[pai] = vetor[maior];
            vetor[maior] = temp;
            ajustarheap(vetor, n, maior);
        }
    }
}