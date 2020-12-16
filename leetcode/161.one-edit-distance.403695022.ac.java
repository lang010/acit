/*
 * @lc app=leetcode id=161 lang=java
 *
 * [161] One Edit Distance
 *
 * https://leetcode.com/problems/one-edit-distance/description/
 *
 * algorithms
 * Medium (32.63%)
 * Total Accepted:    122.5K
 * Total Submissions: 375.5K
 * Testcase Example:  '"ab"\n"acb"'
 *
 * Given two strings s and t, return true if they are both one edit distance
 * apart, otherwise return false.
 * 
 * A string s is said to be one distance apart from a string t if you
 * can:
 * 
 * 
 * Insert exactly one character into s to get t.
 * Delete exactly one character from s to get t.
 * Replace exactly one character of s with a different character to get t.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "ab", t = "acb"
 * Output: true
 * Explanation: We can insert 'c' into s to get t.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "", t = ""
 * Output: false
 * Explanation: We cannot get t from s by only one step.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "a", t = ""
 * Output: true
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: s = "", t = "A"
 * Output: true
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= s.length <= 10^4
 * 0 <= t.length <= 10^4
 * s and t consist of lower-case letters, upper-case letters and/or digits.
 * 
 * 
 */
class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int n = Math.max(s.length(), t.length());
        for (int i = 0; i < n; i++)
            if (i < s.length() && i < t.length() && s.charAt(i) == t.charAt(i))
                continue;
            else
                return same(s, t, i, i+1) || same(s, t, i+1, i) || same(s, t, i+1, i+1);
        return false;
    }
    
    boolean same(String s, String t, int i, int j) {
        if (s.length()-i != t.length()-j)
            return false;
        while (i < s.length() && j < t.length() && s.charAt(i) == t.charAt(j)) {
            i++;
            j++;
        }
        return i == s.length() && j == t.length();
    }
}
