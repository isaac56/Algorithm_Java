package sort;

public class HeapSort implements Sort {
    @Override
    public void sort(int[] arr) {
        for (int i = (arr.length - 1 - 1) / 2; i >= 0; i--) {
            heapify(arr, i, arr.length - 1);
        }

        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i - 1);
        }
    }

    public void heapify(int[] arr, int parent, int last) {
        int candidate = parent;
        int left = parent * 2 + 1;
        int right = parent * 2 + 2;

        if (left <= last && arr[candidate] < arr[left]) {
            candidate = left;
        }
        if (right <= last && arr[candidate] < arr[right]) {
            candidate = right;
        }

        if (candidate != parent) {
            int temp = arr[parent];
            arr[parent] = arr[candidate];
            arr[candidate] = temp;

            heapify(arr, candidate, last);
        }
    }
}
