/*
 * @lc app=leetcode id=625 lang=java
 *
 * [625] Minimum Factorization
 *
 * https://leetcode.com/problems/minimum-factorization/description/
 *
 * algorithms
 * Medium (32.79%)
 * Total Accepted:    8.8K
 * Total Submissions: 26.9K
 * Testcase Example:  '48'
 *
 * Given a positive integer a, find the smallest positive integer b whose
 * multiplication of each digit equals to a. 
 * 
 * 
 * If there is no answer or the answer is not fit in 32-bit signed integer,
 * then return 0.
 * 
 * 
 * Example 1
 * Input:
 * 48 
 * Output:
 * 68
 * 
 * 
 * 
 * Example 2
 * Input: 
 * 15
 * 
 * Output:
 * 35
 * 
 */
class Solution {
    public int smallestFactorization(int a) {
        if (a < 10)
            return a;
        int[] cnt = new int[10];
        for (int i = 9; i > 1; i--) {
            while (a%i == 0) {
                cnt[i]++;
                a /= i;
            }
        }
        if (a != 1)
            return 0;
        long ans = 0;
        for (int i = 2; i < 10; i++)
            while (cnt[i] > 0) {
                ans = ans * 10 + i;
                if (Integer.MAX_VALUE < ans)
                    return 0;
                cnt[i]--;
            }
        return (int) ans;
    }
}
