/*
 * @lc app=leetcode id=872 lang=java
 *
 * [872] Leaf-Similar Trees
 *
 * https://leetcode.com/problems/leaf-similar-trees/description/
 *
 * algorithms
 * Easy (64.54%)
 * Total Accepted:    108.2K
 * Total Submissions: 167.6K
 * Testcase Example:  '[3,5,1,6,2,9,8,null,null,7,4]\n' +
  '[3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]'
 *
 * Consider all the leaves of a binary tree, from left to right order, the
 * values of those leaves form a leaf value sequence.
 * 
 * 
 * 
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4,
 * 9, 8).
 * 
 * Two binary trees are considered leaf-similar if their leaf value sequence is
 * the same.
 * 
 * Return true if and only if the two given trees with head nodes root1 and
 * root2 are leaf-similar.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 =
 * [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root1 = [1], root2 = [1]
 * Output: true
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: root1 = [1], root2 = [2]
 * Output: false
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: root1 = [1,2], root2 = [2,2]
 * Output: true
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: root1 = [1,2,3], root2 = [1,3,2]
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in each tree will be in the range [1, 200].
 * Both of the given trees will have values in the range [0, 200].
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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        dfs(root1, l1);
        dfs(root2, l2);
        if (l1.size() == l2.size()) {
            for (int i = 0; i < l1.size(); i++)
                if (l1.get(i) != l2.get(i))
                    return false;
            return true;
        }
        return false;
    }
    
    void dfs(TreeNode r, List<Integer> l) {
        if (r == null)
            return;
        if (r.left == null && r.right == null) {
            l.add(r.val);
            return;
        }
        dfs(r.left, l);
        dfs(r.right, l);
    }
}
