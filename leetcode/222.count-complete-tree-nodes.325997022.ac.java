/*
 * @lc app=leetcode id=222 lang=java
 *
 * [222] Count Complete Tree Nodes
 *
 * https://leetcode.com/problems/count-complete-tree-nodes/description/
 *
 * algorithms
 * Medium (48.41%)
 * Total Accepted:    267.9K
 * Total Submissions: 553.2K
 * Testcase Example:  '[1,2,3,4,5,6]'
 *
 * Given a complete binary tree, count the number of nodes.
 * 
 * Note: 
 * 
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is
 * completely filled, and all nodes in the last level are as far left as
 * possible. It can have between 1 and 2^h nodes inclusive at the last level
 * h.
 * 
 * Example:
 * 
 * 
 * Input: 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   3
 * ⁠/ \  /
 * 4  5 6
 * 
 * Output: 6
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
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null)
            return 1;
        int dl = depth(root.left);
        int dr = depth(root.right);
        if (dl > dr) {
            return (1<<dr) + countNodes(root.left);
        } else {
            return (1<<dl) + countNodes(root.right);
        }
    }
    
    int depth(TreeNode root) {
        int ans = 0;
        while (root != null) {
            ans++;
            root = root.left;
        }
        return ans;
    }
}
