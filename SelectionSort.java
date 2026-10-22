public class SelectionSort {
    public static <T extends Comparable<T>>
    void selectionsort(T[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j].compareTo(a[menor]) < 0) {
                    menor = j;
                }
            }
            if (menor != i) {
                T temp = a[i];
                a[i] = a[menor];
                a[menor] = temp;
            }
        }
    }
}