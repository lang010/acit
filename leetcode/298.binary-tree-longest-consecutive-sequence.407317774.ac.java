/*
 * @lc app=leetcode id=298 lang=java
 *
 * [298] Binary Tree Longest Consecutive Sequence
 *
 * https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/description/
 *
 * algorithms
 * Medium (47.67%)
 * Total Accepted:    89.5K
 * Total Submissions: 187.9K
 * Testcase Example:  '[1,null,3,2,4,null,null,null,5]'
 *
 * Given a binary tree, find the length of the longest consecutive sequence
 * path.
 * 
 * The path refers to any sequence of nodes from some starting node to any node
 * in the tree along the parent-child connections. The longest consecutive path
 * need to be from parent to child (cannot be the reverse).
 * 
 * Example 1:
 * 
 * 
 * Input:
 * 
 * ⁠  1
 * ⁠   \
 * ⁠    3
 * ⁠   / \
 * ⁠  2   4
 * ⁠       \
 * ⁠        5
 * 
 * Output: 3
 * 
 * Explanation: Longest consecutive sequence path is 3-4-5, so return 3.
 * 
 * Example 2:
 * 
 * 
 * Input:
 * 
 * ⁠  2
 * ⁠   \
 * ⁠    3
 * ⁠   / 
 * ⁠  2    
 * ⁠ / 
 * ⁠1
 * 
 * Output: 2 
 * 
 * Explanation: Longest consecutive sequence path is 2-3, not 3-2-1, so return
 * 2.
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
    public int longestConsecutive(TreeNode root) {
        dfs(root, 0, Integer.MAX_VALUE);
        return max;
    }
    
    void dfs(TreeNode root, int len, int p) {
        if (root == null)
            return;
        if (root.val-1 == p)
            len++;
        else
            len = 1;
        p = root.val;
        max = Math.max(max, len);
        dfs(root.left, len, p);
        dfs(root.right, len, p);
    }
}
