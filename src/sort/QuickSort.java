package sort;

import java.util.Arrays;

public class QuickSort implements Sort {
    @Override
    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int left, int right) {
        if (right <= left) {
            return;
        }

        int pivotIndex = split(arr, left, right);
        sort(arr, left, pivotIndex - 1);
        sort(arr, pivotIndex + 1, right);
    }

    private int split(int[] arr, int left, int right) {
        int i = left, j = right;
        int pivot = arr[left];

        while (i < j) {
            while (arr[j] > pivot) {
                j--;
            }
            while (arr[i] <= pivot && i < j) {
                i++;
            }

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        arr[left] = arr[i];
        arr[i] = pivot;

        return i;
    }
}
