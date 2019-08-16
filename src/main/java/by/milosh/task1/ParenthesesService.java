package by.milosh.task1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ParenthesesService {

    private String open;
    private String close;
    private Map<Character, Character> pairs;

    public ParenthesesService() {
        this.open = "({[";
        this.close = ")}]";
        this.pairs = new HashMap<>();
        this.pairs.put(')', '(');
        this.pairs.put('}', '{');
        this.pairs.put(']', '[');
    }

    public boolean checkParentheses(String parentheses) {
        char[] chars = parentheses.toCharArray();
        LinkedList<Character> stack = new LinkedList<>();
        for (char ch : chars) {
            if (open.indexOf(ch) != -1) {
                stack.addFirst(ch);
            } else if (close.indexOf(ch) != -1) {
                if (pairs.get(ch) == stack.getFirst()) {
                    stack.removeFirst();
                } else {
                    break;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
