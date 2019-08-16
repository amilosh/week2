package by.milosh.task3;

import java.util.HashMap;
import java.util.Map;

public class DominantElementService {

    private Map<Integer, Integer> numbers;

    public DominantElementService() {
        this.numbers = new HashMap<>();
    }

    public int findElement(int[] elements) {
        for (int e : elements) {
            if (numbers.get(e) != null) {
                int value = numbers.get(e);
                numbers.put(e, value + 1);
            } else {
                numbers.put(e, 1);
            }
        }
        int maxValue = 0;
        int maxKey = 0;
        for (Map.Entry entry : numbers.entrySet()) {
            int value = (int) entry.getValue();
            if (value > maxValue) {
                maxValue = value;
                maxKey = (int) entry.getKey();
            }
        }
        return maxKey;
    }

    // algorithm complexity: O(n + n) -> O(n)
    public int findElementFast(int[] elements) {
        int max = getMaxValue(elements);
        int[] arrMax = new int[max + 2];
        for (int i = 0; i < elements.length; i++) {
            arrMax[elements[i] - 1]++;
            if (arrMax[elements[i] - 1] > arrMax[max]) {
                arrMax[max] = arrMax[elements[i] - 1];
                arrMax[max + 1] = elements[i];
            }
        }
        return arrMax[max + 1];
    }

    private int getMaxValue(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
