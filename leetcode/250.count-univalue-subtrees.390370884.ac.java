/*
 * @lc app=leetcode id=250 lang=java
 *
 * [250] Count Univalue Subtrees
 *
 * https://leetcode.com/problems/count-univalue-subtrees/description/
 *
 * algorithms
 * Medium (52.87%)
 * Total Accepted:    77.4K
 * Total Submissions: 146.5K
 * Testcase Example:  '[5,1,5,5,5,null,5]'
 *
 * Given the root of a binary tree, return the number of uni-value subtrees.
 * 
 * A uni-value subtree means all nodes of the subtree have the same value.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [5,1,5,5,5,null,5]
 * Output: 4
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = []
 * Output: 0
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: root = [5,5,5,5,5,null,5]
 * Output: 6
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The numbrt of the node in the tree will be in the range [0, 1000].
 * -1000 <= Node.val <= 1000
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
    int cnt = 0;
    public int countUnivalSubtrees(TreeNode root) {
        dfs(root);
        return cnt;
    }
    
    int dfs(TreeNode r) {
        if (r == null)
            return 0;
        boolean is = true;
        if (r.left != null && dfs(r.left) != r.val) {
            is = false;
        }
        if (r.right != null && dfs(r.right) != r.val) {
            is = false;
        }
        if (is) {
            cnt++;
            return r.val;
        }
        return Integer.MAX_VALUE;
    }
}
