/*
 * @lc app=leetcode id=333 lang=java
 *
 * [333] Largest BST Subtree
 *
 * https://leetcode.com/problems/largest-bst-subtree/description/
 *
 * algorithms
 * Medium (37.04%)
 * Total Accepted:    53.9K
 * Total Submissions: 145.5K
 * Testcase Example:  '[10,5,15,1,8,null,7]'
 *
 * Given the root of a binary tree, find the largest subtree, which is also a
 * Binary Search Tree (BST), where the largest means subtree has the largest
 * number of nodes.
 * 
 * A Binary Search Tree (BST) is a tree in which all the nodes follow the
 * below-mentioned properties:
 * 
 * 
 * The left subtree values are less than the value of their parent (root)
 * node's value.
 * The right subtree values are greater than the value of their parent (root)
 * node's value.
 * 
 * 
 * Note: A subtree must include all of its descendants.
 * 
 * Follow up: Can you figure out ways to solve it with O(n) time complexity?
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: root = [10,5,15,1,8,null,7]
 * Output: 3
 * Explanation: The Largest BST Subtree in this case is the highlighted one.
 * The return value is the subtree's size, which is 3.
 * 
 * Example 2:
 * 
 * 
 * Input: root = [4,2,7,2,3,5,null,2,null,null,null,null,null,1]
 * Output: 2
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [0, 10^4].
 * -10^4 <= Node.val <= 10^4
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
    
    static class Node {
        boolean is;
        int min, max;
        int cnt;
    }
    int max = 0;
    public int largestBSTSubtree(TreeNode root) {
        dfs(root);
        return max;
    }
    
    Node dfs(TreeNode root) {
        if (root == null)
            return null;
        Node ans = new Node();
        ans.is = true;
        ans.min = root.val;
        ans.max = root.val;
        ans.cnt = 1;
        Node l = dfs(root.left);
        Node r = dfs(root.right);
        if (l != null) {
            ans.is = l.is && root.val > l.max;
            ans.min = l.min;
            ans.cnt += l.cnt;
        }
        if (r != null) {
            ans.is = ans.is && r.is && root.val < r.min;
            ans.max = r.max;
            ans.cnt += r.cnt;
        }
        if (ans.is)
            max = Math.max(max, ans.cnt);
        return ans;
    }
}
