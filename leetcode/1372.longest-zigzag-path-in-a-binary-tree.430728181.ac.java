/*
 * @lc app=leetcode id=1372 lang=java
 *
 * [1372] Longest ZigZag Path in a Binary Tree
 *
 * https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/description/
 *
 * algorithms
 * Medium (54.52%)
 * Total Accepted:    15.5K
 * Total Submissions: 28.4K
 * Testcase Example:  '[1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]'
 *
 * Given a binary tree root, a ZigZag path for a binary tree is defined as
 * follow:
 * 
 * 
 * Choose any node in the binary tree and a direction (right or left).
 * If the current direction is right then move to the right child of the
 * current node otherwise move to the left child.
 * Change the direction from right to left or right to left.
 * Repeat the second and third step until you can't move in the tree.
 * 
 * 
 * Zigzag length is defined as the number of nodes visited - 1. (A single node
 * has a length of 0).
 * 
 * Return the longest ZigZag path contained in that tree.
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]
 * Output: 3
 * Explanation: Longest ZigZag path in blue nodes (right -> left -> right).
 * 
 * 
 * Example 2:
 * 
 * 
 * 
 * 
 * Input: root = [1,1,1,null,1,null,null,1,1,null,1]
 * Output: 4
 * Explanation: Longest ZigZag path in blue nodes (left -> right -> left ->
 * right).
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: root = [1]
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * Each tree has at most 50000 nodes..
 * Each node's value is between [1, 100].
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
    public int longestZigZag(TreeNode root) {
        dfs(root);
        return max;
    }
    
    int[] dfs(TreeNode root) {
        if (root == null)
            return null;
        int[] ans = new int[2];
        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        if (l != null)
            ans[0] = l[1] + 1;
        if (r != null)
            ans[1] = r[0] + 1;
        max = Math.max(max, Math.max(ans[0], ans[1]));
        return ans;
    }
}
