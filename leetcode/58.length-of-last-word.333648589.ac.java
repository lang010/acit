/*
 * @lc app=leetcode id=58 lang=java
 *
 * [58] Length of Last Word
 *
 * https://leetcode.com/problems/length-of-last-word/description/
 *
 * algorithms
 * Easy (33.32%)
 * Total Accepted:    452.5K
 * Total Submissions: 1.4M
 * Testcase Example:  '"Hello World"'
 *
 * Given a string s consists of some words separated by spaces, return the
 * length of the last word in the string. If the last word does not exist,
 * return 0.
 * 
 * A word is a maximal substring consisting of non-space characters only.
 * 
 * 
 * Example 1:
 * Input: s = "Hello World"
 * Output: 5
 * Example 2:
 * Input: s = " "
 * Output: 0
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^4
 * s consists of only English letters and spaces ' '.
 * 
 * 
 */
class Solution {
    public int lengthOfLastWord(String s) {
        String[] ls = s.split(" ");
        for (int i = ls.length-1; i >= 0; i--)
            if (ls[i].length() > 0)
                return ls[i].length();
        return 0;
    }
}
