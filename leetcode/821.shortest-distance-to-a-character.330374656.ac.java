/*
 * @lc app=leetcode id=821 lang=java
 *
 * [821] Shortest Distance to a Character
 *
 * https://leetcode.com/problems/shortest-distance-to-a-character/description/
 *
 * algorithms
 * Easy (67.61%)
 * Total Accepted:    74.4K
 * Total Submissions: 110K
 * Testcase Example:  '"loveleetcode"\n"e"'
 *
 * Given a string S and a character C, return an array of integers representing
 * the shortest distance from the character C in the string.
 * 
 * Example 1:
 * 
 * 
 * Input: S = "loveleetcode", C = 'e'
 * Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * S string length is in [1, 10000].
 * C is a single character, and guaranteed to be in string S.
 * All letters in S and C are lowercase.
 * 
 * 
 */
class Solution {
    public int[] shortestToChar(String S, char C) {
        int n = S.length();
        int[] ans = new int[n];
        int st = -n;
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == C)
                st = i;
            ans[i] = i - st;
        }
        st = n+n;
        for (int i = n-1; i >= 0; i--) {
            if (S.charAt(i) == C)
                st = i;
            ans[i] = Math.min(ans[i], st-i);
        }
        return ans;
    }
}
