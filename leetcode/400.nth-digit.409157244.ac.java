/*
 * @lc app=leetcode id=400 lang=java
 *
 * [400] Nth Digit
 *
 * https://leetcode.com/problems/nth-digit/description/
 *
 * algorithms
 * Medium (32.27%)
 * Total Accepted:    63.4K
 * Total Submissions: 196.5K
 * Testcase Example:  '3'
 *
 * Find the n^th digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8,
 * 9, 10, 11, ... 
 * 
 * Note:
 * n is positive and will fit within the range of a 32-bit signed integer (n <
 * 2^31).
 * 
 * 
 * Example 1:
 * 
 * Input:
 * 3
 * 
 * Output:
 * 3
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * 11
 * 
 * Output:
 * 0
 * 
 * Explanation:
 * The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a
 * 0, which is part of the number 10.
 * 
 * 
 */
class Solution {
    public int findNthDigit(int n) {
        n--;
        for (int i = 0; i < 50; i++) {
            long val = (long) Math.pow(10, i) * 9 * (i+1);
            if (n >= val)
                n -= val;
            else
                return helper(n, i+1);
        }
        return -1;
    }
    
    int helper(int n, int i) {
        int k = n/i;
        int v = (int) Math.pow(10, i-1) + k;
        return (v / (int) Math.pow(10, i-n%i-1))%10;
    }
}
