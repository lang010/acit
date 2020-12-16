/*
 * @lc app=leetcode id=701 lang=java
 *
 * [701] Insert into a Binary Search Tree
 *
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/description/
 *
 * algorithms
 * Medium (75.85%)
 * Total Accepted:    157.3K
 * Total Submissions: 207.4K
 * Testcase Example:  '[4,2,7,1,3]\n5'
 *
 * You are given the root node of a binary search tree (BST) and a value to
 * insert into the tree. Return the root node of the BST after the insertion.
 * It is guaranteed that the new value does not exist in the original BST.
 * 
 * Notice that there may exist multiple valid ways for the insertion, as long
 * as the tree remains a BST after insertion. You can return any of them.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [4,2,7,1,3], val = 5
 * Output: [4,2,7,1,3,5]
 * Explanation: Another accepted tree is:
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [40,20,60,10,30,50,70], val = 25
 * Output: [40,20,60,10,30,50,70,null,null,25]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
 * Output: [4,2,7,1,3,5]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree will be in the range [0, 10^4].
 * -10^8 <= Node.val <= 10^8
 * All the values Node.val are unique.
 * -10^8 <= val <= 10^8
 * It's guaranteed that val does not exist in the original BST.
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode r = root;
        while (true) {
            if (r.val > val) {
                if (r.left == null) {
                    r.left = new TreeNode(val);
                    return root;
                }
                r = r.left;
            } else if (r.val < val) {
                if (r.right == null) {
                    r.right = new TreeNode(val);
                    return root;
                }
                r = r.right;
            }
        }
    }
}
