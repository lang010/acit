/*
 * @lc app=leetcode id=687 lang=java
 *
 * [687] Longest Univalue Path
 *
 * https://leetcode.com/problems/longest-univalue-path/description/
 *
 * algorithms
 * Medium (36.91%)
 * Total Accepted:    104.7K
 * Total Submissions: 283.6K
 * Testcase Example:  '[5,4,5,1,1,5]'
 *
 * Given the root of a binary tree, return the length of the longest path,
 * where each node in the path has the same value. This path may or may not
 * pass through the root.
 * 
 * The length of the path between two nodes is represented by the number of
 * edges between them.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [5,4,5,1,1,5]
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [1,4,5,4,4,5]
 * Output: 2
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [0, 10^4].
 * -1000 <= Node.val <= 1000
 * The depth of the tree will not exceed 1000.
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
    int ans = 0;
    
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return ans;
    }
    
    int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        int ret = 0;
        int len = 0;
        if (root.left != null && root.val == root.left.val
           && root.right != null && root.val == root.right.val) {
            ret = Math.max(l, r) + 1;
            len = l + r + 2;
        } else if (root.left != null && root.val == root.left.val) {
            ret = l + 1;
            len = ret;
        } else if (root.right != null && root.val == root.right.val) {
            ret = r + 1;
            len = ret;
        }
        if (ans < len)
            ans = len;
        return ret;
    }
}
