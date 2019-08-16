package by.milosh.task1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParenthesesServiceTest {

    ParenthesesService parenthesesService = new ParenthesesService();

    @Test
    public void checkParentheses() {
        String parentheses = "({[](){[]}})";
        boolean check = parenthesesService.checkParentheses(parentheses);
        final boolean expectedCheck = true;
        assertEquals(check, expectedCheck);
    }
}
