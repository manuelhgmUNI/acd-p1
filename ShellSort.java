public class ShellSort {
public static <T extends Comparable<T>>
void shellsort(T[] a) {
    int n = a.length;
    for (int vao = n / 2; vao > 0; vao /= 2) {
        for (int i = vao; i < n; i++) {
            T chave = a[i];
            int j = i;
            while (j >= vao && a[j - vao].compareTo(chave) > 0) {
                a[j] = a[j - vao];
                j -= vao;
            }
            a[j] = chave;
        }
    }
}
}
