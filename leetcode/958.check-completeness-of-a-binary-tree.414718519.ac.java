/*
 * @lc app=leetcode id=958 lang=java
 *
 * [958] Check Completeness of a Binary Tree
 *
 * https://leetcode.com/problems/check-completeness-of-a-binary-tree/description/
 *
 * algorithms
 * Medium (52.38%)
 * Total Accepted:    68.3K
 * Total Submissions: 130.5K
 * Testcase Example:  '[1,2,3,4,5,6]'
 *
 * Given the root of a binary tree, determine if it is a complete binary tree.
 * 
 * In a complete binary tree, every level, except possibly the last, is
 * completely filled, and all nodes in the last level are as far left as
 * possible. It can have between 1 and 2^h nodes inclusive at the last level
 * h.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,2,3,4,5,6]
 * Output: true
 * Explanation: Every level before the last is full (ie. levels with
 * node-values {1} and {2, 3}), and all nodes in the last level ({4, 5, 6}) are
 * as far left as possible.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [1,2,3,4,5,null,7]
 * Output: false
 * Explanation: The node with value 7 isn't as far left as possible.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [1, 100].
 * 1 <= Node.val <= 1000
 * 
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
    int max = -1;
    boolean ended = false;
    public boolean isCompleteTree(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            max++;
            cur = cur.left;
        }
        return dfs(root, 0);
    }
    
    boolean dfs(TreeNode node, int d) {
        if (node == null)
            return max+1 == d;
        if (node.left == null && node.right == null) {
            if (ended)
                return d == max-1;
            if (d == max-1) {
                ended = true;
                return true;
            }
            return d == max;
        }
        if (node.left != null && node.right == null) {
            if (d != max-1 || !dfs(node.left, d+1) || ended)
                return false;
            ended = true;
            return true;
        }
        return dfs(node.left, d+1) && dfs(node.right, d+1);
    }
}
