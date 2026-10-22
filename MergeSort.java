public class MergeSort {
    public static <T extends Comparable<T>>
    void mergesort(T[] a) {
        if (a.length < 2) {
            return;
        }
        int mid = a.length / 2;
        T[] left = (T[]) new Comparable[mid];
        T[] right = (T[]) new Comparable[a.length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = a[i];
        }
        for (int i = mid; i < a.length; i++) {
            right[i - mid] = a[i];
        }
        mergesort(left);
        mergesort(right);
        merge(a, left, right);
    }

    private static <T extends Comparable<T>>
    void merge(T[] a, T[] left, T[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                a[k++] = left[i++];
            } else {
                a[k++] = right[j++];
            }
        }
        while (i < left.length) {
            a[k++] = left[i++];
        }
        while (j < right.length) {
            a[k++] = right[j++];
        }
    }
}
