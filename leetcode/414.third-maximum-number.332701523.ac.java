/*
 * @lc app=leetcode id=414 lang=java
 *
 * [414] Third Maximum Number
 *
 * https://leetcode.com/problems/third-maximum-number/description/
 *
 * algorithms
 * Easy (30.57%)
 * Total Accepted:    187.5K
 * Total Submissions: 613.3K
 * Testcase Example:  '[3,2,1]'
 *
 * Given a non-empty array of integers, return the third maximum number in this
 * array. If it does not exist, return the maximum number. The time complexity
 * must be in O(n).
 * 
 * Example 1:
 * 
 * Input: [3, 2, 1]
 * 
 * Output: 1
 * 
 * Explanation: The third maximum is 1.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: [1, 2]
 * 
 * Output: 2
 * 
 * Explanation: The third maximum does not exist, so the maximum (2) is
 * returned instead.
 * 
 * 
 * 
 * Example 3:
 * 
 * Input: [2, 2, 3, 1]
 * 
 * Output: 1
 * 
 * Explanation: Note that the third maximum here means the third maximum
 * distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 * 
 * 
 */
class Solution {
    public int thirdMax(int[] nums) {
        long a, b, c;
        long t;
        a = b = c = Long.MIN_VALUE;
        for (int x : nums) {
            if (x == a || x == b || x == c)
                continue;
            if (x > c)
                c = x;
            if (c > b) {
                t = b;
                b = c;
                c = t;
            }
            if (b > a) {
                t = a;
                a = b;
                b = t;
            }
        }
        return (int)(c == Long.MIN_VALUE ? a : c);
    }
}
