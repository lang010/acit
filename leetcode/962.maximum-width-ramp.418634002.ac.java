/*
 * @lc app=leetcode id=962 lang=java
 *
 * [962] Maximum Width Ramp
 *
 * https://leetcode.com/problems/maximum-width-ramp/description/
 *
 * algorithms
 * Medium (45.99%)
 * Total Accepted:    22.3K
 * Total Submissions: 48.4K
 * Testcase Example:  '[6,0,8,2,1,5]'
 *
 * Given an array A of integers, a ramp is a tuple (i, j) for which i < j and
 * A[i] <= A[j].  The width of such a ramp is j - i.
 * 
 * Find the maximum width of a ramp in A.  If one doesn't exist, return 0.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [6,0,8,2,1,5]
 * Output: 4
 * Explanation: 
 * The maximum width ramp is achieved at (i, j) = (1, 5): A[1] = 0 and A[5] =
 * 5.
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [9,8,1,0,1,9,4,0,4,1]
 * Output: 7
 * Explanation: 
 * The maximum width ramp is achieved at (i, j) = (2, 9): A[2] = 1 and A[9] =
 * 1.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 2 <= A.length <= 50000
 * 0 <= A[i] <= 50000
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public int maxWidthRamp(int[] A) {
        int n = A.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++)
            if (i == 0 || A[stack.peek()] > A[i] )
                stack.push(i);
        int ans = 0;
        for (int i = n-1; i > 0; i--) {
            while (!stack.isEmpty()) {
                int x = A[stack.peek()];
                if (x > A[i])
                    break;
                ans = Math.max(ans, i-stack.peek());
                stack.pop();
            }
            if (stack.isEmpty())
                break;
        }
        return ans;
    }
}
