/*
 * @lc app=leetcode id=971 lang=java
 *
 * [971] Flip Binary Tree To Match Preorder Traversal
 *
 * https://leetcode.com/problems/flip-binary-tree-to-match-preorder-traversal/description/
 *
 * algorithms
 * Medium (46.09%)
 * Total Accepted:    14.5K
 * Total Submissions: 31.4K
 * Testcase Example:  '[1,2]\n[2,1]'
 *
 * Given a binary tree with N nodes, each node has a different value from {1,
 * ..., N}.
 * 
 * A node in this binary tree can be flipped by swapping the left child and the
 * right child of that node.
 * 
 * Consider the sequence of N values reported by a preorder traversal starting
 * from the root.  Call such a sequence of N values the voyage of the tree.
 * 
 * (Recall that a preorder traversal of a node means we report the current
 * node's value, then preorder-traverse the left child, then preorder-traverse
 * the right child.)
 * 
 * Our goal is to flip the least number of nodes in the tree so that the voyage
 * of the tree matches the voyage we are given.
 * 
 * If we can do so, then return a list of the values of all nodes flipped.  You
 * may return the answer in any order.
 * 
 * If we cannot do so, then return the list [-1].
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: root = [1,2], voyage = [2,1]
 * Output: [-1]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * 
 * 
 * Input: root = [1,2,3], voyage = [1,3,2]
 * Output: [1]
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * 
 * 
 * Input: root = [1,2,3], voyage = [1,2,3]
 * Output: []
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= N <= 100
 * 
 * 
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
    int cur = 0;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> ans = new ArrayList<>();
        dfs(ans, root, voyage);
        return ans;
    }
    
    void dfs(List<Integer> ans, TreeNode root, int[] voyage) {
        if (root == null || cur < 0)
            return;
        if (voyage[cur] != root.val) {
            cur = -1;
            ans.clear();
            ans.add(-1);
            return;
        }
        cur++;
        if (root.left != null && voyage[cur] != root.left.val) {
            ans.add(root.val);
            dfs(ans, root.right, voyage);
            dfs(ans, root.left, voyage);
        } else {
            dfs(ans, root.left, voyage);
            dfs(ans, root.right, voyage);
        }
    }
}
