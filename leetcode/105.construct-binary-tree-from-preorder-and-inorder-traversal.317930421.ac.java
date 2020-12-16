/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (50.77%)
 * Total Accepted:    429.2K
 * Total Submissions: 845.3K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * 
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    
    TreeNode build(int[] preorder, int pl, int pr, int[] inorder, int il, int ir) {
        if (pl > pr)
            return null;
        TreeNode root = new TreeNode(preorder[pl]);
        for (int i = il; i <= ir; i++) {
            if (root.val == inorder[i]) {
                int mid = pl + i - il;
                root.left = build(preorder, pl+1, mid, inorder, il, i-1);
                root.right = build(preorder, mid+1, pr, inorder, i+1, ir);
                break;
            }
        }
        
        return root;
    }
}
