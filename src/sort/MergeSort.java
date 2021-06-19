package sort;

import java.util.Arrays;

public class MergeSort implements Sort {
    @Override
    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int left, int right) {
        if (right <= left) {
            return;
        }

        int mid = (left + right) / 2;
        sort(arr, left, mid);
        sort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);
        int i = 0, j = 0;
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] < rightArr[j]) {
                arr[left++] = leftArr[i++];
            } else {
                arr[left++] = rightArr[j++];
            }
        }

        while (i < leftArr.length) {
            arr[left++] = leftArr[i++];
        }
        while (j < rightArr.length) {
            arr[left++] = rightArr[j++];
        }
    }
}
