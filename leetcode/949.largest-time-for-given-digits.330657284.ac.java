/*
 * @lc app=leetcode id=949 lang=java
 *
 * [949] Largest Time for Given Digits
 *
 * https://leetcode.com/problems/largest-time-for-given-digits/description/
 *
 * algorithms
 * Medium (36.22%)
 * Total Accepted:    57.8K
 * Total Submissions: 159.6K
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given an array arr of 4 digits, find the latest 24-hour time that can be
 * made using each digit exactly once.
 * 
 * 24-hour times are formatted as "HH:MM", where HH is between 00 and 23, and
 * MM is between 00 and 59. The earliest 24-hour time is 00:00, and the latest
 * is 23:59.
 * 
 * Return the latest 24-hour time in "HH:MM" format.  If no valid time can be
 * made, return an empty string.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: A = [1,2,3,4]
 * Output: "23:41"
 * Explanation: The valid 24-hour times are "12:34", "12:43", "13:24", "13:42",
 * "14:23", "14:32", "21:34", "21:43", "23:14", and "23:41". Of these times,
 * "23:41" is the latest.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: A = [5,5,5,5]
 * Output: ""
 * Explanation: There are no valid 24-hour times as "55:55" is not valid.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: A = [0,0,0,0]
 * Output: "00:00"
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: A = [0,0,1,0]
 * Output: "10:00"
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * arr.length == 4
 * 0 <= arr[i] <= 9
 * 
 * 
 */
class Solution {
    String ans = "";
    int max = -1;
    public String largestTimeFromDigits(int[] A) {
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                for (int k = 0; k < 4; k++)
                    for (int l = 0; l < 4; l++)
                        if (i != j && i != k && i != l && j != k && j != l && k != l)
                            check(A[i], A[j], A[k], A[l]);
        return ans;
    }
    
    void check(int a, int b, int c, int d) {
        int h = a * 10 + b;
        int m = c * 10 + d;
        if (h < 24 && m < 60) {
            m += h * 60;
            if (max < m) {
                max = m;
                ans = "" + a + b + ":" + c + d;
            }
        }
    }
}
