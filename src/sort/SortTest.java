package sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SortTest {
    private int[] array;
    private int[] answer = new int[]{0, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 7, 8, 8, 8, 11, 32};

    @BeforeEach
    void setUp() {
        array = new int[]{1, 5, 3, 6, 2, 4, 2, 6, 3, 5, 8, 3, 2, 4, 7, 8, 4, 4, 2, 3, 5, 8, 0, 11, 2, 32};
    }

    @Test
    void bubbleSort() {
        sortTest(new BubbleSort(), array, answer);
    }

    @Test
    void selectionSort() {
        sortTest(new SelectionSort(), array, answer);
    }

    @Test
    void insertionsSort() {
        sortTest(new InsertionSort(), array, answer);
    }

    @Test
    void quickSort() {
        sortTest(new QuickSort(), array, answer);
    }

    @Test
    void mergeSort() {
        sortTest(new MergeSort(), array, answer);
    }


    private void sortTest(Sort sort, int[] array, int[] answer) {
        sort.sort(array);
        Assertions.assertTrue(Arrays.equals(array, answer));
    }
}
