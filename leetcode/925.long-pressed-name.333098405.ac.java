/*
 * @lc app=leetcode id=925 lang=java
 *
 * [925] Long Pressed Name
 *
 * https://leetcode.com/problems/long-pressed-name/description/
 *
 * algorithms
 * Easy (38.76%)
 * Total Accepted:    55.8K
 * Total Submissions: 143.9K
 * Testcase Example:  '"alex"\n"aaleex"'
 *
 * Your friend is typing his name into a keyboard. Sometimes, when typing a
 * character c, the key might get long pressed, and the character will be typed
 * 1 or more times.
 * 
 * You examine the typed characters of the keyboard. Return True if it is
 * possible that it was your friends name, with some characters (possibly none)
 * being long pressed.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: name = "alex", typed = "aaleex"
 * Output: true
 * Explanation: 'a' and 'e' in 'alex' were long pressed.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: name = "saeed", typed = "ssaaedd"
 * Output: false
 * Explanation: 'e' must have been pressed twice, but it wasn't in the typed
 * output.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: name = "leelee", typed = "lleeelee"
 * Output: true
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: name = "laiden", typed = "laiden"
 * Output: true
 * Explanation: It's not necessary to long press any character.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= name.length <= 1000
 * 1 <= typed.length <= 1000
 * name and typed contain only lowercase English letters.
 * 
 * 
 */
class Solution {
    public boolean isLongPressedName(String s1, String s2) {
        int l = s1.length()-1;
        int r = s2.length()-1;
        while (l >= 0 && r >= 0) {
            if (s1.charAt(l--) != s2.charAt(r--))
                return false;
            int lc = 1;
            int rc = 1;
            while (l >= 0 && s1.charAt(l) == s1.charAt(l+1)) {
                l--;
                lc++;
            }
            while (r >= 0 && s2.charAt(r) == s2.charAt(r+1)) {
                r--;
                rc++;
            }
            if (lc > rc)
                return false;
        }
        return l < 0 && r < 0;
    }
}
