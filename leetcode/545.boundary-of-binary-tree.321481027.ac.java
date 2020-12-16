/*
 * @lc app=leetcode id=545 lang=java
 *
 * [545] Boundary of Binary Tree
 *
 * https://leetcode.com/problems/boundary-of-binary-tree/description/
 *
 * algorithms
 * Medium (39.30%)
 * Total Accepted:    59.8K
 * Total Submissions: 152.3K
 * Testcase Example:  '[1,null,2,3,4]'
 *
 * A binary tree boundary is the set of nodes (no duplicates) denoting the
 * union of the left boundary, leaves, and right boundary.
 * 
 * The left boundary is the set of nodes on the path from the root to the
 * left-most node. The right boundary is the set of nodes on the path from the
 * root to the right-most node.
 * 
 * The left-most node is the leaf node you reach when you always travel to the
 * left subtree if it exists and the right subtree if it doesn't. The
 * right-most node is defined in the same way except with left and right
 * exchanged. Note that the root may be the left-most and/or right-most node.
 * 
 * Given the root of a binary tree, return the values of its boundary in a
 * counter-clockwise direction starting from the root.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,null,2,3,4]
 * Output: [1,3,4,2]
 * Explanation:
 * The left boundary is the nodes [1,2,3].
 * The right boundary is the nodes [1,2,4].
 * The leaves are nodes [3,4].
 * Unioning the sets together gives [1,2,3,4], which is [1,3,4,2] in
 * counter-clockwise order.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [1,2,3,4,5,6,null,null,null,7,8,9,10]
 * Output: [1,2,4,7,8,9,10,6,3]
 * Explanation:
 * The left boundary are node 1,2,4. (4 is the left-most node according to
 * definition)
 * The left boundary is nodes [1,2,4].
 * The right boundary is nodes [1,3,6,10].
 * The leaves are nodes [4,7,8,9,10].
 * Unioning the sets together gives [1,2,3,4,6,7,8,9,10], which is
 * [1,2,4,7,8,9,10,6,3] in counter-clockwise order.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [0, 10^4].
 * -1000 <= Node.val <= 1000
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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        ans.add(root.val);
        if (root.left != null) {
            TreeNode cur = root.left;
            while (cur != null && (cur.left != null || cur.right != null)) {
                ans.add(cur.val);
                if (cur.left != null)
                    cur = cur.left;
                else
                    cur = cur.right;
            }
        }
        dfs(root.left, ans);
        dfs(root.right, ans);
        List<Integer> ls = new ArrayList<>();
        if (root.right != null) {
            TreeNode cur = root.right;
            while(cur != null && (cur.left != null || cur.right != null)) {
                ls.add(cur.val);
                if (cur.right != null)
                    cur = cur.right;
                else
                    cur = cur.left;
            }
            Collections.reverse(ls);
            ans.addAll(ls);
        }
        return ans;
    }
    
    void dfs(TreeNode node, List<Integer> ans) {
        if (node == null)
            return;
        if (node.left == null && node.right == null) {
            ans.add(node.val);
            return;
        }
        dfs(node.left, ans);
        dfs(node.right, ans);
    }
}
