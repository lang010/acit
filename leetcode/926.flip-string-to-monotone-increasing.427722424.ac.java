/*
 * @lc app=leetcode id=926 lang=java
 *
 * [926] Flip String to Monotone Increasing
 *
 * https://leetcode.com/problems/flip-string-to-monotone-increasing/description/
 *
 * algorithms
 * Medium (52.81%)
 * Total Accepted:    24.5K
 * Total Submissions: 46.5K
 * Testcase Example:  '"00110"'
 *
 * A string of '0's and '1's is monotone increasing if it consists of some
 * number of '0's (possibly 0), followed by some number of '1's (also possibly
 * 0.)
 * 
 * We are given a string S of '0's and '1's, and we may flip any '0' to a '1'
 * or a '1' to a '0'.
 * 
 * Return the minimum number of flips to make S monotone increasing.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "00110"
 * Output: 1
 * Explanation: We flip the last digit to get 00111.
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "010110"
 * Output: 2
 * Explanation: We flip to get 011111, or alternatively 000111.
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "00011000"
 * Output: 2
 * Explanation: We flip to get 00000000.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= S.length <= 20000
 * S only consists of '0' and '1' characters.
 * 
 * 
 * 
 * 
 */
class Solution {
    public int minFlipsMonoIncr(String S) {
        int a0 = 0, a1 = 0;
        int cnt = 0;
        for (char c : S.toCharArray()) {
            int b0, b1;
            if (c == '0') {
                b0 = a0;
                b1 = Math.min(a0+1, a1+1);
            } else {
                cnt++;
                b0 = cnt;
                b1 = Math.min(a0, a1);
            }
            a0 = b0;
            a1 = b1;
        }
        return Math.min(a0, a1);
    }
}
