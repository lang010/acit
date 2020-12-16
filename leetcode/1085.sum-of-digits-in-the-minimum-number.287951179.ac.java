/*
 * @lc app=leetcode id=1085 lang=java
 *
 * [1085] Sum of Digits in the Minimum Number
 *
 * https://leetcode.com/problems/sum-of-digits-in-the-minimum-number/description/
 *
 * algorithms
 * Easy (74.93%)
 * Total Accepted:    14.7K
 * Total Submissions: 19.6K
 * Testcase Example:  '[34,23,1,24,75,33,54,8]'
 *
 * Given an array A of positive integers, let S be the sum of the digits of the
 * minimal element of A.
 * 
 * Return 0 if S is odd, otherwise return 1.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [34,23,1,24,75,33,54,8]
 * Output: 0
 * Explanation: 
 * The minimal element is 1, and the sum of those digits is S = 1 which is odd,
 * so the answer is 0.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [99,77,33,66,55]
 * Output: 1
 * Explanation: 
 * The minimal element is 33, and the sum of those digits is S = 3 + 3 = 6
 * which is even, so the answer is 1.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= A.length <= 100
 * 1 <= A[i] <= 100
 * 
 * 
 */
class Solution {
    public int sumOfDigits(int[] A) {
        int min = A[0];
        for (int i = 1; i < A.length; i++) {
            if (min > A[i]) {
                min = A[i];
            }
        }
        int sum = 0;
        while (min > 0) {
            sum += min % 10;
            min /= 10;
        }
        if (sum%2 == 1) {
            return 0;
        } else {
            return 1;
        }
    }
}
