/*
 * @lc app=leetcode id=124 lang=java
 *
 * [124] Binary Tree Maximum Path Sum
 *
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
 *
 * algorithms
 * Hard (35.08%)
 * Total Accepted:    441.8K
 * Total Submissions: 1.3M
 * Testcase Example:  '[1,2,3]'
 *
 * Given a non-empty binary tree, find the maximum path sum.
 * 
 * For this problem, a path is defined as any node sequence from some starting
 * node to any node in the tree along the parent-child connections. The path
 * must contain at least one node and does not need to go through the root.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,2,3]
 * Output: 6
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [-10,9,20,null,null,15,7]
 * Output: 42
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [0, 3 * 10^4].
 * -1000 <= Node.val <= 1000
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
    int max = 0;
    
    public int maxPathSum(TreeNode root) {
        max = root.val;
        dfs(root);
        return max;
    }
        
    int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        int ans = Math.max(l, r) + root.val;
        max = Math.max(max, Math.max(ans, l+r+root.val));
        return ans > 0 ? ans : 0;
    }
}
