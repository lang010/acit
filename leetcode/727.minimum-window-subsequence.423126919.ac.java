/*
 * @lc app=leetcode id=727 lang=java
 *
 * [727] Minimum Window Subsequence
 *
 * https://leetcode.com/problems/minimum-window-subsequence/description/
 *
 * algorithms
 * Hard (42.16%)
 * Total Accepted:    48.7K
 * Total Submissions: 115.6K
 * Testcase Example:  '"abcdebdde"\n"bde"'
 *
 * Given strings S and T, find the minimum (contiguous) substring W of S, so
 * that T is a subsequence of W.
 * 
 * If there is no such window in S that covers all characters in T, return the
 * empty string "". If there are multiple such minimum-length windows, return
 * the one with the left-most starting index.
 * 
 * Example 1:
 * 
 * 
 * Input: 
 * S = "abcdebdde", T = "bde"
 * Output: "bcde"
 * Explanation: 
 * "bcde" is the answer because it occurs before "bdde" which has the same
 * length.
 * "deb" is not a smaller window because the elements of T in the window must
 * occur in order.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * All the strings in the input will only contain lowercase letters.
 * The length of S will be in the range [1, 20000].
 * The length of T will be in the range [1, 100].
 * 
 * 
 * 
 * 
 */
class Solution {
    public String minWindow(String S, String T) {
        int n = S.length()+1;
        int m = T.length()+1;
        int[] dp0 = new int[n];
        int[] dp1 = new int[n];
        dp1[0] = n;
        String ans = "";
        int min = n;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++)
                if (S.charAt(j-1) == T.charAt(i-1))
                    dp1[j] = dp0[j-1] + 1;
                else
                    dp1[j] = dp1[j-1] + 1;
            int[] tmp = dp0;
            dp0 = dp1;
            dp1 = tmp;
            dp1[0] = n;
        }
        for (int i = 0; i < n; i++)
            if (dp0[i] < min) {
                min = dp0[i];
                ans = S.substring(i-min, i);
            }
        return ans;
    }
}
