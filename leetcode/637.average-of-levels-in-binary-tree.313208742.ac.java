/*
 * @lc app=leetcode id=637 lang=java
 *
 * [637] Average of Levels in Binary Tree
 *
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/description/
 *
 * algorithms
 * Easy (64.21%)
 * Total Accepted:    147.5K
 * Total Submissions: 229.7K
 * Testcase Example:  '[3,9,20,15,7]'
 *
 * Given a non-empty binary tree, return the average value of the nodes on each
 * level in the form of an array.
 * 
 * Example 1:
 * 
 * Input:
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * Output: [3, 14.5, 11]
 * Explanation:
 * The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on
 * level 2 is 11. Hence return [3, 14.5, 11].
 * 
 * 
 * 
 * Note:
 * 
 * The range of node's value is in the range of 32-bit signed integer.
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
    
    List<Double> ans = new ArrayList<>();
    List<Integer> cnt = new ArrayList<>();
    
    public List<Double> averageOfLevels(TreeNode root) {
        dfs(root, 0);
        for (int i = 0; i < ans.size(); i++) {
            ans.set(i, ans.get(i)/cnt.get(i));
        }
        
        return ans;
    }
    
    void dfs(TreeNode root, int depth) {
        if (root == null)
            return;
        if (ans.size() <= depth) {
            ans.add((double) root.val);
            cnt.add(1);
        } else {
            ans.set(depth, ans.get(depth) + root.val);
            cnt.set(depth, cnt.get(depth) + 1);
        }
        dfs(root.left, depth+1);
        dfs(root.right, depth+1);
        return;
    }
}
