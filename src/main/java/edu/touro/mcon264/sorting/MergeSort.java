package edu.touro.mcon264.sorting;

import java.util.Comparator;

public class MergeSort implements Sorter {

    @Override
    public <T> void sort(T[] a, Comparator<? super T> comp) {
        if (a == null || a.length <= 1) {
            return;
        }
        @SuppressWarnings("unchecked") T[] aux = (T[]) new Object[a.length];
        mergeSort(a, aux, 0, a.length - 1, comp);
    }

    private <T> void mergeSort(T[] a, T[] aux, int left, int right, Comparator<? super T> comp) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(a, aux, left, mid, comp);
        mergeSort(a, aux, mid + 1, right, comp);
        merge(a, aux, left, mid, right, comp);
    }

    private <T> void merge(T[] a, T[] aux, int left, int mid, int right, Comparator<? super T> comp) {
        for (int i = left; i <= right; i++) {
            aux[i] = a[i];
        }
        int i = left;
        int j = mid + 1;
        int k = left;
        while (i <= mid && j <= right) {
            if (comp.compare(aux[i], aux[j]) <= 0) {
                a[k++] = aux[i++];
            } else {
                a[k++] = aux[j++];
            }
        }
        while (i <= mid) {
            a[k++] = aux[i++];
        }
    }
}