import java.util.ArrayList;
import java.util.Collections;
public class BucketSort {
    private static long btempo;

    public static long temp()
    {
        return btempo;
    }

     public static void bucketSort(int[] vetor) {
        int n = vetor.length;
        if (n <= 1) {
            return;
        }

        int maior = vetor[0];
        for (int i = 1; i < n; i++) {
            if (vetor[i] > maior) {
                maior = vetor[i];
            }
        }

        long tempo = System.nanoTime();
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            buckets.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < n; i++) {
            int indice;
            if (maior == 0) {
                indice = 0;
            } else {
                indice = (int) ((long) vetor[i] * n / ((long) maior + 1));
            }
            buckets.get(indice).add(vetor[i]);
        }

        for (int i = 0; i < n; i++) {
            Collections.sort(buckets.get(i));
        }

        int posicao = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets.get(i).size(); j++) {
                vetor[posicao] = buckets.get(i).get(j);
                posicao++;
            }
        }
        btempo = System.nanoTime() - tempo;
    }

    public static void imprimirVetor(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println();
    }
}