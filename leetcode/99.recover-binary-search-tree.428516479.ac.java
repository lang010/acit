/*
 * @lc app=leetcode id=99 lang=java
 *
 * [99] Recover Binary Search Tree
 *
 * https://leetcode.com/problems/recover-binary-search-tree/description/
 *
 * algorithms
 * Hard (41.85%)
 * Total Accepted:    194.5K
 * Total Submissions: 464.8K
 * Testcase Example:  '[1,3,null,null,2]'
 *
 * You are given the root of a binary search tree (BST), where exactly two
 * nodes of the tree were swapped by mistake. Recover the tree without changing
 * its structure.
 * 
 * Follow up: A solution using O(n) space is pretty straight forward. Could you
 * devise a constant space solution?
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,3,null,null,2]
 * Output: [3,1,null,null,2]
 * Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3
 * makes the BST valid.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [3,1,4,null,null,2]
 * Output: [2,1,4,null,null,3]
 * Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2
 * and 3 makes the BST valid.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [2, 1000].
 * -2^31 <= Node.val <= 2^31 - 1
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
    TreeNode pre = null;
    TreeNode first = null;
    TreeNode sec = null;
    public void recoverTree(TreeNode root) {
        TreeNode node = dfs(root);
        int t = first.val;
        first.val = sec.val;
        sec.val = t;
    }
    
    TreeNode dfs(TreeNode root) {
        if (root == null)
            return null;
        TreeNode ans = dfs(root.left);
        if (first == null && pre != null && pre.val > root.val)
            first = pre;
        if (pre != null && pre.val > root.val)
            sec = root;
        pre = root;
        return dfs(root.right);
    }
}
