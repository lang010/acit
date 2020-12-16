/*
 * @lc app=leetcode id=1585 lang=java
 *
 * [1585] Check If String Is Transformable With Substring Sort Operations
 *
 * https://leetcode.com/problems/check-if-string-is-transformable-with-substring-sort-operations/description/
 *
 * algorithms
 * Hard (48.01%)
 * Total Accepted:    4.2K
 * Total Submissions: 8.7K
 * Testcase Example:  '"84532"\n"34852"'
 *
 * Given two strings s and t, you want to transform string s into string t
 * using the following operation any number of times:
 * 
 * 
 * Choose a non-empty substring in s and sort it in-place so the characters are
 * in ascending order.
 * 
 * 
 * For example, applying the operation on the underlined substring in "14234"
 * results in "12344".
 * 
 * Return true if it is possible to transform string s into string t.
 * Otherwise, return false.
 * 
 * A substring is a contiguous sequence of characters within a string.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "84532", t = "34852"
 * Output: true
 * Explanation: You can transform s into t using the following sort operations:
 * "84532" (from index 2 to 3) -> "84352"
 * "84352" (from index 0 to 2) -> "34852"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "34521", t = "23415"
 * Output: true
 * Explanation: You can transform s into t using the following sort operations:
 * "34521" -> "23451"
 * "23451" -> "23415"
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "12345", t = "12435"
 * Output: false
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: s = "1", t = "2"
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * s.length == t.length
 * 1 <= s.length <= 10^5
 * s and t only contain digits from '0' to '9'.
 * 
 * 
 */
class Solution {
    public boolean isTransformable(String s, String t) {
        char[] sl = s.toCharArray();
        char[] tl = t.toCharArray();
        int[] pos = new int[256];
        for (char c : sl)
            pos[c]++;
        for (char c : tl)
            pos[c]--;
        for (char c = '0'; c <= '9'; c++)
            if (pos[c] != 0)
                return false;
        int n = sl.length;
        int[] vi = new int[n];
        for (char c : tl) {
            while (!(vi[pos[c]] == 0 && sl[pos[c]] == c)) {
                if (vi[pos[c]] == 0 && sl[pos[c]] < c)
                    return false;
                pos[c]++;
            }
            vi[pos[c]] = 1;
            pos[c]++;
        }
        return true;
    }
}
