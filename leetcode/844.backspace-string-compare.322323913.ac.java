/*
 * @lc app=leetcode id=844 lang=java
 *
 * [844] Backspace String Compare
 *
 * https://leetcode.com/problems/backspace-string-compare/description/
 *
 * algorithms
 * Easy (46.77%)
 * Total Accepted:    256.2K
 * Total Submissions: 547.7K
 * Testcase Example:  '"ab#c"\n"ad#c"'
 *
 * Given two strings S and T, return if they are equal when both are typed into
 * empty text editors. # means a backspace character.
 * 
 * Note that after backspacing an empty text, the text will continue empty.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 * 
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S and T only contain lowercase letters and '#' characters.
 * 
 * 
 * Follow up:
 * 
 * 
 * Can you solve it in O(N) time and O(1) space?
 * 
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length();
        int j = T.length();
        int si = 0;
        int sj = 0;
        while (i >= 0 && j >= 0) {
            i--;
            j--;
            while (i >= 0 && (si > 0 || S.charAt(i) == '#')) {
                if (S.charAt(i) == '#') {
                    si++;
                } else {
                    si--;
                }
                i--;
            }
            while (j >= 0 && (sj > 0 || T.charAt(j) == '#')) {
                if (T.charAt(j) == '#') {
                    sj++;
                } else {
                    sj--;
                }
                j--;
            }
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j))
                    return false;
            }
        }
        return i < 0 && j < 0;
    }
}
