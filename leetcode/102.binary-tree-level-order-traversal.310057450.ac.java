/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (55.91%)
 * Total Accepted:    726.6K
 * Total Submissions: 1.3M
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * 
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 
 * return its level order traversal as:
 * 
 * [
 * ⁠ [3],
 * ⁠ [9,20],
 * ⁠ [15,7]
 * ]
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        levelOrder(root, 0, ans);
        return ans;
    }
    
    void levelOrder(TreeNode root, int d, List<List<Integer>> ans) {
        if (root == null)
            return;
        if (ans.size() <= d) {
            ans.add(new ArrayList<Integer>());
        }
        List<Integer> ls = ans.get(d);
        ls.add(root.val);
        levelOrder(root.left, d+1, ans);
        levelOrder(root.right, d+1, ans);
    }
}
