/*
 * @lc app=leetcode id=663 lang=java
 *
 * [663] Equal Tree Partition
 *
 * https://leetcode.com/problems/equal-tree-partition/description/
 *
 * algorithms
 * Medium (39.62%)
 * Total Accepted:    19.7K
 * Total Submissions: 49.8K
 * Testcase Example:  '[5,10,10,null,null,2,3]'
 *
 * 
 * Given a binary tree with n nodes, your task is to check if it's possible to
 * partition the tree to two trees which have the equal sum of values after
 * removing exactly one edge on the original tree.
 * 
 * 
 * Example 1:
 * 
 * Input:     
 * ⁠   5
 * ⁠  / \
 * ⁠ 10 10
 * ⁠   /  \
 * ⁠  2   3
 * 
 * Output: True
 * Explanation: 
 * ⁠   5
 * ⁠  / 
 * ⁠ 10
 * ⁠     
 * Sum: 15
 * 
 * ⁠  10
 * ⁠ /  \
 * ⁠2    3
 * 
 * Sum: 15
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:     
 * ⁠   1
 * ⁠  / \
 * ⁠ 2  10
 * ⁠   /  \
 * ⁠  2   20
 * 
 * Output: False
 * Explanation: You can't split the tree into two trees with equal sum after
 * removing exactly one edge on the tree.
 * 
 * 
 * 
 * Note:
 * 
 * The range of tree node value is in the range of [-100000, 100000].
 * 1 
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
    int sum = 0;
    int half = 0;
    int cnt = 0;
    boolean ans = false;
    public boolean checkEqualTree(TreeNode root) {
        dfs(root);
        if (sum%2 != 0)
            return false;
        half(root);
        return ans;
    }
    
    void dfs(TreeNode r) {
        if (r == null)
            return;
        cnt++;
        sum += r.val;
        dfs(r.left);
        dfs(r.right);
    }
    
    Integer half(TreeNode node) {
        if (node == null || ans)
            return null;
        cnt--;
        Integer l = half(node.left);
        if (l != null && l == sum/2)
            ans = true;
        else if (l == null)
            l = 0;
        Integer r = half(node.right);
        if (r != null && r == sum/2)
            ans = true;
        else if (r == null)
            r = 0;
        return l+r+node.val;
    }
}
