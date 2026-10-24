public class HeapSort {
    public static void HeapSort(int[] vetor) {
        int n = vetor.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            ajustarheap(vetor, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            int temp = vetor[0];
            vetor[0] = vetor[n];
            vetor[n] = temp;
            ajustarheap(vetor, n, 0);
        }
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