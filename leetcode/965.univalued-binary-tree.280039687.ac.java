/*
 * @lc app=leetcode id=965 lang=java
 *
 * [965] Univalued Binary Tree
 *
 * https://leetcode.com/problems/univalued-binary-tree/description/
 *
 * algorithms
 * Easy (67.66%)
 * Total Accepted:    106.3K
 * Total Submissions: 157.1K
 * Testcase Example:  '[1,1,1,1,1,null,1]'
 *
 * A binary tree is univalued if every node in the tree has the same value.
 * 
 * Return true if and only if the given tree is univalued.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [1,1,1,1,1,null,1]
 * Output: true
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [2,2,2,5,2]
 * Output: false
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * The number of nodes in the given tree will be in the range [1, 100].
 * Each node's value will be an integer in the range [0, 99].
 * 
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.left.val != root.val) {
            return false;
        }
        if (root.right != null && root.right.val != root.val) {
            return false;
        }
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }
}
