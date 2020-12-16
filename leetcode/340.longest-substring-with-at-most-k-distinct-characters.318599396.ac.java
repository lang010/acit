/*
 * @lc app=leetcode id=340 lang=java
 *
 * [340] Longest Substring with At Most K Distinct Characters
 *
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/description/
 *
 * algorithms
 * Hard (44.79%)
 * Total Accepted:    165.4K
 * Total Submissions: 369.3K
 * Testcase Example:  '"eceba"\n2'
 *
 * Given a string, find the length of the longest substring T that contains at
 * most k distinct characters.
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: s = "eceba", k = 2
 * Output: 3
 * Explanation: T is "ece" which its length is 3.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "aa", k = 1
 * Output: 2
 * Explanation: T is "aa" which its length is 2.
 * 
 * 
 * 
 */
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int max = 0;
        int l = 0;
        int r = 0;
        int len = 0;
        int[] map = new int[256];
        while (r < s.length()) {
            int id = s.charAt(r++);
            map[id]++;
            if (map[id] == 1)
                len++;
            while (len > k) {
                id = s.charAt(l++);
                map[id]--;
                if (map[id] == 0)
                    len--;
            }
            if (r-l > max)
                max = r-l;
        }
        return max;
    }
}
