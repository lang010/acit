/*
 * @lc app=leetcode id=1214 lang=java
 *
 * [1214] Two Sum BSTs
 *
 * https://leetcode.com/problems/two-sum-bsts/description/
 *
 * algorithms
 * Medium (67.77%)
 * Total Accepted:    17.4K
 * Total Submissions: 25.7K
 * Testcase Example:  '[2,1,4]\n[1,0,3]\n5'
 *
 * Given two binary search trees, return True if and only if there is a node in
 * the first tree and a node in the second tree whose values sum up to a given
 * integer target.
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: root1 = [2,1,4], root2 = [1,0,3], target = 5
 * Output: true
 * Explanation: 2 and 3 sum up to 5.
 * 
 * 
 * Example 2:
 * 
 * 
 * 
 * 
 * Input: root1 = [0,-10,10], root2 = [5,1,7,0,2], target = 18
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * Each tree has at most 5000 nodes.
 * -10^9 <= target, node.val <= 10^9
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
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if (root1 == null)
            return false;
        if (find(root2, target-root1.val))
            return true;
        return twoSumBSTs(root1.left, root2, target) || twoSumBSTs(root1.right, root2, target);
    }
    
    boolean find(TreeNode r, int t) {
        if (r == null)
            return false;
        if (r.val == t)
            return true;
        if (r.val > t)
            return find(r.left, t);
        return find(r.right, t);
    }
}
