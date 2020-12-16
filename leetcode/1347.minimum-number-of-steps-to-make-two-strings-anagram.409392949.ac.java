/*
 * @lc app=leetcode id=1347 lang=java
 *
 * [1347] Minimum Number of Steps to Make Two Strings Anagram
 *
 * https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/description/
 *
 * algorithms
 * Medium (75.37%)
 * Total Accepted:    39.7K
 * Total Submissions: 52.7K
 * Testcase Example:  '"bab"\n"aba"'
 *
 * Given two equal-size strings s and t. In one step you can choose any
 * character of t and replace it with another character.
 * 
 * Return the minimum number of steps to make t an anagram of s.
 * 
 * An Anagram of a string is a string that contains the same characters with a
 * different (or the same) ordering.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "bab", t = "aba"
 * Output: 1
 * Explanation: Replace the first 'a' in t with b, t = "bba" which is anagram
 * of s.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "leetcode", t = "practice"
 * Output: 5
 * Explanation: Replace 'p', 'r', 'a', 'i' and 'c' from t with proper
 * characters to make t anagram of s.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "anagram", t = "mangaar"
 * Output: 0
 * Explanation: "anagram" and "mangaar" are anagrams. 
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: s = "xxyyzz", t = "xxyyzz"
 * Output: 0
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: s = "friend", t = "family"
 * Output: 4
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 50000
 * s.length == t.length
 * s and t contain lower-case English letters only.
 * 
 * 
 */
class Solution {
    public int minSteps(String s, String t) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i)-'a']++;
            cnt[t.charAt(i)-'a']--;
        }
        int ans = 0;
        for (int x : cnt)
            if (x > 0)
                ans += x;
        return ans;
    }
}
