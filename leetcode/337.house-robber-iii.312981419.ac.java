/*
 * @lc app=leetcode id=337 lang=java
 *
 * [337] House Robber III
 *
 * https://leetcode.com/problems/house-robber-iii/description/
 *
 * algorithms
 * Medium (51.58%)
 * Total Accepted:    192.7K
 * Total Submissions: 373.5K
 * Testcase Example:  '[3,2,3,null,3,null,1]'
 *
 * The thief has found himself a new place for his thievery again. There is
 * only one entrance to this area, called the "root." Besides the root, each
 * house has one and only one parent house. After a tour, the smart thief
 * realized that "all houses in this place forms a binary tree". It will
 * automatically contact the police if two directly-linked houses were broken
 * into on the same night.
 * 
 * Determine the maximum amount of money the thief can rob tonight without
 * alerting the police.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,2,3,null,3,null,1]
 * 
 * ⁠    3
 * ⁠   / \
 * ⁠  2   3
 * ⁠   \   \ 
 * ⁠    3   1
 * 
 * Output: 7 
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * 
 * Example 2:
 * 
 * 
 * Input: [3,4,5,1,3,null,1]
 * 
 * 3
 * ⁠   / \
 * ⁠  4   5
 * ⁠ / \   \ 
 * ⁠1   3   1
 * 
 * Output: 9
 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
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
    public int rob(TreeNode root) {
        int[] ans = dfs(root);
        return Math.max(ans[0], ans[1]);
    }
    
    int[] dfs(TreeNode root) {
        if (root == null)
            return new int[] {0, 0};
        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        int[] ans = {0, 0};
        ans[0] = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        ans[1] = root.val + l[0] + r[0];
        
        return ans;
    }
}
