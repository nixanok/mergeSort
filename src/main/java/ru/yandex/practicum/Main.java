package ru.yandex.practicum;

public class Main {
    public static void main(String[] args) {
        int[] a = new int[]{5, 1, 2, 10, 3};
        sort(a, 0, a.length - 1);
        for (int e : a) {
            System.out.println(e);
        }
    }

    public static void sort(int[] a, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            sort(a, p, q);
            sort(a, q + 1, r);
            merge(a, p, q, r);
        }
    }

    public static void merge(int[] a, int l, int mid, int r) {
        int n = r + 1;
        int[] left = new int[mid - l + 1];
        int[] right = new int[n - mid - 1];

        if (mid + 1 - l >= 0) System.arraycopy(a, l, left, 0, mid + 1 - l);

        for(int i = mid + 1; i < n; i++) {
            right[i - mid - 1] = a[i];
        }

        int leftIndex = 0;
        int rightIndex = 0;
        int index = l;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                a[index] = left[leftIndex];
                leftIndex++;
            }
            else {
                a[index] = right[rightIndex];
                rightIndex++;
            }
            index++;
        }

        for (int i = leftIndex; i < left.length; i++) {
            a[index] = left[i];
            index++;
        }

        for (int i = rightIndex; i < right.length; i++) {
            a[index] = right[i];
            index++;
        }

    }
}