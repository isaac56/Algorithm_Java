package basic;

public class Permutation {
    public static void permutation(int[] arr, int depth){
        if(depth == arr.length - 1)
            printArr(arr);

        for(int i = depth; i < arr.length; i++) {
            swap(arr, depth, i);
            permutation(arr, depth+1);
            swap(arr, depth, i);
        }
    }

    public static void printArr(int[] arr){
        for(int e : arr) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    public static void swap(int[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        permutation(arr, 0);
    }
}
