public class ShellSort {
    private static long shelltempo;
public static <T extends Comparable<T>>
T[] shellsort(T[] a) {
    int n = a.length;
    T[] ac = a.clone();

    long tempo = System.nanoTime();
    for (int vao = n / 2; vao > 0; vao /= 2) {
        for (int i = vao; i < n; i++) {
            T chave = ac[i];
            int j = i;
            while (j >= vao && ac[j - vao].compareTo(chave) > 0) {
                ac[j] = ac[j - vao];
                j -= vao;
            }
            ac[j] = chave;
        }
    }
    tempo -= System.nanoTime();

    shelltempo = tempo * -1;
    return ac;
}

public static long temp()
{
    return shelltempo;
}
}
