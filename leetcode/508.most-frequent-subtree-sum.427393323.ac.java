/*
 * @lc app=leetcode id=508 lang=java
 *
 * [508] Most Frequent Subtree Sum
 *
 * https://leetcode.com/problems/most-frequent-subtree-sum/description/
 *
 * algorithms
 * Medium (58.77%)
 * Total Accepted:    78.3K
 * Total Submissions: 133.2K
 * Testcase Example:  '[5,2,-3]'
 *
 * 
 * Given the root of a tree, you are asked to find the most frequent subtree
 * sum. The subtree sum of a node is defined as the sum of all the node values
 * formed by the subtree rooted at that node (including the node itself). So
 * what is the most frequent subtree sum value? If there is a tie, return all
 * the values with the highest frequency in any order.
 * 
 * 
 * Examples 1
 * Input:
 * 
 * ⁠ 5
 * ⁠/  \
 * 2   -3
 * 
 * return [2, -3, 4], since all the values happen only once, return all of them
 * in any order.
 * 
 * 
 * Examples 2
 * Input:
 * 
 * ⁠ 5
 * ⁠/  \
 * 2   -5
 * 
 * return [2], since 2 happens twice, however -5 only occur once.
 * 
 * 
 * Note:
 * You may assume the sum of values in any subtree is in the range of 32-bit
 * signed integer.
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
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null)
            return new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map);
        int n = 1;
        int max = 0;
        for (int x : map.values())
            if (x == max)
                n++;
            else if (x > max) {
                max = x;
                n = 1;
            }
        int t = 0;
        int[] ans = new int[n];
        for (int x : map.keySet())
            if (map.get(x) == max)
                ans[t++] = x;
        return ans;
    }
    
    int dfs(TreeNode node, Map<Integer, Integer> map) {
        if (node == null)
            return 0;
        int v = dfs(node.left, map) + dfs(node.right, map) + node.val;
        map.put(v, map.getOrDefault(v, 0) + 1);
        return v;
    }
}
