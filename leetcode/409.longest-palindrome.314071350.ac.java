/*
 * @lc app=leetcode id=409 lang=java
 *
 * [409] Longest Palindrome
 *
 * https://leetcode.com/problems/longest-palindrome/description/
 *
 * algorithms
 * Easy (52.05%)
 * Total Accepted:    186.2K
 * Total Submissions: 357.8K
 * Testcase Example:  '"abccccdd"'
 *
 * Given a string s which consists of lowercase or uppercase letters, return
 * the length of the longest palindrome that can be built with those letters.
 * 
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome
 * here.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "abccccdd"
 * Output: 7
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "a"
 * Output: 1
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "bb"
 * Output: 2
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 2000
 * s consists of lowercase and/or uppercase English letters only.
 * 
 * 
 */
class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int ans = 0;
        for (char c : map.keySet()) {
            int cnt = map.get(c);
            ans += cnt/2;
        }
        ans *= 2;
        if (ans < s.length())
            ans++;
        
        return ans;
    }
}
