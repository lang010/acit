/*
 * @lc app=leetcode id=1134 lang=java
 *
 * [1134] Armstrong Number
 *
 * https://leetcode.com/problems/armstrong-number/description/
 *
 * algorithms
 * Easy (78.20%)
 * Total Accepted:    14.9K
 * Total Submissions: 19K
 * Testcase Example:  '153'
 *
 * The k-digit number N is an Armstrong number if and only if the k-th power of
 * each digit sums to N.
 * 
 * Given a positive integer N, return true if and only if it is an Armstrong
 * number.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: 153
 * Output: true
 * Explanation: 
 * 153 is a 3-digit number, and 153 = 1^3 + 5^3 + 3^3.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 123
 * Output: false
 * Explanation: 
 * 123 is a 3-digit number, and 123 != 1^3 + 2^3 + 3^3 = 36.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= N <= 10^8
 * 
 * 
 */
class Solution {
    public boolean isArmstrong(int N) {
        if (N < 10) {
            return true;
        }
        int x = N;
        int s = 0;
        int[] dig = new int[10];
        int len = 0;
        while (x > 0) {
            dig[len++] = x % 10;
            x /= 10;
        }
        for (int i = 0; i < len; i++) {
            int t = 1;
            for (int j = 0; j < len; j++)
                t *= dig[i];
            s += t;
        }
        return s == N;
    }
}
