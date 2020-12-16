/*
 * @lc app=leetcode id=1110 lang=java
 *
 * [1110] Delete Nodes And Return Forest
 *
 * https://leetcode.com/problems/delete-nodes-and-return-forest/description/
 *
 * algorithms
 * Medium (67.49%)
 * Total Accepted:    81.6K
 * Total Submissions: 121K
 * Testcase Example:  '[1,2,3,4,5,6,7]\n[3,5]'
 *
 * Given the root of a binary tree, each node in the tree has a distinct
 * value.
 * 
 * After deleting all nodes with a value in to_delete, we are left with a
 * forest (a disjoint union of trees).
 * 
 * Return the roots of the trees in the remaining forest.  You may return the
 * result in any order.
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
 * Output: [[1,2,null,4],[6],[7]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the given tree is at most 1000.
 * Each node has a distinct value between 1 and 1000.
 * to_delete.length <= 1000
 * to_delete contains distinct values between 1 and 1000.
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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ans = new ArrayList<>();
        Set<Integer> delSet = new HashSet<>();
        for (int x : to_delete)
            delSet.add(x);
        helper(root, true, delSet, ans);
        return ans;
    }
    
    TreeNode helper(TreeNode root, boolean isRoot, Set<Integer> delSet, List<TreeNode> ans) {
        if (root == null)
            return root;
        if (delSet.contains(root.val)) {
            helper(root.left, true, delSet, ans);
            helper(root.right, true, delSet, ans);
            return null;
        }
        if (isRoot)
            ans.add(root);
        root.left = helper(root.left, false, delSet, ans);
        root.right = helper(root.right, false, delSet, ans);
        return root;
    }
}
