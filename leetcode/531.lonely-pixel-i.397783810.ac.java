/*
 * @lc app=leetcode id=531 lang=java
 *
 * [531] Lonely Pixel I
 *
 * https://leetcode.com/problems/lonely-pixel-i/description/
 *
 * algorithms
 * Medium (59.29%)
 * Total Accepted:    23.1K
 * Total Submissions: 39K
 * Testcase Example:  '[["W","W","B"],["W","B","W"],["B","W","W"]]'
 *
 * Given an m x n picture consisting of black 'B' and white 'W' pixels, return
 * the number of black lonely pixels.
 * 
 * A black lonely pixel is a character 'B' that located at a specific position
 * where the same row and same column don't have any other black pixels.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: picture = [["W","W","B"],["W","B","W"],["B","W","W"]]
 * Output: 3
 * Explanation: All the three 'B's are black lonely pixels.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: picture = [["B","B","B"],["B","B","B"],["B","B","B"]]
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == picture.length
 * n == picture[i].length
 * 1 <= m, n <= 500
 * picture[i][j] is 'W' or 'B'.
 * 
 * 
 */
class Solution {
    public int findLonelyPixel(char[][] picture) {
        int n = picture[0].length;
        int cnt = 0;
        int[] mem = new int[n];
        for (char[] r : picture) {
            int sum = 0;
            for (int i = 0; i < n; i++)
                if (r[i] == 'B') {
                    sum++;
                    mem[i]++;
                }
            if (sum == 1)
                cnt++;
        }
        int a = 0;
        for (int x : mem)
            if (x == 1)
                a++;
        return Math.min(a, cnt);
    }
}
