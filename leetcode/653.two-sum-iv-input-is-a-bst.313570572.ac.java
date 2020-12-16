/*
 * @lc app=leetcode id=653 lang=java
 *
 * [653] Two Sum IV - Input is a BST
 *
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
 *
 * algorithms
 * Easy (55.98%)
 * Total Accepted:    170.9K
 * Total Submissions: 305.3K
 * Testcase Example:  '[5,3,6,2,4,null,7]\n9'
 *
 * Given the root of a Binary Search Tree and a target number k, return true if
 * there exist two elements in the BST such that their sum is equal to the
 * given target.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [5,3,6,2,4,null,7], k = 9
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [5,3,6,2,4,null,7], k = 28
 * Output: false
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: root = [2,1,3], k = 4
 * Output: true
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: root = [2,1,3], k = 1
 * Output: false
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: root = [2,1,3], k = 3
 * Output: true
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [1, 10^4].
 * -10^4 <= Node.val <= 10^4
 * root is guaranteed to be a valid binary search tree.
 * -10^5 <= k <= 10^5
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
    TreeNode root;
    public boolean findTarget(TreeNode root, int k) {
        this.root = root;
        return target(root, k);
    }
    
    boolean target(TreeNode node, int k) {
        if (node == null)
            return false;
        if (k != node.val * 2 && find(root, k - node.val))
            return true;
        return target(node.left, k) || target(node.right, k);
    }
    
    boolean find(TreeNode node, int v) {
        if (node == null)
            return false;
        if (node.val == v)
            return true;
        if (node.val < v)
            return find(node.right, v);
        return find(node.left, v);
    }
}
