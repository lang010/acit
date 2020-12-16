/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 *
 * algorithms
 * Medium (48.79%)
 * Total Accepted:    268.8K
 * Total Submissions: 550.8K
 * Testcase Example:  '[9,3,15,20,7]\n[9,15,7,20,3]'
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * 
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * 
 * Return the following binary tree:
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length-1);
    }
    
    TreeNode buildTree(int[] inorder, int il, int ir, int[] postorder, int pl, int pr) {
        if (il > ir || pl > pr)
            return null;
        TreeNode node = new TreeNode(postorder[pr]);
        int m = il;
        while (inorder[m] != node.val) {
            m++;
        }
        node.left = buildTree(inorder, il, m-1, postorder, pl, pl + (m-1-il));
        node.right = buildTree(inorder, m+1, ir, postorder, pl + (m-1-il) + 1,pr-1);
        
        return node;
    }
}
