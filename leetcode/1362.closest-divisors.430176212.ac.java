/*
 * @lc app=leetcode id=1362 lang=java
 *
 * [1362] Closest Divisors
 *
 * https://leetcode.com/problems/closest-divisors/description/
 *
 * algorithms
 * Medium (57.38%)
 * Total Accepted:    10.9K
 * Total Submissions: 19K
 * Testcase Example:  '8'
 *
 * Given an integer num, find the closest two integers in absolute difference
 * whose product equals num + 1 or num + 2.
 * 
 * Return the two integers in any order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: num = 8
 * Output: [3,3]
 * Explanation: For num + 1 = 9, the closest divisors are 3 & 3, for num + 2 =
 * 10, the closest divisors are 2 & 5, hence 3 & 3 is chosen.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: num = 123
 * Output: [5,25]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: num = 999
 * Output: [40,25]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= num <= 10^9
 * 
 * 
 */
class Solution {
    public int[] closestDivisors(int num) {
        int r = (int) Math.sqrt(num+2);
        while (r > 1) {
            if ((num+1)%r == 0)
                return new int[] {r, (num+1)/r};
            if ((num+2)%r == 0)
                return new int[] {r, (num+2)/r};
            r--;
        }
        return new int[] {1, num+1};
    }
}
