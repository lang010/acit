/*
 * @lc app=leetcode id=812 lang=java
 *
 * [812] Largest Triangle Area
 *
 * https://leetcode.com/problems/largest-triangle-area/description/
 *
 * algorithms
 * Easy (58.72%)
 * Total Accepted:    24.1K
 * Total Submissions: 41K
 * Testcase Example:  '[[0,0],[0,1],[1,0],[0,2],[2,0]]'
 *
 * You have a list of points in the plane. Return the area of the largest
 * triangle that can be formed by any 3 of the points.
 * 
 * 
 * Example:
 * Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
 * Output: 2
 * Explanation: 
 * The five points are show in the figure below. The red triangle is the
 * largest.
 * 
 * 
 * 
 * 
 * Notes: 
 * 
 * 
 * 3 <= points.length <= 50.
 * No points will be duplicated.
 * -50 <= points[i][j] <= 50.
 * Answers within 10^-6 of the true value will be accepted as correct.
 * 
 * 
 * 
 * 
 */
class Solution {
    public double largestTriangleArea(int[][] points) {
        double max = 0;
        int n = points.length;
        for (int i = 0; i < n; i++)
            for (int j = i+1; j < n; j++)
                for (int k = j+1; k < n; k++) {
                    max = Math.max(max, calc(points[i], points[j], points[k]));
                }
        return max;
    }
    
    double calc(int[] a, int[] b, int[] c) {
        return Math.abs(a[0]*b[1]+b[0]*c[1]+c[0]*a[1] - a[0]*c[1]-c[0]*b[1]-b[0]*a[1])*0.5;
    }
}
