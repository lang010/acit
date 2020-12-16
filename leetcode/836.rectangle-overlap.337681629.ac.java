/*
 * @lc app=leetcode id=836 lang=java
 *
 * [836] Rectangle Overlap
 *
 * https://leetcode.com/problems/rectangle-overlap/description/
 *
 * algorithms
 * Easy (45.77%)
 * Total Accepted:    63.9K
 * Total Submissions: 139.5K
 * Testcase Example:  '[0,0,2,2]\n[1,1,3,3]'
 *
 * An axis-aligned rectangle is represented as a list [x1, y1, x2, y2], where
 * (x1, y1) is the coordinate of its bottom-left corner, and (x2, y2) is the
 * coordinate of its top-right corner. Its top and bottom edges are parallel to
 * the X-axis, and its left and right edges are parallel to the Y-axis.
 * 
 * Two rectangles overlap if the area of their intersection is positive. To be
 * clear, two rectangles that only touch at the corner or edges do not
 * overlap.
 * 
 * Given two axis-aligned rectangles rec1 and rec2, return true if they
 * overlap, otherwise return false.
 * 
 * 
 * Example 1:
 * Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
 * Output: true
 * Example 2:
 * Input: rec1 = [0,0,1,1], rec2 = [1,0,2,1]
 * Output: false
 * Example 3:
 * Input: rec1 = [0,0,1,1], rec2 = [2,2,3,3]
 * Output: false
 * 
 * 
 * Constraints:
 * 
 * 
 * rect1.length == 4
 * rect2.length == 4
 * -10^9 <= rec1[i], rec2[i] <= 10^9
 * rec1[0] <= rec1[2] and rec1[1] <= rec1[3]
 * rec2[0] <= rec2[2] and rec2[1] <= rec2[3]
 * 
 * 
 */
class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return check(rec1[0], rec1[2], rec2[0], rec2[2])
            && check(rec1[1], rec1[3], rec2[1], rec2[3]);
    }
    
    boolean check(int x0, int x1, int x2, int x3) {
        return !(x0 >= x3 || x2 >= x1);
    }
}
