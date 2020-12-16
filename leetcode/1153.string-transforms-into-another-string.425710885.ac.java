/*
 * @lc app=leetcode id=1153 lang=java
 *
 * [1153] String Transforms Into Another String
 *
 * https://leetcode.com/problems/string-transforms-into-another-string/description/
 *
 * algorithms
 * Hard (36.03%)
 * Total Accepted:    27.4K
 * Total Submissions: 76.2K
 * Testcase Example:  '"aabcc"\n"ccdee"'
 *
 * Given two strings str1 and str2 of the same length, determine whether you
 * can transform str1 into str2 by doing zero or more conversions.
 * 
 * In one conversion you can convert all occurrences of one character in str1
 * to any other lowercase English character.
 * 
 * Return true if and only if you can transform str1 into str2.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: str1 = "aabcc", str2 = "ccdee"
 * Output: true
 * Explanation: Convert 'c' to 'e' then 'b' to 'd' then 'a' to 'c'. Note that
 * the order of conversions matter.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: str1 = "leetcode", str2 = "codeleet"
 * Output: false
 * Explanation: There is no way to transform str1 to str2.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= str1.length == str2.length <= 10^4
 * str1 and str2 contain only lowercase English letters.
 * 
 * 
 */
class Solution {
    public boolean canConvert(String str1, String str2) {
        if (str1.equals(str2))
            return true;
        char[] map = new char[256];
        for (int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            if (map[c1] == 0)
                map[c1] = c2;
            if (map[c1] != c2)
                return false;
        }
        int val = 0;
        for (char c = 'a'; c <= 'z'; c++) 
            if (map[c] != 0)
                val |= 1<<(map[c] - 'a');
        return val != ((1<<26)-1);
    }
}
