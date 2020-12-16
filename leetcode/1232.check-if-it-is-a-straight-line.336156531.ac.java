/*
 * @lc app=leetcode id=1232 lang=java
 *
 * [1232] Check If It Is a Straight Line
 *
 * https://leetcode.com/problems/check-if-it-is-a-straight-line/description/
 *
 * algorithms
 * Easy (44.15%)
 * Total Accepted:    86.6K
 * Total Submissions: 196.2K
 * Testcase Example:  '[[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]'
 *
 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y]
 * represents the coordinate of a point. Check if these points make a straight
 * line in the XY plane.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * 
 * 
 * Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 2 <= coordinates.length <= 1000
 * coordinates[i].length == 2
 * -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
 * coordinates contains no duplicate point.
 * 
 * 
 */
class Solution {
    public boolean checkStraightLine(int[][] cs) {
        int a = cs[1][0] - cs[0][0];
        int b = cs[1][1] - cs[0][1];
        for (int i = 2; i < cs.length; i++)
            if (b * (cs[i][0] - cs[0][0]) != a * (cs[i][1] - cs[0][1]))
                return false;
        return true;
    }
}
