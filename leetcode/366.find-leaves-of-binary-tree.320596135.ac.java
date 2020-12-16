/*
 * @lc app=leetcode id=366 lang=java
 *
 * [366] Find Leaves of Binary Tree
 *
 * https://leetcode.com/problems/find-leaves-of-binary-tree/description/
 *
 * algorithms
 * Medium (71.40%)
 * Total Accepted:    79.6K
 * Total Submissions: 111.5K
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * Given a binary tree, collect a tree's nodes as if you were doing this:
 * Collect and remove all leaves, repeat until the tree is empty.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: [1,2,3,4,5]
 * 
 * 1
 * ⁠        / \
 * ⁠       2   3
 * ⁠      / \     
 * ⁠     4   5    
 * 
 * Output: [[4,5,3],[2],[1]]
 * 
 * 
 * 
 * 
 * Explanation:
 * 
 * 1. Removing the leaves [4,5,3] would result in this tree:
 * 
 * 
 * ⁠         1
 * ⁠        / 
 * ⁠       2          
 * 
 * 
 * 
 * 
 * 2. Now removing the leaf [2] would result in this tree:
 * 
 * 
 * ⁠         1          
 * 
 * 
 * 
 * 
 * 3. Now removing the leaf [1] would result in the empty tree:
 * 
 * 
 * ⁠         []         
 * 
 * [[3,5,4],[2],[1]], [[3,4,5],[2],[1]], etc, are also consider correct answers
 * since per each level it doesn't matter the order on which elements are
 * returned.
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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        while (root != null) {
            List<Integer> ls = new ArrayList<>();
            ans.add(ls);
            root = dfs(root, ls);
        }
        
        return ans;
    }
    
    TreeNode dfs(TreeNode root, List<Integer> ls) {
        if (root == null)
            return root;
        if (root.left == null && root.right == null) {
            ls.add(root.val);
            return null;
        }
        root.left = dfs(root.left, ls);
        root.right = dfs(root.right, ls);
        return root;
    }
}
