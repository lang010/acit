/*
 * @lc app=leetcode id=204 lang=java
 *
 * [204] Count Primes
 *
 * https://leetcode.com/problems/count-primes/description/
 *
 * algorithms
 * Easy (32.01%)
 * Total Accepted:    416K
 * Total Submissions: 1.3M
 * Testcase Example:  '10'
 *
 * Count the number of prime numbers less than a non-negative number, n.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 0
 * Output: 0
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: n = 1
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= n <= 5 * 10^6
 * 
 * 
 */
class Solution {
    public int countPrimes(int n) {
        if (n < 3)
            return 0;
        boolean[] flags = new boolean[n];
        for (int i = 2; i*i < n; i++) {
            if (flags[i])
                continue;
            for (int j = i*i; j < n; j += i)
                flags[j] = true;
        }
        int cnt = 0;
        for (int i = 2; i < n; i++)
            if (!flags[i])
                cnt++;
        return cnt;
    }
}
