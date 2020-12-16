/*
 * @lc app=leetcode id=1190 lang=java
 *
 * [1190] Reverse Substrings Between Each Pair of Parentheses
 *
 * https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/description/
 *
 * algorithms
 * Medium (63.92%)
 * Total Accepted:    26.3K
 * Total Submissions: 41.1K
 * Testcase Example:  '"(abcd)"'
 *
 * You are given a string s that consists of lower case English letters and
 * brackets. 
 * 
 * Reverse the strings in each pair of matching parentheses, starting from the
 * innermost one.
 * 
 * Your result should not contain any brackets.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "(abcd)"
 * Output: "dcba"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "(u(love)i)"
 * Output: "iloveu"
 * Explanation: The substring "love" is reversed first, then the whole string
 * is reversed.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "(ed(et(oc))el)"
 * Output: "leetcode"
 * Explanation: First, we reverse the substring "oc", then "etco", and finally,
 * the whole string.
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: s = "a(bcdefghijkl(mno)p)q"
 * Output: "apmnolkjihgfedcbq"
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= s.length <= 2000
 * s only contains lower case English characters and parentheses.
 * It's guaranteed that all parentheses are balanced.
 * 
 * 
 */
class Solution {
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        helper(s, sb, 0);
        
        return sb.toString();
    }
    
    int helper(String s, StringBuilder sb, int l) {
        while (l < s.length()) {
            char c = s.charAt(l);
            if (c == ')')
                break;
            if (c == '(') {
                StringBuilder next = new StringBuilder();
                l = helper(s, next, l+1);
                sb.append(next.reverse());
            } else {
                l++;
                sb.append(c);
            }
        }
        return ++l;
    }
}
