/*
 * @lc app=leetcode id=10 lang=java
 *
 * [10] Regular Expression Matching
 *
 * https://leetcode.com/problems/regular-expression-matching/description/
 *
 * algorithms
 * Hard (27.14%)
 * Total Accepted:    488.9K
 * Total Submissions: 1.8M
 * Testcase Example:  '"aa"\n"a"'
 *
 * Given an input string (s) and a pattern (p), implement regular expression
 * matching with support for '.' and '*' where: 
 * 
 * 
 * '.' Matches any single character.​​​​
 * '*' Matches zero or more of the preceding element.
 * 
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "aa", p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'.
 * Therefore, by repeating 'a' once, it becomes "aa".
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "ab", p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: s = "aab", p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore,
 * it matches "aab".
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: s = "mississippi", p = "mis*is*p*."
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= s.length <= 20
 * 0 <= p.length <= 30
 * s contains only lowercase English letters.
 * p contains only lowercase English letters, '.', and '*'.
 * It is guaranteed for each appearance of the character '*', there will be a
 * previous valid character to match.
 * 
 * 
 */
class Solution {
    public boolean isMatch(String s, String p) {
        int l1 = 0, l2 = 0;
        int n1 = s.length();
        int n2 = p.length();
        while (l1 < n1 || l2 < n2) {
            if (l2+1 < p.length() && p.charAt(l2+1) == '*') {
                // a*
                String np = p.substring(l2+2);
                if (isMatch(s.substring(l1), np))
                    return true;
                char c = p.charAt(l2);
                while (l1 < s.length() && (c == '.' || c == s.charAt(l1))) {
                    if (isMatch(s.substring(++l1), np))
                        return true;
                }
                return false;
            }
            if (l1 == n1 || l2 == n2)
                return false;
            if (l1 < n1 && l2 < n2) {
                if (p.charAt(l2) == '.' || p.charAt(l2) == s.charAt(l1)) {
                    l1++;
                    l2++;
                } else
                    return false;
            }
        }
        return true;
    }
}
