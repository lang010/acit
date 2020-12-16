/*
 * @lc app=leetcode id=1037 lang=java
 *
 * [1037] Valid Boomerang
 *
 * https://leetcode.com/problems/valid-boomerang/description/
 *
 * algorithms
 * Easy (37.74%)
 * Total Accepted:    20.8K
 * Total Submissions: 55.2K
 * Testcase Example:  '[[1,1],[2,3],[3,2]]'
 *
 * A boomerang is a set of 3 points that are all distinct and not in a straight
 * line.
 * 
 * Given a list of three points in the plane, return whether these points are a
 * boomerang.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [[1,1],[2,3],[3,2]]
 * Output: true
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [[1,1],[2,2],[3,3]]
 * Output: false
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * points.length == 3
 * points[i].length == 2
 * 0 <= points[i][j] <= 100
 * 
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public boolean isBoomerang(int[][] points) {
        int a = points[1][0] - points[0][0];
        int b = points[1][1] - points[0][1];
        int c = points[2][0] - points[0][0];
        int d = points[2][1] - points[0][1];
        if (a*d == b*c)
            return false;
        return true;
    }
}
