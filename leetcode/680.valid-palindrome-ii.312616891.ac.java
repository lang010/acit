/*
 * @lc app=leetcode id=680 lang=java
 *
 * [680] Valid Palindrome II
 *
 * https://leetcode.com/problems/valid-palindrome-ii/description/
 *
 * algorithms
 * Easy (36.92%)
 * Total Accepted:    220.6K
 * Total Submissions: 597.4K
 * Testcase Example:  '"aba"'
 *
 * 
 * Given a non-empty string s, you may delete at most one character.  Judge
 * whether you can make it a palindrome.
 * 
 * 
 * Example 1:
 * 
 * Input: "aba"
 * Output: True
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * 
 * 
 * 
 * Note:
 * 
 * The string will only contain lowercase characters a-z.
 * The maximum length of the string is 50000.
 * 
 * 
 */
class Solution {
    public boolean validPalindrome(String s) {
        int[] edge = palindrome(s, 0, s.length()-1);
        if (edge == null)
            return true;
        if (palindrome(s, edge[0] + 1, edge[1]) != null)
            return palindrome(s, edge[0], edge[1]-1) == null;
        return true;
    }
    
    int[] palindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return new int[] {l, r};
            l++;
            r--;
        }
        return null;
    }
}
