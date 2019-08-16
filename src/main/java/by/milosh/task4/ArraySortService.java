package by.milosh.task4;

public class ArraySortService {

    public int[] sortArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                int min = arr[i];
                int minI = i;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] % 2 != 0) {
                        if (arr[j] < min) {
                            min = arr[j];
                            minI = j;
                        }
                    }
                }
                if (i != minI) {
                    int temp = arr[i];
                    arr[i] = arr[minI];
                    arr[minI] = temp;
                }
            }
        }
        return arr;
    }
}
