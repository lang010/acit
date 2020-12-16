/*
 * @lc app=leetcode id=1446 lang=java
 *
 * [1446] Consecutive Characters
 *
 * https://leetcode.com/problems/consecutive-characters/description/
 *
 * algorithms
 * Easy (61.31%)
 * Total Accepted:    57.8K
 * Total Submissions: 94.3K
 * Testcase Example:  '"leetcode"'
 *
 * Given a string s, the power of the string is the maximum length of a
 * non-empty substring that contains only one unique character.
 * 
 * Return the power of the string.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "leetcode"
 * Output: 2
 * Explanation: The substring "ee" is of length 2 with the character 'e'
 * only.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "abbcccddddeeeeedcba"
 * Output: 5
 * Explanation: The substring "eeeee" is of length 5 with the character 'e'
 * only.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "triplepillooooow"
 * Output: 5
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: s = "hooraaaaaaaaaaay"
 * Output: 11
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: s = "tourist"
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 500
 * s contains only lowercase English letters.
 * 
 */
class Solution {
    public int maxPower(String s) {
        int max = 0;
        int cur = 0;
        char pre = 0;
        for (char c : s.toCharArray()) {
            if (pre == c) {
                cur++;
            } else {
                pre = c;
                cur = 1;
            }
            max = Math.max(max, cur);
        }
        
        return max;
    }
}
