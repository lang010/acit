/*
 * @lc app=leetcode id=567 lang=java
 *
 * [567] Permutation in String
 *
 * https://leetcode.com/problems/permutation-in-string/description/
 *
 * algorithms
 * Medium (44.48%)
 * Total Accepted:    162.8K
 * Total Submissions: 366K
 * Testcase Example:  '"ab"\n"eidbaooo"'
 *
 * Given two strings s1 and s2, write a function to return true if s2 contains
 * the permutation of s1. In other words, one of the first string's
 * permutations is the substring of the second string.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s1 = "ab" s2 = "eidbaooo"
 * Output: True
 * Explanation: s2 contains one permutation of s1 ("ba").
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The input strings only contain lower case letters.
 * The length of both given strings is in range [1, 10,000].
 * 
 * 
 */
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] cnt = new int[26];
        int n = s1.length();
        int tot = n;
        for (char c : s1.toCharArray())
            cnt[c-'a']--;
        for (int i = 0; i < s2.length(); i++) {
            int id = s2.charAt(i) - 'a';
            cnt[id]++;
            if (cnt[id] <= 0)
                tot--;
            if (i >= n) {
                id = s2.charAt(i-n) - 'a';
                cnt[id]--;
                if (cnt[id] < 0)
                    tot++;
            }
            if (tot == 0)
                return true;
        }
        return false;
    }
}
