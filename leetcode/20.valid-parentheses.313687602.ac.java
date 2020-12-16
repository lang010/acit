/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 *
 * https://leetcode.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (39.44%)
 * Total Accepted:    1.2M
 * Total Submissions: 3.1M
 * Testcase Example:  '"()"'
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * 
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "()"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "()[]{}"
 * Output: true
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "(]"
 * Output: false
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: s = "([)]"
 * Output: false
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: s = "{[]}"
 * Output: true
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^4
 * s consists of parentheses only '()[]{}'.
 * 
 * 
 */
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else {
                if (stack.isEmpty())
                    return false;
                char o = stack.pop();
                if (c == ')' && o == '('
                    || c == ']' && o == '['
                    || c == '}' && o == '{') {
                    continue;
                }
                return false;
            }
        }
        return stack.isEmpty();
    }
}
