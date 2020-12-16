/*
 * @lc app=leetcode id=1180 lang=java
 *
 * [1180] Count Substrings with Only One Distinct Letter
 *
 * https://leetcode.com/problems/count-substrings-with-only-one-distinct-letter/description/
 *
 * algorithms
 * Easy (77.36%)
 * Total Accepted:    12.2K
 * Total Submissions: 15.8K
 * Testcase Example:  '"aaaba"'
 *
 * Given a string S, return the number of substrings that have only one
 * distinct letter.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: S = "aaaba"
 * Output: 8
 * Explanation: The substrings with one distinct letter are "aaa", "aa", "a",
 * "b".
 * "aaa" occurs 1 time.
 * "aa" occurs 2 times.
 * "a" occurs 4 times.
 * "b" occurs 1 time.
 * So the answer is 1 + 2 + 4 + 1 = 8.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: S = "aaaaaaaaaa"
 * Output: 55
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= S.length <= 1000
 * S[i] consists of only lowercase English letters.
 * 
 * 
 */
class Solution {
    public int countLetters(String S) {
        int cnt = 1;
        int ans = 0;
        for (int i = 0; i < S.length(); i++) {
            if (i+1 < S.length() && S.charAt(i) == S.charAt(i+1)) {
                cnt++;
            } else {
                ans += (cnt+1)*cnt/2;
                cnt = 1;
            }
        }
        return ans;
    }
}
