/*
 * @lc app=leetcode id=1163 lang=java
 *
 * [1163] Last Substring in Lexicographical Order
 *
 * https://leetcode.com/problems/last-substring-in-lexicographical-order/description/
 *
 * algorithms
 * Hard (36.07%)
 * Total Accepted:    20.3K
 * Total Submissions: 56.3K
 * Testcase Example:  '"abab"\r'
 *
 * Given a string s, return the last substring of s in lexicographical
 * order.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "abab"
 * Output: "bab"
 * Explanation: The substrings are ["a", "ab", "aba", "abab", "b", "ba",
 * "bab"]. The lexicographically maximum substring is "bab".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "leetcode"
 * Output: "tcode"
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= s.length <= 4 * 10^5
 * s contains only lowercase English letters.
 * 
 * 
 */
class Solution {
    public String lastSubstring(String s) {
        char[] chs = s.toCharArray();
        int n = chs.length;
        int b = 0;
        for (int i = 1; i < n; i++) {
            for (int k = 0; k+i < n; k++) {
                if (chs[i+k] == chs[b+k])
                    if (i+k == n-1) {
                        i = n;
                        break;
                    } else
                        continue;
                if (chs[i+k] > chs[b+k]) {
                    b = Math.max(b+k-1, i);
                } else {
                    i += Math.max(0, k-1);
                }
                break;
            }
        }
        
        return s.substring(b);
    }
}
