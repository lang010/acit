/*
 * @lc app=leetcode id=1405 lang=java
 *
 * [1405] Longest Happy String
 *
 * https://leetcode.com/problems/longest-happy-string/description/
 *
 * algorithms
 * Medium (52.02%)
 * Total Accepted:    15.4K
 * Total Submissions: 29.6K
 * Testcase Example:  '1\n1\n7'
 *
 * A string is called happy if it does not have any of the strings 'aaa', 'bbb'
 * or 'ccc' as a substring.
 * 
 * Given three integers a, b and c, return any string s, which satisfies
 * following conditions:
 * 
 * 
 * s is happy and longest possible.
 * s contains at most a occurrences of the letter 'a', at most b occurrences of
 * the letter 'b' and at most c occurrences of the letter 'c'.
 * s will only contain 'a', 'b' and 'c' letters.
 * 
 * 
 * If there is no such string s return the empty string "".
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: a = 1, b = 1, c = 7
 * Output: "ccaccbcc"
 * Explanation: "ccbccacc" would also be a correct answer.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: a = 2, b = 2, c = 1
 * Output: "aabbc"
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: a = 7, b = 1, c = 0
 * Output: "aabaa"
 * Explanation: It's the only correct answer in this case.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= a, b, c <= 100
 * a + b + c > 0
 * 
 * 
 */
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        char[][] chs = { {(char)a, 'a'}, {(char)b, 'b'}, {(char)c, 'c'}};
        helper(chs, sb);
        return sb.toString();
    }
    
    void helper(char[][] chs, StringBuilder sb) {
        Arrays.sort(chs, (a, b) -> b[0] - a[0]);
        if (chs[0][0] == chs[1][0] && chs[1][0] == chs[2][0]) {
            for (int i = 0; i < chs[0][0]; i++)
                sb.append("abc");
            return;
        }
        if (chs[0][0] == chs[1][0]) {
            sb.append(chs[0][1]);
            sb.append(chs[1][1]);
            chs[0][0]--;
            chs[1][0]--;
            helper(chs, sb);
            return;
        }
        if (chs[1][0] == 0) {
            for (int i = 0; i < Math.min(chs[0][0], 2); i++)
                sb.append(chs[0][1]);
            return;
        }
        sb.append(chs[0][1]).append(chs[0][1]);
        sb.append(chs[1][1]);
        chs[0][0] -= 2;
        chs[1][0]--;
        helper(chs, sb);
        return;
    }
}
