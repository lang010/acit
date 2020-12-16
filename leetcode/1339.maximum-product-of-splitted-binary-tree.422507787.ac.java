/*
 * @lc app=leetcode id=1339 lang=java
 *
 * [1339] Maximum Product of Splitted Binary Tree
 *
 * https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/description/
 *
 * algorithms
 * Medium (37.64%)
 * Total Accepted:    20.3K
 * Total Submissions: 54K
 * Testcase Example:  '[1,2,3,4,5,6]'
 *
 * Given a binary tree root. Split the binary tree into two subtrees by
 * removing 1 edge such that the product of the sums of the subtrees are
 * maximized.
 * 
 * Since the answer may be too large, return it modulo 10^9 + 7.
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: root = [1,2,3,4,5,6]
 * Output: 110
 * Explanation: Remove the red edge and get 2 binary trees with sum 11 and 10.
 * Their product is 110 (11*10)
 * 
 * 
 * Example 2:
 * 
 * 
 * 
 * 
 * Input: root = [1,null,2,3,4,null,null,5,6]
 * Output: 90
 * Explanation:  Remove the red edge and get 2 binary trees with sum 15 and
 * 6.Their product is 90 (15*6)
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: root = [2,3,9,10,7,8,6,5,4,11,1]
 * Output: 1025
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: root = [1,1]
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * Each tree has at most 50000 nodes and at least 2 nodes.
 * Each node's value is between [1, 10000].
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    long ans = -1;
    public int maxProduct(TreeNode root) {
        long sum = sum(root);
        dfs(root, sum);
        return (int) (ans%1000000007);
    }
    
    long sum(TreeNode root) {
        if (root == null)
            return 0;
        return sum(root.left) + sum(root.right) + root.val;
    }
    
    long dfs(TreeNode root, long sum) {
        if (root == null)
            return 0;
        long l = dfs(root.left, sum);
        long r = dfs(root.right, sum);
        ans = Math.max(ans, Math.max((sum-l)*l, (sum-r)*r));
        return l+r+root.val;
    }
}
