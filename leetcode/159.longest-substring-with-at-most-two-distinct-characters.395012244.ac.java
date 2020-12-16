/*
 * @lc app=leetcode id=159 lang=java
 *
 * [159] Longest Substring with At Most Two Distinct Characters
 *
 * https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/description/
 *
 * algorithms
 * Medium (50.13%)
 * Total Accepted:    130.5K
 * Total Submissions: 260.4K
 * Testcase Example:  '"eceba"'
 *
 * Given a string s , find the length of the longest substring t  that contains
 * at most 2 distinct characters.
 * 
 * Example 1:
 * 
 * 
 * Input: "eceba"
 * Output: 3
 * Explanation: t is "ece" which its length is 3.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "ccaabbb"
 * Output: 5
 * Explanation: t is "aabbb" which its length is 5.
 * 
 * 
 */
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int cnt = 0;
        int ans = 0;
        int[] map = new int[256];
        int l = 0, r = 0;
        char[] arr = s.toCharArray();
        int n = arr.length;
        while (r < n) {
            while (cnt < 3 && r < n) {
                map[arr[r]]++;
                if (map[arr[r]] == 1)
                    cnt++;
                r++;
                if (cnt < 3)
                    ans = Math.max(ans, r-l);
            }
            while (cnt > 2) {
                map[arr[l]]--;
                if (map[arr[l]] == 0)
                    cnt--;
                l++;
            }
        }
        return ans;
    }
}
