/*
 * @lc app=leetcode id=266 lang=java
 *
 * [266] Palindrome Permutation
 *
 * https://leetcode.com/problems/palindrome-permutation/description/
 *
 * algorithms
 * Easy (62.37%)
 * Total Accepted:    102.9K
 * Total Submissions: 164.9K
 * Testcase Example:  '"code"'
 *
 * Given a string, determine if a permutation of the string could form a
 * palindrome.
 * 
 * Example 1:
 * 
 * 
 * Input: "code"
 * Output: false
 * 
 * Example 2:
 * 
 * 
 * Input: "aab"
 * Output: true
 * 
 * Example 3:
 * 
 * 
 * Input: "carerac"
 * Output: true
 * 
 */
class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] cnt = new int[256];
        for (char c : s.toCharArray())
            cnt[c]++;
        int t = 0;
        for (int x : cnt)
            t += x%2;
        return t < 2;
    }
}
