/*
 * @lc app=leetcode id=1432 lang=java
 *
 * [1432] Max Difference You Can Get From Changing an Integer
 *
 * https://leetcode.com/problems/max-difference-you-can-get-from-changing-an-integer/description/
 *
 * algorithms
 * Medium (42.91%)
 * Total Accepted:    9.2K
 * Total Submissions: 21.5K
 * Testcase Example:  '555'
 *
 * You are given an integer num. You will apply the following steps exactly two
 * times:
 * 
 * 
 * Pick a digit x (0 <= x <= 9).
 * Pick another digit y (0 <= y <= 9). The digit y can be equal to x.
 * Replace all the occurrences of x in the decimal representation of num by
 * y.
 * The new integer cannot have any leading zeros, also the new integer cannot
 * be 0.
 * 
 * 
 * Let a and b be the results of applying the operations to num the first and
 * second times, respectively.
 * 
 * Return the max difference between a and b.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: num = 555
 * Output: 888
 * Explanation: The first time pick x = 5 and y = 9 and store the new integer
 * in a.
 * The second time pick x = 5 and y = 1 and store the new integer in b.
 * We have now a = 999 and b = 111 and max difference = 888
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: num = 9
 * Output: 8
 * Explanation: The first time pick x = 9 and y = 9 and store the new integer
 * in a.
 * The second time pick x = 9 and y = 1 and store the new integer in b.
 * We have now a = 9 and b = 1 and max difference = 8
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: num = 123456
 * Output: 820000
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: num = 10000
 * Output: 80000
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: num = 9288
 * Output: 8700
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= num <= 10^8
 * 
 * 
 */
class Solution {
    public int maxDiff(int num) {
        int ans = 0;
        char[] ls = String.valueOf(num).toCharArray();
        int n = ls.length;

        for (int i = 0; i < n; i++) {
            if (ls[0] == ls[i])
                ans = 8 + 10 * ans;
            else
                ans *= 10;
        }
        if (ls[0] == '9') {
            char c = 0;
            for (int i = 1; i < n; i++)
                if (ls[i] != '9') {
                    if (c == 0)
                        c = ls[i];
                    if (c == ls[i])
                        ans += ('9' - ls[i]) * Math.pow(10, n-i-1);
                }
        }
        if (ls[0] == '1') {
            char c = 0;
            for (int i = 1; i < n; i++)
                if (ls[i] > '1') {
                    if (c == 0)
                        c = ls[i];
                    if (c == ls[i])
                        ans += (ls[i] - '0') * Math.pow(10, n-i-1);
                }
        }
        return ans;
    }
}
