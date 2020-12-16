/*
 * @lc app=leetcode id=1382 lang=java
 *
 * [1382] Balance a Binary Search Tree
 *
 * https://leetcode.com/problems/balance-a-binary-search-tree/description/
 *
 * algorithms
 * Medium (75.82%)
 * Total Accepted:    24.2K
 * Total Submissions: 31.9K
 * Testcase Example:  '[1,null,2,null,3,null,4,null,null]'
 *
 * Given a binary search tree, return a balanced binary search tree with the
 * same node values.
 * 
 * A binary search tree is balanced if and only if the depth of the two
 * subtrees of every node never differ by more than 1.
 * 
 * If there is more than one answer, return any of them.
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: root = [1,null,2,null,3,null,4,null,null]
 * Output: [2,1,3,null,null,null,4]
 * Explanation: This is not the only correct answer, [3,1,4,null,2,null,null]
 * is also correct.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is between 1 and 10^4.
 * The tree nodes will have distinct values between 1 and 10^5.
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
    
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        dfs(root, arr);
        return build(arr, 0, arr.size()-1);
    }
    
    void dfs(TreeNode root, List<Integer> arr) {
        if (root == null)
            return;
        dfs(root.left, arr);
        arr.add(root.val);
        dfs(root.right, arr);
    }
    
    TreeNode build(List<Integer> arr, int l, int r) {
        if (l > r)
            return null;
        int m = l + (r-l)/2;
        TreeNode root = new TreeNode(arr.get(m));
        root.left = build(arr, l, m-1);
        root.right = build(arr, m+1, r);
        return root;
    }
}
