/*
 * @lc app=leetcode id=838 lang=java
 *
 * [838] Push Dominoes
 *
 * https://leetcode.com/problems/push-dominoes/description/
 *
 * algorithms
 * Medium (49.41%)
 * Total Accepted:    24.9K
 * Total Submissions: 50.4K
 * Testcase Example:  '".L.R...LR..L.."'
 *
 * There are N dominoes in a line, and we place each domino vertically
 * upright.
 * 
 * In the beginning, we simultaneously push some of the dominoes either to the
 * left or to the right.
 * 
 * 
 * 
 * After each second, each domino that is falling to the left pushes the
 * adjacent domino on the left.
 * 
 * Similarly, the dominoes falling to the right push their adjacent dominoes
 * standing on the right.
 * 
 * When a vertical domino has dominoes falling on it from both sides, it stays
 * still due to the balance of the forces.
 * 
 * For the purposes of this question, we will consider that a falling domino
 * expends no additional force to a falling or already fallen domino.
 * 
 * Given a string "S" representing the initial state. S[i] = 'L', if the i-th
 * domino has been pushed to the left; S[i] = 'R', if the i-th domino has been
 * pushed to the right; S[i] = '.', if the i-th domino has not been pushed.
 * 
 * Return a string representing the final state. 
 * 
 * Example 1:
 * 
 * 
 * Input: ".L.R...LR..L.."
 * Output: "LL.RR.LLRRLL.."
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "RR.L"
 * Output: "RR.L"
 * Explanation: The first domino expends no additional force on the second
 * domino.
 * 
 * 
 * Note:
 * 
 * 
 * 0 <= N <= 10^5
 * String dominoes contains only 'L', 'R' and '.'
 * 
 * 
 */
class Solution {
    public String pushDominoes(String dominoes) {
        StringBuilder sb = new StringBuilder();
        int l = 0;
        int n = dominoes.length();
        for (int i = 0; i < n; i++)
            sb.append('.');
        for (int i = 0; i < n; i++) {
            char c = dominoes.charAt(i);
            if (c == 'L')
                while (l <= i)
                    sb.setCharAt(l++, 'L');
            else if (c == 'R') {
                l = i;
                int r = i+1;
                while (r < n && dominoes.charAt(r) == '.')
                    r++;
                if (r == n || dominoes.charAt(r) == 'R') {
                    for (int j = l; j < r; j++)
                        sb.setCharAt(j, 'R');
                    i = r-1;
                } else {
                    i = r;
                    while (l < r) {
                        sb.setCharAt(l++, 'R');
                        sb.setCharAt(r--, 'L');
                    }
                }
                l = i+1;
            }
        }
        return sb.toString();
    }
}
