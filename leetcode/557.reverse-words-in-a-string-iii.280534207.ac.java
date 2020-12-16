/*
 * @lc app=leetcode id=557 lang=java
 *
 * [557] Reverse Words in a String III
 *
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/description/
 *
 * algorithms
 * Easy (71.28%)
 * Total Accepted:    232.4K
 * Total Submissions: 326K
 * Testcase Example:  `"Let's take LeetCode contest"`
 *
 * Given a string, you need to reverse the order of characters in each word
 * within a sentence while still preserving whitespace and initial word order.
 * 
 * Example 1:
 * 
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * 
 * 
 * 
 * Note:
 * In the string, each word is separated by single space and there will not be
 * any extra space in the string.
 * 
 */
class Solution {
    public String reverseWords(String s) {
        char[] ls = s.toCharArray();
        int l = 0, r;
        for (r = 0; r < ls.length; r++) {
            if (ls[r] == ' ') {
                swap(ls, l, r-1);
                l = r+1;
            }
        }
        swap(ls, l, r-1);
        return new String(ls);
    }
    void swap(char[] ls, int l, int r) {
        while (l < r) {
            char x = ls[l];
            ls[l] = ls[r];
            ls[r] = x;
            l++;
            r--;
        }
    }
}
