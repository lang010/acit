/*
 * @lc app=leetcode id=1638 lang=java
 *
 * [1638] Count Substrings That Differ by One Character
 *
 * https://leetcode.com/problems/count-substrings-that-differ-by-one-character/description/
 *
 * algorithms
 * Medium (67.45%)
 * Total Accepted:    5K
 * Total Submissions: 7.4K
 * Testcase Example:  '"aba"\n"baba"'
 *
 * Given two strings s and t, find the number of ways you can choose a
 * non-empty substring of s and replace a single character by a different
 * character such that the resulting substring is a substring of t. In other
 * words, find the number of substrings in s that differ from some substring in
 * t by exactly one character.
 * 
 * For example, the underlined substrings in "computer" and "computation" only
 * differ by the 'e'/'a', so this is a valid way.
 * 
 * Return the number of substrings that satisfy the condition above.
 * 
 * A substring is a contiguous sequence of characters within a string.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "aba", t = "baba"
 * Output: 6
 * Explanation: The following are the pairs of substrings from s and t that
 * differ by exactly 1 character:
 * ("aba", "baba")
 * ("aba", "baba")
 * ("aba", "baba")
 * ("aba", "baba")
 * ("aba", "baba")
 * ("aba", "baba")
 * The underlined portions are the substrings that are chosen from s and t.
 * 
 * ​​Example 2:
 * 
 * 
 * Input: s = "ab", t = "bb"
 * Output: 3
 * Explanation: The following are the pairs of substrings from s and t that
 * differ by 1 character:
 * ("ab", "bb")
 * ("ab", "bb")
 * ("ab", "bb")
 * ​​​​The underlined portions are the substrings that are chosen from s and
 * t.
 * 
 * Example 3:
 * 
 * 
 * Input: s = "a", t = "a"
 * Output: 0
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: s = "abe", t = "bbc"
 * Output: 10
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length, t.length <= 100
 * s and t consist of lowercase English letters only.
 * 
 * 
 */
class Solution {
    public int countSubstrings(String s, String t) {
        int ans = 0;
        int n = s.length();
        int m = t.length();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (s.charAt(i) == t.charAt(j)) {
                    int c = 1;
                    boolean is = false;
                    while (i+c < n && j+c < m) {
                        if (s.charAt(i+c) != t.charAt(j+c)) {
                            if (is)
                                break;
                            is = true;
                            ans++;
                        } else if (is)
                            ans++;
                        c++;
                    }
                } else {
                    int c = 1;
                    ans++;
                    while (i+c < n && j+c < m) {
                        if (s.charAt(i+c) == t.charAt(j+c)) {
                            ans++;
                        } else
                            break;
                        c++;
                    }
                }
        return ans;
    }
}
