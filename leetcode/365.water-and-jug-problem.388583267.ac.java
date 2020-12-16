/*
 * @lc app=leetcode id=365 lang=java
 *
 * [365] Water and Jug Problem
 *
 * https://leetcode.com/problems/water-and-jug-problem/description/
 *
 * algorithms
 * Medium (30.87%)
 * Total Accepted:    43.8K
 * Total Submissions: 142K
 * Testcase Example:  '3\n5\n4'
 *
 * You are given two jugs with capacities x and y litres. There is an infinite
 * amount of water supply available. You need to determine whether it is
 * possible to measure exactly z litres using these two jugs.
 * 
 * If z liters of water is measurable, you must have z liters of water
 * contained within one or both buckets by the end.
 * 
 * Operations allowed:
 * 
 * 
 * Fill any of the jugs completely with water.
 * Empty any of the jugs.
 * Pour water from one jug into another till the other jug is completely full
 * or the first jug itself is empty.
 * 
 * 
 * Example 1: (From the famous "Die Hard" example)
 * 
 * 
 * Input: x = 3, y = 5, z = 4
 * Output: True
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: x = 2, y = 6, z = 5
 * Output: False
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= x <= 10^6
 * 0 <= y <= 10^6
 * 0 <= z <= 10^6
 * 
 * 
 */
class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0)
            return true;
        int t = x+y;
        if (z > t)
            return false;
        x = Math.max(x, y);
        y = t-x;
        if (y == 0)
            return z == x;
        Set<Integer> set = new HashSet<>();
        int mod = 0;
        while (!set.contains(mod)) {
            set.add(mod);
            if (mod == z%y)
                return true;
            mod = y-(x-mod)%y;
        }
        return false;
    }
}
