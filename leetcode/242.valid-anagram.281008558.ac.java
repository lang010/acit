/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 *
 * https://leetcode.com/problems/valid-anagram/description/
 *
 * algorithms
 * Easy (57.77%)
 * Total Accepted:    685.1K
 * Total Submissions: 1.2M
 * Testcase Example:  '"anagram"\n"nagaram"'
 *
 * Given two strings s and t , write a function to determine if t is an anagram
 * of s.
 * 
 * Example 1:
 * 
 * 
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "rat", t = "car"
 * Output: false
 * 
 * 
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * 
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your
 * solution to such case?
 * 
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            if (--cnt[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
