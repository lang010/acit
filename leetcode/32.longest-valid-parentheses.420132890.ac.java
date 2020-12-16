/*
 * @lc app=leetcode id=32 lang=java
 *
 * [32] Longest Valid Parentheses
 *
 * https://leetcode.com/problems/longest-valid-parentheses/description/
 *
 * algorithms
 * Hard (28.98%)
 * Total Accepted:    323.3K
 * Total Submissions: 1.1M
 * Testcase Example:  '"(()"'
 *
 * Given a string containing just the characters '(' and ')', find the length
 * of the longest valid (well-formed) parentheses substring.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()".
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = ""
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= s.length <= 3 * 10^4
 * s[i] is '(', or ')'.
 * 
 * 
 */
class Solution {
    public int longestValidParentheses(String s) {
        int ans = 0;
        Stack<Object> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push('(');
            } else if (c == ')') {
                int cur = 0;
                while (!stack.isEmpty() && (stack.peek() instanceof Integer))
                    cur += (int) stack.pop();
                if (!stack.isEmpty()) {
                    cur += 2;
                    stack.pop();
                    stack.push(cur);
                }
                ans = Math.max(ans, cur);
            }
        }
        int sum = 0;
        for (Object o : stack) {
            if (o instanceof Integer) {
                sum += (int) o;
                ans = Math.max(ans, sum);
            } else
                sum = 0;
        }
        
        return ans;
    }
}
