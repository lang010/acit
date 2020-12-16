/*
 * @lc app=leetcode id=1644 lang=java
 *
 * [1644] Lowest Common Ancestor of a Binary Tree II
 *
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii/description/
 *
 * algorithms
 * Medium (58.47%)
 * Total Accepted:    2.5K
 * Total Submissions: 4.3K
 * Testcase Example:  '[3,5,1,6,2,0,8,null,null,7,4]\n5\n1'
 *
 * Given the root of a binary tree, return the lowest common ancestor (LCA) of
 * two given nodes, p and q. If either node p or q does not exist in the tree,
 * return null. All values of the nodes in the tree are unique.
 * 
 * According to the definition of LCA on Wikipedia: "The lowest common ancestor
 * of two nodes p and q in a binary tree T is the lowest node that has both p
 * and q as descendants (where we allow a node to be a descendant of itself)".
 * A descendant of a node x is a node y that is on the path from node x to some
 * leaf node.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * 
 * Example 2:
 * 
 * 
 * 
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5. A node can be a descendant of
 * itself according to the definition of LCA.
 * 
 * Example 3:
 * 
 * 
 * 
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 10
 * Output: null
 * Explanation: Node 10 does not exist in the tree, so return null.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [1, 10^4].
 * -10^9 <= Node.val <= 10^9
 * All Node.val are unique.
 * p != q
 * 
 * 
 * 
 * Follow up: Can you find the LCA traversing the tree, without checking nodes
 * existence?
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
    int cnt = 0;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ans = dfs(root, p, q);
        return cnt != 2 ? null : ans;
    }
    
    TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        TreeNode l = dfs(root.left, p, q);
        TreeNode r = dfs(root.right, p, q);
        if (root == p || root == q) {
            cnt++;
            return root;
        }
        if (l != null && r != null)
            return root;
        return l == null ? r : l;
    }
}
