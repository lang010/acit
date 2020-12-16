/*
 * @lc app=leetcode id=107 lang=java
 *
 * [107] Binary Tree Level Order Traversal II
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
 *
 * algorithms
 * Easy (54.58%)
 * Total Accepted:    390.3K
 * Total Submissions: 715.1K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the bottom-up level order traversal of its
 * nodes' values. (ie, from left to right, level by level from leaf to root).
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
 * return its bottom-up level order traversal as:
 * 
 * [
 * ⁠ [15,7],
 * ⁠ [9,20],
 * ⁠ [3]
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, 0, ans);
        int l = 0, r = ans.size()-1;
        while (l < r) {
            List<Integer> tmp = ans.get(l);
            ans.set(l, ans.get(r));
            ans.set(r, tmp);
            l++; r--;
        }
        return ans;
    }
    
    void dfs(TreeNode root, int d, List<List<Integer>> ans) {
        if (root == null)
            return;
        List<Integer> ls ;
        if (d < ans.size()) {
            ls = ans.get(d);
        } else {
            ls = new ArrayList<>();
            ans.add(ls);
        }
        ls.add(root.val);
        dfs(root.left, d+1, ans);
        dfs(root.right, d+1, ans);
    }
}
