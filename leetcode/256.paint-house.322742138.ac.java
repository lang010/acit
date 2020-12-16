/*
 * @lc app=leetcode id=256 lang=java
 *
 * [256] Paint House
 *
 * https://leetcode.com/problems/paint-house/description/
 *
 * algorithms
 * Medium (52.97%)
 * Total Accepted:    98.7K
 * Total Submissions: 186.4K
 * Testcase Example:  '[[17,2,17],[16,16,5],[14,3,19]]'
 *
 * There is a row of n houses, where each house can be painted one of three
 * colors: red, blue, or green. The cost of painting each house with a certain
 * color is different. You have to paint all the houses such that no two
 * adjacent houses have the same color.
 * 
 * The cost of painting each house with a certain color is represented by a n x
 * 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with
 * the color red; costs[1][2] is the cost of painting house 1 with color green,
 * and so on... Find the minimum cost to paint all houses.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: costs = [[17,2,17],[16,16,5],[14,3,19]]
 * Output: 10
 * Explanation: Paint house 0 into blue, paint house 1 into green, paint house
 * 2 into blue.
 * Minimum cost: 2 + 5 + 3 = 10.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: costs = []
 * Output: 0
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: costs = [[7,6,2]]
 * Output: 2
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * costs.length == n
 * costs[i].length == 3
 * 0 <= n <= 100
 * 1 <= costs[i][j] <= 20
 * 
 * 
 */
class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length < 1)
            return 0;
        int s1 = costs[0][0];
        int s2 = costs[0][1];
        int s3 = costs[0][2];
        for (int i = 1; i < costs.length; i++) {
            int p1 = s1, p2 = s2, p3 = s3;
            s1 = Math.min(p2, p3) + costs[i][0];
            s2 = Math.min(p1, p3) + costs[i][1];
            s3 = Math.min(p1, p2) + costs[i][2];
        }
        
        return Math.min(s1, Math.min(s2, s3));
    }
}
