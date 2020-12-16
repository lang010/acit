/*
 * @lc app=leetcode id=1430 lang=java
 *
 * [1430] Check If a String Is a Valid Sequence from Root to Leaves Path in a Binary Tree
 *
 * https://leetcode.com/problems/check-if-a-string-is-a-valid-sequence-from-root-to-leaves-path-in-a-binary-tree/description/
 *
 * algorithms
 * Medium (45.01%)
 * Total Accepted:    35.6K
 * Total Submissions: 79.1K
 * Testcase Example:  '[0,1,0,0,1,0,null,null,1,0,0]\n[0,1,0,1]'
 *
 * Given a binary tree where each path going from the root to any leaf form a
 * valid sequence, check if a given string is a valid sequence in such binary
 * tree. 
 * 
 * We get the given string from the concatenation of an array of integers arr
 * and the concatenation of all values of the nodes along a path results in a
 * sequence in the given binary tree.
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,0,1]
 * Output: true
 * Explanation: 
 * The path 0 -> 1 -> 0 -> 1 is a valid sequence (green color in the figure). 
 * Other valid sequences are: 
 * 0 -> 1 -> 1 -> 0 
 * 0 -> 0 -> 0
 * 
 * 
 * Example 2:
 * 
 * 
 * 
 * 
 * Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,0,1]
 * Output: false 
 * Explanation: The path 0 -> 0 -> 1 does not exist, therefore it is not even a
 * sequence.
 * 
 * 
 * Example 3:
 * 
 * 
 * 
 * 
 * Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,1]
 * Output: false
 * Explanation: The path 0 -> 1 -> 1 is a sequence, but it is not a valid
 * sequence.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= arr.length <= 5000
 * 0 <= arr[i] <= 9
 * Each node's value is between [0 - 9].
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
    public boolean isValidSequence(TreeNode root, int[] arr) {
        return dfs(root, arr, 0);
    }
    
    boolean dfs(TreeNode r, int[] arr, int cur) {
        if (r == null)
            return false;
        if (r.val != arr[cur])
            return false;
        if (cur == arr.length - 1) {
            if (r.left == null && r.right == null)
                return true;
            return false;
        }
        return dfs(r.left, arr, cur+1) || dfs(r.right, arr, cur+1);
    }
}
