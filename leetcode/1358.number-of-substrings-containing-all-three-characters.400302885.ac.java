/*
 * @lc app=leetcode id=1358 lang=java
 *
 * [1358] Number of Substrings Containing All Three Characters
 *
 * https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/
 *
 * algorithms
 * Medium (60.12%)
 * Total Accepted:    17.6K
 * Total Submissions: 29.3K
 * Testcase Example:  '"abcabc"'
 *
 * Given a string s consisting only of characters a, b and c.
 * 
 * Return the number of substrings containing at least one occurrence of all
 * these characters a, b and c.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "abcabc"
 * Output: 10
 * Explanation: The substrings containing at least one occurrence of the
 * characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab",
 * "bcabc", "cab", "cabc" and "abc" (again). 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "aaacb"
 * Output: 3
 * Explanation: The substrings containing at least one occurrence of the
 * characters a, b and c are "aaacb", "aacb" and "acb". 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "abc"
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 3 <= s.length <= 5 x 10^4
 * s only consists of a, b or c characters.
 * 
 * 
 */
class Solution {
    public int numberOfSubstrings(String s) {
        int l = 0, ans = 0;
        int[] cnt = new int[3];
        for (char c : s.toCharArray()) {
            cnt[c-'a']++;
            while (cnt[0] > 0 && cnt[1] > 0 && cnt[2] > 0)
                cnt[s.charAt(l++)-'a']--;
            ans += l;
        }
        return ans;
    }
}
