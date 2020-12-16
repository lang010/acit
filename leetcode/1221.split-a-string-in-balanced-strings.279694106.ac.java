/*
 * @lc app=leetcode id=1221 lang=java
 *
 * [1221] Split a String in Balanced Strings
 *
 * https://leetcode.com/problems/split-a-string-in-balanced-strings/description/
 *
 * algorithms
 * Easy (83.92%)
 * Total Accepted:    116.1K
 * Total Submissions: 138.3K
 * Testcase Example:  '"RLRRLLRLRL"'
 *
 * Balanced strings are those who have equal quantity of 'L' and 'R'
 * characters.
 * 
 * Given a balanced string s split it in the maximum amount of balanced
 * strings.
 * 
 * Return the maximum amount of splitted balanced strings.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "RLRRLLRLRL"
 * Output: 4
 * Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring
 * contains same number of 'L' and 'R'.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "RLLLLRRRLR"
 * Output: 3
 * Explanation: s can be split into "RL", "LLLRRR", "LR", each substring
 * contains same number of 'L' and 'R'.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "LLLLRRRR"
 * Output: 1
 * Explanation: s can be split into "LLLLRRRR".
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: s = "RLRRRLLRLL"
 * Output: 2
 * Explanation: s can be split into "RL", "RRRLLRLL", since each substring
 * contains an equal number of 'L' and 'R'
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 1000
 * s[i] = 'L' or 'R'
 * 
 * 
 */
class Solution {
    public int balancedStringSplit(String s) {
        int r = 0;
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == 'R') {
                cnt++;
            } else if (c == 'L') {
                cnt --;
            } else {
                continue;
            }
            if (cnt == 0) {
                r++;
            }
        }
        return r;
    }
}
