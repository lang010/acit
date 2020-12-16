/*
 * @lc app=leetcode id=939 lang=java
 *
 * [939] Minimum Area Rectangle
 *
 * https://leetcode.com/problems/minimum-area-rectangle/description/
 *
 * algorithms
 * Medium (51.76%)
 * Total Accepted:    59.8K
 * Total Submissions: 115.5K
 * Testcase Example:  '[[1,1],[1,3],[3,1],[3,3],[2,2]]'
 *
 * Given a set of points in the xy-plane, determine the minimum area of a
 * rectangle formed from these points, with sides parallel to the x and y
 * axes.
 * 
 * If there isn't any rectangle, return 0.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [[1,1],[1,3],[3,1],[3,3],[2,2]]
 * Output: 4
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]
 * Output: 2
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= points.length <= 500
 * 0 <= points[i][0] <= 40000
 * 0 <= points[i][1] <= 40000
 * All points are distinct.
 * 
 * 
 * 
 */
class Solution {
    public int minAreaRect(int[][] points) {
        int N = 40001;
        Set<Integer> set = new HashSet<>();
        for (int[] x : points)
            set.add(x[0]*N+x[1]);
        int min = Integer.MAX_VALUE;
        for (int[] p1 : points)
            for (int[] p2 : points) {
                if (p1[0] < p2[0] && p1[1] < p2[1]) {
                    if (set.contains(p1[0]*N+p2[1])
                        && set.contains(p2[0]*N+p1[1]))
                        min = Math.min(min, (p2[0]-p1[0])*(p2[1]-p1[1]));
                }
            }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
