/*
 * @lc app=leetcode id=1401 lang=java
 *
 * [1401] Circle and Rectangle Overlapping
 *
 * https://leetcode.com/problems/circle-and-rectangle-overlapping/description/
 *
 * algorithms
 * Medium (42.31%)
 * Total Accepted:    6.7K
 * Total Submissions: 15.8K
 * Testcase Example:  '1\n0\n0\n1\n-1\n3\n1'
 *
 * Given a circle represented as (radius, x_center, y_center) and an
 * axis-aligned rectangle represented as (x1, y1, x2, y2), where (x1, y1) are
 * the coordinates of the bottom-left corner, and (x2, y2) are the coordinates
 * of the top-right corner of the rectangle.
 * 
 * Return True if the circle and rectangle are overlapped otherwise return
 * False.
 * 
 * In other words, check if there are any point (xi, yi) such that belongs to
 * the circle and the rectangle at the same time.
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: radius = 1, x_center = 0, y_center = 0, x1 = 1, y1 = -1, x2 = 3, y2 =
 * 1
 * Output: true
 * Explanation: Circle and rectangle share the point (1,0) 
 * 
 * 
 * Example 2:
 * 
 * 
 * 
 * 
 * Input: radius = 1, x_center = 0, y_center = 0, x1 = -1, y1 = 0, x2 = 0, y2 =
 * 1
 * Output: true
 * 
 * 
 * Example 3:
 * 
 * 
 * 
 * 
 * Input: radius = 1, x_center = 1, y_center = 1, x1 = -3, y1 = -3, x2 = 3, y2
 * = 3
 * Output: true
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: radius = 1, x_center = 1, y_center = 1, x1 = 1, y1 = -3, x2 = 2, y2 =
 * -1
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= radius <= 2000
 * -10^4 <= x_center, y_center, x1, y1, x2, y2 <= 10^4
 * x1 < x2
 * y1 < y2
 * 
 * 
 */
class Solution {
    public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
        int w = x2 - x1;
        int h = y2 - y1;
        int dx2 = Math.abs(x1+x2 - 2*x_center);
        int dy2 = Math.abs(y1+y2 - 2*y_center);
        if (y1 <= y_center && y_center <= y2 && dx2 <= w + radius*2
            || x1 <= x_center && x_center <= x2 && dy2 <= h + radius*2)
            return true;
        if (dist(x_center, y_center, x1, y1) <= radius
            || dist(x_center, y_center, x2, y2) <= radius
            || dist(x_center, y_center, x1, y2) <= radius
            || dist(x_center, y_center, x2, y1) <= radius)
            return true;
        return false;
    }
    
    double dist(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
    }
}
