/*
 * @lc app=leetcode id=395 lang=java
 *
 * [395] Longest Substring with At Least K Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/description/
 *
 * algorithms
 * Medium (43.17%)
 * Total Accepted:    106K
 * Total Submissions: 245.5K
 * Testcase Example:  '"aaabb"\n3'
 *
 * Given a string s and an integer k, return the length of the longest
 * substring of s such that the frequency of each character in this substring
 * is greater than or equal to k.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "aaabb", k = 3
 * Output: 3
 * Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "ababbc", k = 2
 * Output: 5
 * Explanation: The longest substring is "ababb", as 'a' is repeated 2 times
 * and 'b' is repeated 3 times.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^4
 * s consists of only lowercase English letters.
 * 1 <= k <= 10^5
 * 
 * 
 */
class Solution {
    public int longestSubstring(String s, int k) {
        return longest(s, 0, s.length(), k);
    }
    
    int longest(String s, int l, int r, int k) {
        if (r-l < k)
            return 0;
        int[] cnt = new int[26];
        int[] end = new int[26];
        for (int i = l; i < r; i++) {
            int c = s.charAt(i) - 'a';
            cnt[c]++;
            end[c] = i;
        }
        int m = -1;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0 &&  cnt[i] < k) {
                m = end[i];
                break;
            }
        }
        if (m >= 0) {
            return Math.max(longest(s, l, m, k), longest(s, m+1, r, k));
        } else {
            return r-l;
        }
    }
}
