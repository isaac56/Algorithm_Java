package sort;

public class InsertionSort implements Sort {
    public void sort(int[] arr) {
        for (int i = 1; i < arr.length - 1; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = temp;
        }
    }
}
