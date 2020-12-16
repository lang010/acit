/*
 * @lc app=leetcode id=513 lang=java
 *
 * [513] Find Bottom Left Tree Value
 *
 * https://leetcode.com/problems/find-bottom-left-tree-value/description/
 *
 * algorithms
 * Medium (62.16%)
 * Total Accepted:    118.2K
 * Total Submissions: 190.2K
 * Testcase Example:  '[2,1,3]'
 *
 * Given the root of a binary tree, return the leftmost value in the last row
 * of the tree.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [2,1,3]
 * Output: 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [1,2,3,4,null,5,6,null,null,7]
 * Output: 7
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [1, 10^4].
 * -2^31 <= Node.val <= 2^31 - 1
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
    int level = -1;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return ans;
    }
    
    void dfs(TreeNode root, int depth) {
        if (root == null)
            return;
        if (level < depth) {
            level = depth;
            ans = root.val;
        }
        dfs(root.left, depth+1);
        dfs(root.right, depth+1);
    }
}
