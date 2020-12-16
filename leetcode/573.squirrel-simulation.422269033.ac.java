/*
 * @lc app=leetcode id=573 lang=java
 *
 * [573] Squirrel Simulation
 *
 * https://leetcode.com/problems/squirrel-simulation/description/
 *
 * algorithms
 * Medium (55.85%)
 * Total Accepted:    8.3K
 * Total Submissions: 14.8K
 * Testcase Example:  '5\n7\n[2,2]\n[4,4]\n[[3,0], [2,5]]'
 *
 * There's a tree, a squirrel, and several nuts. Positions are represented by
 * the cells in a 2D grid. Your goal is to find the minimal distance for the
 * squirrel to collect all the nuts and put them under the tree one by one. The
 * squirrel can only take at most one nut at one time and can move in four
 * directions - up, down, left and right, to the adjacent cell. The distance is
 * represented by the number of moves.
 * Example 1:
 * 
 * 
 * Input: 
 * Height : 5
 * Width : 7
 * Tree position : [2,2]
 * Squirrel : [4,4]
 * Nuts : [[3,0], [2,5]]
 * Output: 12
 * Explanation:
 * ​​​​​
 * 
 * 
 * Note:
 * 
 * 
 * All given positions won't overlap.
 * The squirrel can take at most one nut at one time.
 * The given positions of nuts have no order.
 * Height and width are positive integers. 3 <= height * width <= 10,000.
 * The given positions contain at least one nut, only one tree and one
 * squirrel.
 * 
 * 
 */
class Solution {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int n = nuts.length;
        int sum = 0, max = -width-height;
        for (int[] nut : nuts) {
            int d1 = Math.abs(tree[0] - nut[0]) + Math.abs(tree[1] - nut[1]);
            int d2 = Math.abs(squirrel[0] - nut[0]) + Math.abs(squirrel[1] - nut[1]);
            sum += d1*2;
            max = Math.max(max, d1 - d2);
        }
        return sum - max;
    }
}
