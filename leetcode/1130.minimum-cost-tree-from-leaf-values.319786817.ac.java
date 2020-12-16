/*
 * @lc app=leetcode id=1130 lang=java
 *
 * [1130] Minimum Cost Tree From Leaf Values
 *
 * https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/description/
 *
 * algorithms
 * Medium (67.06%)
 * Total Accepted:    43.8K
 * Total Submissions: 65.3K
 * Testcase Example:  '[6,2,4]'
 *
 * Given an array arr of positive integers, consider all binary trees such
 * that:
 * 
 * 
 * Each node has either 0 or 2 children;
 * The values of arr correspond to the values of each leaf in an in-order
 * traversal of the tree.  (Recall that a node is a leaf if and only if it has
 * 0 children.)
 * The value of each non-leaf node is equal to the product of the largest leaf
 * value in its left and right subtree respectively.
 * 
 * 
 * Among all possible binary trees considered, return the smallest possible sum
 * of the values of each non-leaf node.  It is guaranteed this sum fits into a
 * 32-bit integer.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: arr = [6,2,4]
 * Output: 32
 * Explanation:
 * There are two possible trees.  The first has non-leaf node sum 36, and the
 * second has non-leaf node sum 32.
 * 
 * ⁠   24            24
 * ⁠  /  \          /  \
 * ⁠ 12   4        6    8
 * ⁠/  \               / \
 * 6    2             2   4
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 2 <= arr.length <= 40
 * 1 <= arr[i] <= 15
 * It is guaranteed that the answer fits into a 32-bit signed integer (ie. it
 * is less than 2^31).
 * 
 */
class Solution {
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        int[][] max = new int[n][n];
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            max[i][i] = arr[i];
            for (int j = i+1; j < n; j++) {
                max[i][j] = Math.max(arr[j], max[i][j-1]);
            }
        }
        for (int k = 1; k < n; k++) {
            for (int i = 0; i+k < n; i++) {
                int j = i + k;
                dp[i][j] = Integer.MAX_VALUE;
                for (int m = i; m < i+k; m++) {
                    dp[i][j] = Math.min(dp[i][j],
                                        max[i][m]*max[m+1][j] + dp[i][m] + dp[m+1][j]);
                }
            }
        }
        return dp[0][n-1];
    }
}
