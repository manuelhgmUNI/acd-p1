public class InsertionSort {
   public static <T extends Comparable<T>>
    void insertionsort(T[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            T chave = a[i];
            int j = i - 1;
            while (j >= 0 && a[j].compareTo(chave) > 0) {

                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = chave;
        }
}}
