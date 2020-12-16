/*
 * @lc app=leetcode id=1062 lang=java
 *
 * [1062] Longest Repeating Substring
 *
 * https://leetcode.com/problems/longest-repeating-substring/description/
 *
 * algorithms
 * Medium (57.86%)
 * Total Accepted:    16K
 * Total Submissions: 27.6K
 * Testcase Example:  '"abcd"'
 *
 * Given a string S, find out the length of the longest repeating substring(s).
 * Return 0 if no repeating substring exists.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: S = "abcd"
 * Output: 0
 * Explanation: There is no repeating substring.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: S = "abbaba"
 * Output: 2
 * Explanation: The longest repeating substrings are "ab" and "ba", each of
 * which occurs twice.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: S = "aabcaabdaab"
 * Output: 3
 * Explanation: The longest repeating substring is "aab", which occurs 3
 * times.
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: S = "aaaaa"
 * Output: 4
 * Explanation: The longest repeating substring is "aaaa", which occurs
 * twice.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The string S consists of only lowercase English letters from 'a' - 'z'.
 * 1 <= S.length <= 1500
 * 
 * 
 */
class Solution {
    public int longestRepeatingSubstring(String S) {
        int l = 0, r = S.length()-1;
        while (l <= r) {
            int m = l+(r-l)/2;
            if (check(S, m)) {
                l = m+1;
            } else
                r = m-1;
        }
        return l-1;
    }
    
    long max = 1000000007l;
    
    boolean check(String s, int l) {
        Set<Long> set = new HashSet<>();
        long k = 0;
        long v = 1;
        for (int i = 0; i < l; i++)
            v = (v*29)%max;
        for (int i = 0; i < s.length(); i++) {
            k = (k*29+(s.charAt(i)-'a')) % max;
            if (i >= l) {
                k = (k-(v*(s.charAt(i-l)-'a'))%max + max)%max;
            }
            if (set.contains(k))
                return true;
            if (i >= l-1) 
                set.add(k);
        }
        return false;
    }
}
