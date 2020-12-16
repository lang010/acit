/*
 * @lc app=leetcode id=1128 lang=java
 *
 * [1128] Number of Equivalent Domino Pairs
 *
 * https://leetcode.com/problems/number-of-equivalent-domino-pairs/description/
 *
 * algorithms
 * Easy (46.65%)
 * Total Accepted:    29.2K
 * Total Submissions: 62.7K
 * Testcase Example:  '[[1,2],[2,1],[3,4],[5,6]]'
 *
 * Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j]
 * = [c, d] if and only if either (a==c and b==d), or (a==d and b==c) - that
 * is, one domino can be rotated to be equal to another domino.
 * 
 * Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length,
 * and dominoes[i] is equivalent to dominoes[j].
 * 
 * 
 * Example 1:
 * Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
 * Output: 1
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= dominoes.length <= 40000
 * 1 <= dominoes[i][j] <= 9
 * 
 */
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int ans = 0;
        int[] cnt = new int[100];
        for(int[] d : dominoes)
            cnt[Math.min(d[0], d[1]) * 10 + Math.max(d[0], d[1])]++;
        for (int x : cnt)
            ans += x*(x-1)/2;
        return ans;
    }
}
