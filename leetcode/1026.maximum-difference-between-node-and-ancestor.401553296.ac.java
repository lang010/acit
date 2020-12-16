/*
 * @lc app=leetcode id=1026 lang=java
 *
 * [1026] Maximum Difference Between Node and Ancestor
 *
 * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/description/
 *
 * algorithms
 * Medium (68.88%)
 * Total Accepted:    71.1K
 * Total Submissions: 103.2K
 * Testcase Example:  '[8,3,10,1,6,null,14,null,null,4,7,13]'
 *
 * Given the root of a binary tree, find the maximum value V for which there
 * exist different nodes A and B where V = |A.val - B.val| and A is an ancestor
 * of B.
 * 
 * A node A is an ancestor of B if either: any child of A is equal to B, or any
 * child of A is an ancestor of B.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [8,3,10,1,6,null,14,null,null,4,7,13]
 * Output: 7
 * Explanation: We have various ancestor-node differences, some of which are
 * given below :
 * |8 - 3| = 5
 * |3 - 7| = 4
 * |8 - 1| = 7
 * |10 - 13| = 3
 * Among all possible differences, the maximum value of 7 is obtained by |8 -
 * 1| = 7.
 * 
 * Example 2:
 * 
 * 
 * Input: root = [1,null,2,null,0,3]
 * Output: 3
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [2, 5000].
 * 0 <= Node.val <= 10^5
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
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }
    
    int dfs(TreeNode root, int min, int max) {
        if (root == null)
            return 0;
        int ans = Math.max(Math.abs(min-root.val), Math.abs(max-root.val));
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        ans = Math.max(ans, dfs(root.left, min, max));
        ans = Math.max(ans, dfs(root.right, min, max));
        return ans;
    }
}
