/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 *
 * https://leetcode.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (25.69%)
 * Total Accepted:    481.1K
 * Total Submissions: 1.9M
 * Testcase Example:  '"12"'
 *
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * 
 * Given a non-empty string containing only digits, determine the total number
 * of ways to decode it.
 * 
 * The answer is guaranteed to fit in a 32-bit integer.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2
 * 6).
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "0"
 * Output: 0
 * Explanation: There is no character that is mapped to a number starting with
 * '0'. We cannot ignore a zero when we face it while decoding. So, each '0'
 * should be part of "10" --> 'J' or "20" --> 'T'.
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: s = "1"
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 100
 * s contains only digits and may contain leading zero(s).
 * 
 * 
 */
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.startsWith("0"))
            return 0;
        int pre0 = 1;
        int pre = 1;
        int cur = pre;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i-1);
            if (s.charAt(i) == '0') {
                if (c <= '2' && c >= '1')
                    cur = pre0;
                else
                    return 0;
            } else if (c == '1' || c == '2' && s.charAt(i) <= '6') {
                cur = pre + pre0;
            } else {
                cur = pre;
            }
            pre0 = pre;
            pre = cur;
        }
        
        return cur;
    }
}
