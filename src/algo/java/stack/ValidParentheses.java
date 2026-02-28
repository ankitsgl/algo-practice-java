package algo.java.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import algo.java.data.structure.Stack;

/*
Leet code: https://leetcode.com/problems/valid-parentheses/description/
Submission: https://leetcode.com/problems/valid-parentheses/submissions/1933224078/
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 */
public class ValidParentheses {
    private static final HashMap<Character, Character> OPEN_PARENTHESES =
            new HashMap<>(Map.of('[', ']', '(',')', '{','}'));
    private static final HashMap<Character, Character> CLOSE_PARENTHESES =
            new HashMap<>(Map.of(']', '[', ')','(', '}','{'));

    private final Stack<Character> stack;

    public ValidParentheses() {
        stack = new Stack<>();
    }

    public boolean isValid(String data) {
        for(Character chr : Optional.ofNullable(data).orElse("").toCharArray()) {
            if (OPEN_PARENTHESES.containsKey(chr)) {
                stack.push(chr);
            } else if (CLOSE_PARENTHESES.containsKey(chr)) {
                if (stack.size() == 0 ||
                        !stack.pop().equals(CLOSE_PARENTHESES.get(chr))) {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }
}
