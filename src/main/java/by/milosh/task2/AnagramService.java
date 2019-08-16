package by.milosh.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;

public class AnagramService {

    private static final int NUMBER_OF_LETTERS_ENGLISH_ALPHABET = 26;
    private static final int START_INDEX_OF_ENGLISH_ALPHABET = 97;

    private LinkedHashMap<String, ArrayList<String>> tree;

    public AnagramService() {
        this.tree = new LinkedHashMap<>();
    }

    // algorithm complexity: ( (n*(n+1))/2 )*a + n*(n*log n) -> n^2 * (a + log n)
    // where n - number of strings in array
    //       a - number of chars of most length word
    public String[][] returnAnagramsList(String[] array) {
        tree.put(array[0], new ArrayList<String>());
        for (String arr : array) {
            boolean exist = false;
            for (String key : tree.keySet()) {
                if (compare(key, arr)) {
                    ArrayList<String> innerList = tree.get(key);
                    innerList.add(arr);
                    tree.put(key, innerList);
                    exist = true;
                }
            }
            if (!exist) {
                tree.put(arr, new ArrayList<String>(Arrays.asList(arr)));
            }
        }
        for (ArrayList<String> list : tree.values()) {
            Collections.sort(list);
        }

        return mapToArray(tree);
    }

    // from this https://stackoverflow.com/a/28800457/8178320
    private boolean compare(String a, String b) {
        char[] aArr = a.toLowerCase().toCharArray();
        char[] bArr = b.toLowerCase().toCharArray();
        if (aArr.length != bArr.length)
            return false;
        int[] counts = new int[NUMBER_OF_LETTERS_ENGLISH_ALPHABET];
        for (int i = 0; i < aArr.length; i++) {
            counts[aArr[i] - START_INDEX_OF_ENGLISH_ALPHABET]++;
            counts[bArr[i] - START_INDEX_OF_ENGLISH_ALPHABET]--;
        }
        for (int i = 0; i < NUMBER_OF_LETTERS_ENGLISH_ALPHABET; i++)
            if (counts[i] != 0)
                return false;
        return true;
    }

    private String[][] mapToArray(LinkedHashMap<String, ArrayList<String>> tree) {
        String[][] array = new String[tree.size()][];
        Object[] mapValues = tree.values().toArray();
        for (int i = 0; i < mapValues.length; i++) {
            ArrayList<String> arr = (ArrayList<String>) mapValues[i];
            array[i] = new String[arr.size()];
            for (int j = 0; j < arr.size(); j++) {
                array[i][j] = arr.get(j);
            }
        }
        return array;
    }
}
