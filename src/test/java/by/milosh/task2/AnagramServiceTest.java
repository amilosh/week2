package by.milosh.task2;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class AnagramServiceTest {

    private AnagramService anagramService = new AnagramService();

    @Test
    public void testReturnAnagramsList() {
        String[] array = {"eat", "tea", "tan", "ate", "nat", "bat", "ssaha", "sasha"};
        String[][] checkArray = {
                {"ate", "eat", "tea"},
                {"nat", "tan"},
                {"bat"},
                {"sasha", "ssaha"}
        };
        String[][] returnArray = anagramService.returnAnagramsList(array);
        boolean isTwoArraysEqual = Arrays.deepEquals(returnArray, checkArray);
        assertTrue(isTwoArraysEqual);
    }
}
