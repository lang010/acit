/*
 * @lc app=leetcode id=863 lang=java
 *
 * [863] All Nodes Distance K in Binary Tree
 *
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
 *
 * algorithms
 * Medium (57.09%)
 * Total Accepted:    105.8K
 * Total Submissions: 185.2K
 * Testcase Example:  '[3,5,1,6,2,0,8,null,null,7,4]\n5\n2'
 *
 * We are given a binary tree (with root node root), a target node, and an
 * integer value K.
 * 
 * Return a list of the values of all nodes that have a distance K from the
 * target node.  The answer can be returned in any order.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 * 
 * Output: [7,4,1]
 * 
 * Explanation: 
 * The nodes that are a distance 2 from the target node (with value 5)
 * have values 7, 4, and 1.
 * 
 * 
 * 
 * Note that the inputs "root" and "target" are actually TreeNodes.
 * The descriptions of the inputs above are just serializations of these
 * objects.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * The given tree is non-empty.
 * Each node in the tree has unique values 0 <= node.val <= 500.
 * The target node is a node in the tree.
 * 0 <= K <= 1000.
 * 
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
    List<Integer> ans = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        helper(root, target, K, -1);
        return ans;
    }
    
    int helper(TreeNode root, TreeNode t, int K, int cur) {
        if (root == null || cur > K)
            return cur;
        if (root == t)
            cur = 0;
        if (cur < 0) {
            cur = helper(root.left, t, K, -1);
            if (cur < 0) {
                cur = helper(root.right, t, K, -1);
                if (cur < 0)
                    return cur;
                cur++;
                helper(root.left, t, K, cur+1);
            } else {
                cur++;
                helper(root.right, t, K, cur+1);
            }
        } else {
            helper(root.left, t, K, cur+1);
            helper(root.right, t, K, cur+1);
        }
        if (cur == K)
            ans.add(root.val);
        return cur;
    }
}
