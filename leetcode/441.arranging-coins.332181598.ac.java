/*
 * @lc app=leetcode id=441 lang=java
 *
 * [441] Arranging Coins
 *
 * https://leetcode.com/problems/arranging-coins/description/
 *
 * algorithms
 * Easy (42.23%)
 * Total Accepted:    177.7K
 * Total Submissions: 420.8K
 * Testcase Example:  '5'
 *
 * You have a total of n coins that you want to form in a staircase shape,
 * where every k-th row must have exactly k coins.
 * ⁠
 * Given n, find the total number of full staircase rows that can be formed.
 * 
 * n is a non-negative integer and fits within the range of a 32-bit signed
 * integer.
 * 
 * Example 1:
 * 
 * n = 5
 * 
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * 
 * Because the 3rd row is incomplete, we return 2.
 * 
 * 
 * 
 * Example 2:
 * 
 * n = 8
 * 
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 * 
 * Because the 4th row is incomplete, we return 3.
 * 
 * 
 */
class Solution {
    public int arrangeCoins(int n) {
        if (n < 2)
            return n;
        long l = 1, r = 70000;
        while (l < r) {
            long m = l + (r-l+1)/2;
            long v = m * (m+1)/2;
            if (v > n) {
                r = m-1;
            } else {
                l = m;
            }
        }
        return (int) l;
    }
}
