/*
 * @lc app=leetcode id=889 lang=java
 *
 * [889] Construct Binary Tree from Preorder and Postorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/description/
 *
 * algorithms
 * Medium (67.11%)
 * Total Accepted:    44.2K
 * Total Submissions: 65.8K
 * Testcase Example:  '[1,2,4,5,3,6,7]\n[4,5,2,6,7,3,1]'
 *
 * Return any binary tree that matches the given preorder and postorder
 * traversals.
 * 
 * Values in the traversals pre and post are distinct positive integers.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
 * Output: [1,2,3,4,5,6,7]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= pre.length == post.length <= 30
 * pre[] and post[] are both permutations of 1, 2, ..., pre.length.
 * It is guaranteed an answer exists. If there exists multiple answers, you can
 * return any of them.
 * 
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
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return dfs(pre, 0, pre.length-1, post, 0, post.length-1);
    }
    
    TreeNode dfs(int[] pre, int l1, int r1, int[] post, int l2, int r2) {
        if (l1 > r1)
            return null;
        TreeNode root = new TreeNode(pre[l1]);
        if (l1 == r1)
            return root;
        int len = 0;
        for (int i = l2; i < r2; i++)
            if (post[i] == pre[l1+1]) {
                len = i-l2;
                break;
            }
        root.left = dfs(pre, l1+1, l1+1+len, post, l2, l2+len);
        root.right = dfs(pre, l1+2+len, r1, post, l2+len+1, r2-1);
        return root;
    }
}
