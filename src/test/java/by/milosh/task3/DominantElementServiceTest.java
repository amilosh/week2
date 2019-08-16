package by.milosh.task3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DominantElementServiceTest {

    private DominantElementService dominantElementService = new DominantElementService();

    @Test
    public void testFindElement() {
        int[] elements = new int[]{10, 9, 9, 9, 10};
        int returnedElement = dominantElementService.findElement(elements);
        int expectedElement = 9;
        assertEquals(returnedElement, expectedElement);
    }

    @Test
    public void testFindElementFast() {
        int[] elements = new int[]{10, 2, 9, 9, 9, 10, 2, 2, 3, 2};
        int returnedElement = dominantElementService.findElementFast(elements);
        int expectedElement = 2;
        assertEquals(returnedElement, expectedElement);
    }
}
