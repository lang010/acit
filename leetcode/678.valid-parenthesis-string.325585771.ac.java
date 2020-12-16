/*
 * @lc app=leetcode id=678 lang=java
 *
 * [678] Valid Parenthesis String
 *
 * https://leetcode.com/problems/valid-parenthesis-string/description/
 *
 * algorithms
 * Medium (31.42%)
 * Total Accepted:    123.6K
 * Total Submissions: 393.4K
 * Testcase Example:  '"()"'
 *
 * 
 * Given a string containing only three types of characters: '(', ')' and '*',
 * write a function to check whether this string is valid. We define the
 * validity of a string by these rules:
 * 
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left
 * parenthesis '(' or an empty string.
 * An empty string is also valid.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: "()"
 * Output: True
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: "(*)"
 * Output: True
 * 
 * 
 * 
 * Example 3:
 * 
 * Input: "(*))"
 * Output: True
 * 
 * 
 * 
 * Note:
 * 
 * The string size will be in the range [1, 100].
 * 
 * 
 */
class Solution {
    public boolean checkValidString(String s) {
        int le = 0, st = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                le++;
            } else if (c == ')') {
                if (le > 0)
                    le--;
                else if (st > 0)
                    st--;
                else
                    return false;
            } else if (c == '*') {
                st++;
            }
        }
        if (le == 0)
            return true;
        int ri = 0;
        st = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ')' || c == '*')
                ri++;
            else if (c == '(') {
                if (ri == 0)
                    return false;
                ri--;
            }
        }
        return true;
    }
}
