/*
 * @lc app=leetcode id=1044 lang=java
 *
 * [1044] Longest Duplicate Substring
 *
 * https://leetcode.com/problems/longest-duplicate-substring/description/
 *
 * algorithms
 * Hard (31.76%)
 * Total Accepted:    31.7K
 * Total Submissions: 99.8K
 * Testcase Example:  '"banana"'
 *
 * Given a string s, consider all duplicated substrings: (contiguous)
 * substrings of s that occur 2 or more times. The occurrences may overlap.
 * 
 * Return any duplicated substring that has the longest possible length. If s
 * does not have a duplicated substring, the answer is "".
 * 
 * 
 * Example 1:
 * Input: s = "banana"
 * Output: "ana"
 * Example 2:
 * Input: s = "abcd"
 * Output: ""
 * 
 * 
 * Constraints:
 * 
 * 
 * 2 <= s.length <= 3 * 10^4
 * s consists of lowercase English letters.
 * 
 * 
 */
class Solution {
    public String longestDupSubstring(String S) {
        String ans = "";
        int l = 0, r = S.length() - 1;
        int st = -1;
        while (l < r) {
            int m = l + (r-l+1)/2;
            int beg = find(S, m);
            if (beg >= 0) {
                l = m;
                st = beg;
            } else
                r = m-1;
        }
        if (st < 0)
            return "";
        return S.substring(st, st+l);
    }
    
    long mod = 1l<<50;
    
    int find(String s, int len) {
        Set<Long> set = new HashSet<>();
        long cur = 0;
        for (int i = 0; i < len; i++)
            cur = (cur*26 + s.charAt(i) - 'a') % mod;
        set.add(cur);
        long factor = 1;
        for (int i = 0; i < len; i++)
            factor = (factor*26)%mod;
        int id = len;
        while (id < s.length()) {
            cur = (cur*26 - factor*(s.charAt(id-len) - 'a')%mod + mod + s.charAt(id) - 'a') % mod;
            if (set.contains(cur))
                return id - len + 1;
            set.add(cur);
            id++;
        }
        return -1;
    }
}
