/*
 * @lc app=leetcode id=670 lang=java
 *
 * [670] Maximum Swap
 *
 * https://leetcode.com/problems/maximum-swap/description/
 *
 * algorithms
 * Medium (44.66%)
 * Total Accepted:    85.5K
 * Total Submissions: 191.5K
 * Testcase Example:  '2736'
 *
 * 
 * Given a non-negative integer, you could swap two digits at most once to get
 * the maximum valued number. Return the maximum valued number you could get.
 * 
 * 
 * Example 1:
 * 
 * Input: 2736
 * Output: 7236
 * Explanation: Swap the number 2 and the number 7.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: 9973
 * Output: 9973
 * Explanation: No swap.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * The given number is in the range [0, 10^8]
 * 
 * 
 */
class Solution {
    public int maximumSwap(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        int st = 0, pre = 0;
        for (int i = 1; i < arr.length; i++) {
            if (pre == st && arr[pre] >= arr[i]) {
                st = pre = i;
                continue;
            }
            if (arr[pre] <= arr[i]) {
                pre = i;
                while (st > 0 && arr[st-1] < arr[i])
                    st--;
            }
        }
        if (st != pre) {
            char c = arr[st];
            arr[st] = arr[pre];
            arr[pre] = c;
        }
        
        return Integer.valueOf(new String(arr));
    }
}
