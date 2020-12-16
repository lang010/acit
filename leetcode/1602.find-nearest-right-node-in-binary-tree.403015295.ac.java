/*
 * @lc app=leetcode id=1602 lang=java
 *
 * [1602] Find Nearest Right Node in Binary Tree
 *
 * https://leetcode.com/problems/find-nearest-right-node-in-binary-tree/description/
 *
 * algorithms
 * Medium (75.20%)
 * Total Accepted:    2.7K
 * Total Submissions: 3.6K
 * Testcase Example:  '[1,2,3,null,4,5,6]\n4'
 *
 * Given the root of a binary tree and a node u in the tree, return the nearest
 * node on the same level that is to the right of u, or return null if u is the
 * rightmost node in its level.
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: root = [1,2,3,null,4,5,6], u = 4
 * Output: 5
 * Explanation: The nearest node on the same level to the right of node 4 is
 * node 5.
 * 
 * 
 * Example 2:
 * 
 * 
 * 
 * 
 * Input: root = [3,null,4,2], u = 2
 * Output: null
 * Explanation: There are no nodes to the right of 2.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: root = [1], u = 1
 * Output: null
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: root = [3,4,2,null,null,null,1], u = 4
 * Output: 2
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [1, 10^5].
 * 1 <= Node.val <= 10^5
 * All values in the tree are distinct.
 * u is a node in the binary tree rooted at root.
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
    int lvl  = 100000;
    public TreeNode findNeartestRightNode(TreeNode root, TreeNode u) {
        return dfs(root, u, 0);
    }
    
    TreeNode dfs(TreeNode r, TreeNode u, int l) {
        if (r == null)
            return null;
        if (r == u) {
            lvl = l;
            return null;
        }
        if (l == lvl)
            return r;
        TreeNode ans = null;
        if (l < lvl) {
            ans = dfs(r.left, u, l+1);
            if (ans == null)
                ans = dfs(r.right, u, l+1);
        }
        return ans;
    }
}
