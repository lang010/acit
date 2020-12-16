/*
 * @lc app=leetcode id=651 lang=java
 *
 * [651] 4 Keys Keyboard
 *
 * https://leetcode.com/problems/4-keys-keyboard/description/
 *
 * algorithms
 * Medium (52.82%)
 * Total Accepted:    17.3K
 * Total Submissions: 32.8K
 * Testcase Example:  '1'
 *
 * Imagine you have a special keyboard with the following keys: 
 * Key 1: (A):  Print one 'A' on screen.
 * Key 2: (Ctrl-A): Select the whole screen.
 * Key 3: (Ctrl-C): Copy selection to buffer.
 * Key 4: (Ctrl-V): Print buffer on screen appending it after what has already
 * been printed. 
 * 
 * 
 * 
 * Now, you can only press the keyboard for N times (with the above four keys),
 * find out the maximum numbers of 'A' you can print on screen.
 * 
 * 
 * Example 1:
 * 
 * Input: N = 3
 * Output: 3
 * Explanation: 
 * We can at most get 3 A's on screen by pressing following key sequence:
 * A, A, A
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: N = 7
 * Output: 9
 * Explanation: 
 * We can at most get 9 A's on screen by pressing following key sequence:
 * A, A, A, Ctrl A, Ctrl C, Ctrl V, Ctrl V
 * 
 * 
 * 
 * Note:
 * 
 * 1 
 * Answers will be in the range of 32-bit signed integer.
 * 
 * 
 * 
 */
class Solution {
    public int maxA(int N) {
        if (N < 7)
            return N;
        int[] dp = new int[N];
        for (int i = 0; i < 6; i++)
            dp[i] = i+1;
        for (int i = 6; i < N; i++)
            for (int j = 0; i-3-j >= 0; j++)
                dp[i] = Math.max(dp[i], (2+j)*dp[i-3-j]);
        return dp[N-1];
    }
}
