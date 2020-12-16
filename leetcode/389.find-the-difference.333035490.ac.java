/*
 * @lc app=leetcode id=389 lang=java
 *
 * [389] Find the Difference
 *
 * https://leetcode.com/problems/find-the-difference/description/
 *
 * algorithms
 * Easy (57.55%)
 * Total Accepted:    243.6K
 * Total Submissions: 423.2K
 * Testcase Example:  '"abcd"\n"abcde"'
 *
 * You are given two strings s and t.
 * 
 * String t is generated by random shuffling string s and then add one more
 * letter at a random position.
 * 
 * Return the letter that was added to t.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "abcd", t = "abcde"
 * Output: "e"
 * Explanation: 'e' is the letter that was added.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "", t = "y"
 * Output: "y"
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "a", t = "aa"
 * Output: "a"
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: s = "ae", t = "aea"
 * Output: "a"
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= s.length <= 1000
 * t.length == s.length + 1
 * s and t consist of lower-case English letters.
 * 
 * 
 */
class Solution {
    public char findTheDifference(String s, String t) {
        char ans = 0;
        for (char c : s.toCharArray())
            ans ^= c;
        for (char c : t.toCharArray())
            ans ^= c;
        return ans;
    }
}