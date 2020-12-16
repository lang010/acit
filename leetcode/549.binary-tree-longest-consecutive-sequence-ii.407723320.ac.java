/*
 * @lc app=leetcode id=549 lang=java
 *
 * [549] Binary Tree Longest Consecutive Sequence II
 *
 * https://leetcode.com/problems/binary-tree-longest-consecutive-sequence-ii/description/
 *
 * algorithms
 * Medium (47.18%)
 * Total Accepted:    29.6K
 * Total Submissions: 62.7K
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given a binary tree, you need to find the length of Longest Consecutive Path
 * in Binary Tree.
 * 
 * Especially, this path can be either increasing or decreasing. For example,
 * [1,2,3,4] and [4,3,2,1] are both considered valid, but the path [1,2,4,3] is
 * not valid. On the other hand, the path can be in the child-Parent-child
 * order, where not necessarily be parent-child order.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * ⁠       1
 * ⁠      / \
 * ⁠     2   3
 * Output: 2
 * Explanation: The longest consecutive path is [1, 2] or [2, 1].
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * ⁠       2
 * ⁠      / \
 * ⁠     1   3
 * Output: 3
 * Explanation: The longest consecutive path is [1, 2, 3] or [3, 2, 1].
 * 
 * 
 * 
 * 
 * Note: All the values of tree nodes are in the range of [-1e7, 1e7].
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
    int max = 0;
    public int longestConsecutive(TreeNode root) {
        dfs(root, root == null ? 0 : root.val);
        return max;
    }
    
    int[] dfs(TreeNode root, int p) {
        int[] ans = {1, 1};
        if (root == null)
            return ans;
        int[] l = dfs(root.left, root.val);
        int[] r = dfs(root.right, root.val);
        max = Math.max(max, Math.max(l[0]+r[1], l[1]+r[0])-1);
        if (p == root.val+1) {
            ans[1] = Math.max(l[1], r[1]) + 1;
            max = Math.max(max, ans[1]);
        } else if (p == root.val-1) {
            ans[0] = Math.max(l[0], r[0]) + 1;
            max = Math.max(max, ans[0]);
        }
        return ans;
    }
}
