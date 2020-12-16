/*
 * @lc app=leetcode id=1234 lang=java
 *
 * [1234] Replace the Substring for Balanced String
 *
 * https://leetcode.com/problems/replace-the-substring-for-balanced-string/description/
 *
 * algorithms
 * Medium (34.22%)
 * Total Accepted:    14K
 * Total Submissions: 41K
 * Testcase Example:  '"QWER"'
 *
 * You are given a string containing only 4 kinds of characters 'Q', 'W', 'E'
 * and 'R'.
 * 
 * A string is said to be balanced if each of its characters appears n/4 times
 * where n is the length of the string.
 * 
 * Return the minimum length of the substring that can be replaced with any
 * other string of the same length to make the original string s balanced.
 * 
 * Return 0 if the string is already balanced.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "QWER"
 * Output: 0
 * Explanation: s is already balanced.
 * 
 * Example 2:
 * 
 * 
 * Input: s = "QQWE"
 * Output: 1
 * Explanation: We need to replace a 'Q' to 'R', so that "RQWE" (or "QRWE") is
 * balanced.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "QQQW"
 * Output: 2
 * Explanation: We can replace the first "QQ" to "ER". 
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: s = "QQQQ"
 * Output: 3
 * Explanation: We can replace the last 3 'Q' to make s = "QWER".
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^5
 * s.length is a multiple of 4
 * s contains only 'Q', 'W', 'E' and 'R'.
 * 
 * 
 */
class Solution {
    public int balancedString(String s) {
        int n = s.length();
        char[] chs = { 'Q', 'W', 'E', 'R' };
        int[] cnts = new int[4];
        for (char c : s.toCharArray())
            for (int i = 0; i < 4; i++)
                if (chs[i] == c) {
                    cnts[i]++;
                    break;
                }
        boolean bal = true;
        for (int i = 0; i < 4; i++)
            if (cnts[i] <= n/4) {
                cnts[i] = n;
            } else {
                cnts[i] -= n/4;
                bal = false;
            }
        if (bal)
            return 0;
        int l = 0;
        int ans = n;
        for (int i = 0; i < n; i++) {
            int j = 0;
            for (; j < 4; j++)
                if (s.charAt(i) == chs[j]) {
                    if (cnts[j] < n)
                        cnts[j]--;
                    break;
                }
            while (true) {
                boolean is = false;
                for (int t = 0; t < 4; t++)
                    if (cnts[t] < n && cnts[t] > 0) {
                        is = true;
                        break;
                    }
                if (is)
                    break;
                ans = Math.min(ans, i-l+1);
                for (int t = 0; t < 4; t++)
                    if (chs[t] == s.charAt(l)) {
                        if (cnts[t] < n)
                            cnts[t]++;
                        break;
                    }
                l++;
            }
        }
        return ans;
    }
}
