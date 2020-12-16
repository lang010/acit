/*
 * @lc app=leetcode id=1513 lang=java
 *
 * [1513] Number of Substrings With Only 1s
 *
 * https://leetcode.com/problems/number-of-substrings-with-only-1s/description/
 *
 * algorithms
 * Medium (41.12%)
 * Total Accepted:    18K
 * Total Submissions: 43.8K
 * Testcase Example:  '"0110111"'
 *
 * Given a binary string s (a string consisting only of '0' and '1's).
 * 
 * Return the number of substrings with all characters 1's.
 * 
 * Since the answer may be too large, return it modulo 10^9 + 7.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "0110111"
 * Output: 9
 * Explanation: There are 9 substring in total with only 1's characters.
 * "1" -> 5 times.
 * "11" -> 3 times.
 * "111" -> 1 time.
 * 
 * Example 2:
 * 
 * 
 * Input: s = "101"
 * Output: 2
 * Explanation: Substring "1" is shown 2 times in s.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "111111"
 * Output: 21
 * Explanation: Each substring contains only 1's characters.
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: s = "000"
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * s[i] == '0' or s[i] == '1'
 * 1 <= s.length <= 10^5
 * 
 */
class Solution {
    public int numSub(String s) {
        long ans = 0;
        int c = 0;
        for (char i : s.toCharArray()) {
            if (i == '0') {
                ans += cnt(c);
                ans %= 1000000007;
                c = 0;
            } else 
                c++;
        }
        return (int)((ans + cnt(c))%1000000007);
    }
    
    long cnt(long n) {
        return n * (n+1) / 2;
    }
}
