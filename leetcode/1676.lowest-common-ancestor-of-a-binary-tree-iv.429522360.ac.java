/*
 * @lc app=leetcode id=1676 lang=java
 *
 * [1676] Lowest Common Ancestor of a Binary Tree IV
 *
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iv/description/
 *
 * algorithms
 * Medium (76.68%)
 * Total Accepted:    1.3K
 * Total Submissions: 1.6K
 * Testcase Example:  '[3,5,1,6,2,0,8,null,null,7,4]\n[4,7]'
 *
 * Given the root of a binary tree and an array of TreeNode objects nodes,
 * return the lowest common ancestor (LCA) of all the nodes in nodes. All the
 * nodes will exist in the tree, and all values of the tree's nodes are
 * unique.
 * 
 * Extending the definition of LCA on Wikipedia: "The lowest common ancestor of
 * n nodes p1, p2, ..., pn in a binary tree T is the lowest node that has every
 * pi as a descendant (where we allow a node to be a descendant of itself) for
 * every valid i". A descendant of a node x is a node y that is on the path
 * from node x to some leaf node.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], nodes = [4,7]
 * Output: 2
 * Explanation: The lowest common ancestor of nodes 4 and 7 is node 2.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], nodes = [1]
 * Output: 1
 * Explanation: The lowest common ancestor of a single node is the node
 * itself.
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], nodes = [7,6,2,4]
 * Output: 5
 * Explanation: The lowest common ancestor of the nodes 7, 6, 2, and 4 is node
 * 5.
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], nodes = [0,1,2,3,4,5,6,7,8]
 * Output: 3
 * Explanation: The lowest common ancestor of all the nodes is the root
 * node.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [1, 10^4].
 * -10^9 <= Node.val <= 10^9
 * All Node.val are unique.
 * All nodes[i] will exist in the tree.
 * All nodes[i] are distinct.
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
    TreeNode ans = null;
    Set<TreeNode> set = new HashSet<>();
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        for (TreeNode node : nodes)
            set.add(node);
        dfs(root);
        return ans;
    }
    
    int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int l = ans == null ? dfs(root.left) : 0;
        int r = ans == null ? dfs(root.right) : 0;
        if (set.contains(root))
            r++;
        if (ans == null && l+r == set.size()) {
            ans = root;
        }
        return l+r;
    }
}