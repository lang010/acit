/*
 * @lc app=leetcode id=501 lang=java
 *
 * [501] Find Mode in Binary Search Tree
 *
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/description/
 *
 * algorithms
 * Easy (43.03%)
 * Total Accepted:    97.7K
 * Total Submissions: 227.2K
 * Testcase Example:  '[1,null,2,2]'
 *
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the
 * most frequently occurred element) in the given BST.
 * 
 * Assume a BST is defined as follows:
 * 
 * 
 * The left subtree of a node contains only nodes with keys less than or equal
 * to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or
 * equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * 
 * 
 * 
 * For example:
 * Given BST [1,null,2,2],
 * 
 * 
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  2
 * 
 * 
 * 
 * 
 * return [2].
 * 
 * Note: If a tree has more than one mode, you can return them in any order.
 * 
 * Follow up: Could you do that without using any extra space? (Assume that the
 * implicit stack space incurred due to recursion does not count).
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
    int len = 0;
    int maxLen = 0;
    TreeNode preNode;
    List<Integer> ans = new ArrayList<>();
    List<Integer> all = new ArrayList<>();
    
    public int[] findMode(TreeNode root) {
        inorder(root);
        if (ans.size() == 0)
            ans = all;
        int[] ret = new int[ans.size()];
        for (int i = 0; i < ret.length; i++)
            ret[i] = ans.get(i);
        return ret;
    }
    
    void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        all.add(root.val);
        if (preNode != null) {
            if (preNode.val == root.val) {
                len++;
                if (maxLen == len) {
                    ans.add(root.val);
                } else if (maxLen < len) {
                    maxLen = len;
                    ans.clear();
                    ans.add(root.val);
                }
            } else {
                len = 0;
            }
        }
        preNode = root;
        inorder(root.right);
    }
}
