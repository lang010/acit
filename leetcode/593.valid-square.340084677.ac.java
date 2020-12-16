/*
 * @lc app=leetcode id=593 lang=java
 *
 * [593] Valid Square
 *
 * https://leetcode.com/problems/valid-square/description/
 *
 * algorithms
 * Medium (43.31%)
 * Total Accepted:    56.1K
 * Total Submissions: 129.5K
 * Testcase Example:  '[0,0]\n[1,1]\n[1,0]\n[0,1]'
 *
 * Given the coordinates of four points in 2D space p1, p2, p3 and p4, return
 * true if the four points construct a square.
 * 
 * The coordinate of a point pi is represented as [xi, yi]. The input is not
 * given in any order.
 * 
 * A valid square has four equal sides with positive length and four equal
 * angles (90-degree angles).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,12]
 * Output: false
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: p1 = [1,0], p2 = [-1,0], p3 = [0,1], p4 = [0,-1]
 * Output: true
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * p1.length == p2.length == p3.length == p4.length == 2
 * -10^4 <= xi, yi <= 10^4
 * 
 * 
 */
class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        if (p1[0] == p2[0] && p2[0] == p3[0] && p3[0] == p4[0]
           && p1[1] == p2[1] && p2[1] == p3[1] && p3[1] == p4[1])
            return false;
        return check(p1, p2, p3, p4) || check(p1, p3, p2, p4)
            || check(p1, p4, p2, p3);
    }
    
    boolean check(int[] p1, int[] p2, int[] p3, int[] p4) {
        int x = p1[0] + p2[0];
        int y = p1[1] + p2[1];
        if (x != p3[0] + p4[0] || y != p3[1] + p4[1])
            return false;
        int[] v1 = {p3[0]-p1[0], p3[1]-p1[1]};
        int[] v2 = {p4[0]-p1[0], p4[1]-p1[1]};
        if (v1[0]*v2[0]+v1[1]*v2[1] != 0)
            return false;
        return v1[0]*v1[0]+v1[1]*v1[1] == v2[0]*v2[0]+v2[1]*v2[1];
    }
}
