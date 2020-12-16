/*
 * @lc app=leetcode id=1249 lang=java
 *
 * [1249] Minimum Remove to Make Valid Parentheses
 *
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/description/
 *
 * algorithms
 * Medium (63.35%)
 * Total Accepted:    126.4K
 * Total Submissions: 199.5K
 * Testcase Example:  '"lee(t(c)o)de)"'
 *
 * Given a string s of '(' , ')' and lowercase English characters. 
 * 
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in
 * any positions ) so that the resulting parentheses string is valid and return
 * any valid string.
 * 
 * Formally, a parentheses string is valid if and only if:
 * 
 * 
 * It is the empty string, contains only lowercase characters, or
 * It can be written as AB (A concatenated with B), where A and B are valid
 * strings, or
 * It can be written as (A), where A is a valid string.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "lee(t(c)o)de)"
 * Output: "lee(t(c)o)de"
 * Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "a)b(c)d"
 * Output: "ab(c)d"
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "))(("
 * Output: ""
 * Explanation: An empty string is also valid.
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: s = "(a(b(c)d)"
 * Output: "a(b(c)d)"
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^5
 * s[i] is one of  '(' , ')' and lowercase English letters.
 * 
 */
class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++)
            switch (s.charAt(i)) {
                case '(':
                    stack.add(i);
                    break;
                case ')':
                    if (!stack.isEmpty() && s.charAt(stack.peek()) == '(')
                        stack.pop();
                    else
                        stack.add(i);
                    break;
            }
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() -1; i>=0 ; i--) {
            if (!stack.isEmpty() && stack.peek() == i) {
                stack.pop();
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.reverse().toString();
    }
}
