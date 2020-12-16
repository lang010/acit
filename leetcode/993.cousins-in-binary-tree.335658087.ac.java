/*
 * @lc app=leetcode id=993 lang=java
 *
 * [993] Cousins in Binary Tree
 *
 * https://leetcode.com/problems/cousins-in-binary-tree/description/
 *
 * algorithms
 * Easy (52.11%)
 * Total Accepted:    127.8K
 * Total Submissions: 245.1K
 * Testcase Example:  '[1,2,3,4]\n4\n3'
 *
 * In a binary tree, the root node is at depth 0, and children of each depth k
 * node are at depth k+1.
 * 
 * Two nodes of a binary tree are cousins if they have the same depth, but have
 * different parents.
 * 
 * We are given the root of a binary tree with unique values, and the values x
 * and y of two different nodes in the tree.
 * 
 * Return true if and only if the nodes corresponding to the values x and y are
 * cousins.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: root = [1,2,3,4], x = 4, y = 3
 * Output: false
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * 
 * Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
 * Output: true
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * 
 * 
 * Input: root = [1,2,3,null,4], x = 2, y = 3
 * Output: false
 * 
 * 
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree will be between 2 and 100.
 * Each node has a unique integer value from 1 to 100.
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
    int d1 = -1, d2 = -1;
    TreeNode p1 = null, p2 = null;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, 0, x, y);
        return d1 == d2 && p1 != p2;
    }
    
    void dfs(TreeNode root, int d, int x, int y) {
        if (root == null)
            return;
        if (p1 != null && p2 != null)
            return;
        if (root.left != null) {
            if (root.left.val == x) {
                d1 = d+1;
                p1 = root;
            }
            if (root.left.val == y) {
                d2 = d+1;
                p2 = root;
            }
            dfs(root.left, d+1, x, y);
        }
        if (root.right != null) {
            if (root.right.val == x) {
                d1 = d+1;
                p1 = root;
            }
            if (root.right.val == y) {
                d2 = d+1;
                p2 = root;
            }
            dfs(root.right, d+1, x, y);
        }
    }
}
