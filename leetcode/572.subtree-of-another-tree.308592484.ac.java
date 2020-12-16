/*
 * @lc app=leetcode id=572 lang=java
 *
 * [572] Subtree of Another Tree
 *
 * https://leetcode.com/problems/subtree-of-another-tree/description/
 *
 * algorithms
 * Easy (44.38%)
 * Total Accepted:    262.8K
 * Total Submissions: 592.1K
 * Testcase Example:  '[3,4,5,1,2]\n[4,1,2]'
 *
 * Given two non-empty binary trees s and t, check whether tree t has exactly
 * the same structure and node values with a subtree of s. A subtree of s is a
 * tree consists of a node in s and all of this node's descendants. The tree s
 * could also be considered as a subtree of itself.
 * 
 * Example 1:
 * Given tree s:
 * 
 * 
 * ⁠    3
 * ⁠   / \
 * ⁠  4   5
 * ⁠ / \
 * ⁠1   2
 * 
 * Given tree t:
 * 
 * 
 * ⁠  4 
 * ⁠ / \
 * ⁠1   2
 * 
 * Return true, because t has the same structure and node values with a subtree
 * of s.
 * 
 * 
 * 
 * Example 2:
 * Given tree s:
 * 
 * 
 * ⁠    3
 * ⁠   / \
 * ⁠  4   5
 * ⁠ / \
 * ⁠1   2
 * ⁠   /
 * ⁠  0
 * 
 * Given tree t:
 * 
 * 
 * ⁠  4
 * ⁠ / \
 * ⁠1   2
 * 
 * Return false.
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
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return t == null;
        }
        if (isSame(s, t))
            return true;
        if (isSubtree(s.left, t))
            return true;
        if (isSubtree(s.right, t))
            return true;
        return false;
    }
    
    public boolean isSame(TreeNode s, TreeNode t) {
        if (s == t) {
            return true;
        }
        if (s != null && t != null && s.val == t.val) {
            return isSame(s.left, t.left) && isSame(s.right, t.right);
        }
        
        return false;
    }
}
