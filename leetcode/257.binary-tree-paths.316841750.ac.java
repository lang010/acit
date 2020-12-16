/*
 * @lc app=leetcode id=257 lang=java
 *
 * [257] Binary Tree Paths
 *
 * https://leetcode.com/problems/binary-tree-paths/description/
 *
 * algorithms
 * Easy (52.82%)
 * Total Accepted:    358K
 * Total Submissions: 677.8K
 * Testcase Example:  '[1,2,3,null,5]'
 *
 * Given a binary tree, return all root-to-leaf paths.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * 
 * Input:
 * 
 * ⁠  1
 * ⁠/   \
 * 2     3
 * ⁠\
 * ⁠ 5
 * 
 * Output: ["1->2->5", "1->3"]
 * 
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        backtracking(root, "", ans);
        return ans;
    }
    
    void backtracking(TreeNode root, String pre, List<String> ans) {
        if (root == null) {
            return;
        }
        if (!"".equals(pre))
            pre = pre + "->";
        pre = pre + root.val;
        if (root.left == null && root.right == null) {
            ans.add(pre);
            return;
        }
        backtracking(root.left, pre, ans);
        backtracking(root.right, pre, ans);
    }
}
