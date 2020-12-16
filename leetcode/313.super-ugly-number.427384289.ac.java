/*
 * @lc app=leetcode id=313 lang=java
 *
 * [313] Super Ugly Number
 *
 * https://leetcode.com/problems/super-ugly-number/description/
 *
 * algorithms
 * Medium (45.78%)
 * Total Accepted:    82.8K
 * Total Submissions: 180.8K
 * Testcase Example:  '12\n[2,7,13,19]'
 *
 * Write a program to find the n^th super ugly number.
 * 
 * Super ugly numbers are positive numbers whose all prime factors are in the
 * given prime list primes of size k.
 * 
 * Example:
 * 
 * 
 * Input: n = 12, primes = [2,7,13,19]
 * Output: 32 
 * Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first
 * 12 
 * ⁠            super ugly numbers given primes = [2,7,13,19] of size 4.
 * 
 * Note:
 * 
 * 
 * 1 is a super ugly number for any given primes.
 * The given numbers in primes are in ascending order.
 * 0 < k ≤ 100, 0 < n ≤ 10^6, 0 < primes[i] < 1000.
 * The n^th super ugly number is guaranteed to fit in a 32-bit signed integer.
 * 
 * 
 */
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ans = new int[n];
        int k = primes.length;
        int[] index = new int[k];
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            long min = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++)
                min = Math.min(min, (long) primes[j] * ans[index[j]]);
            ans[i] = (int) min;
            for (int j = 0; j < k; j++)
                if (min == primes[j] * ans[index[j]])
                    index[j]++;
        }
        return ans[n-1];
    }
}
