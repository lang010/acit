/*
 * @lc app=leetcode id=738 lang=java
 *
 * [738] Monotone Increasing Digits
 *
 * https://leetcode.com/problems/monotone-increasing-digits/description/
 *
 * algorithms
 * Medium (45.29%)
 * Total Accepted:    25.9K
 * Total Submissions: 57.3K
 * Testcase Example:  '10'
 *
 * 
 * Given a non-negative integer N, find the largest number that is less than or
 * equal to N with monotone increasing digits.
 * 
 * (Recall that an integer has monotone increasing digits if and only if each
 * pair of adjacent digits x and y satisfy x .)
 * 
 * 
 * Example 1:
 * 
 * Input: N = 10
 * Output: 9
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: N = 1234
 * Output: 1234
 * 
 * 
 * 
 * Example 3:
 * 
 * Input: N = 332
 * Output: 299
 * 
 * 
 * 
 * Note:
 * N is an integer in the range [0, 10^9].
 * 
 */
class Solution {
    public int monotoneIncreasingDigits(int N) {
        char[] arr = String.valueOf(N).toCharArray();
        int pre = 0;
        int i;
        for (i = 0; i < arr.length; i++)
            if (arr[i] > arr[pre])
                pre = i;
            else if (arr[i] < arr[pre])
                break;
        if (i < arr.length) {
            arr[pre]--;
            for (i = pre+1; i < arr.length; i++)
                arr[i] = '9';
        }
        return Integer.valueOf(new String(arr));
    }
}
