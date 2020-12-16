/*
 * @lc app=leetcode id=95 lang=java
 *
 * [95] Unique Binary Search Trees II
 *
 * https://leetcode.com/problems/unique-binary-search-trees-ii/description/
 *
 * algorithms
 * Medium (41.80%)
 * Total Accepted:    212.6K
 * Total Submissions: 508.7K
 * Testcase Example:  '3'
 *
 * Given an integer n, generate all structurally unique BST's (binary search
 * trees) that store values 1 ... n.
 * 
 * Example:
 * 
 * 
 * Input: 3
 * Output:
 * [
 * [1,null,3,2],
 * [3,2,null,1],
 * [3,1,null,null,2],
 * [2,1,3],
 * [1,null,2,null,3]
 * ]
 * Explanation:
 * The above output corresponds to the 5 unique BST's shown below:
 * 
 * ⁠  1         3     3      2      1
 * ⁠   \       /     /      / \      \
 * ⁠    3     2     1      1   3      2
 * ⁠   /     /       \                 \
 * ⁠  2     1         2                 3
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= n <= 8
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
    public List<TreeNode> generateTrees(int n) {
        if (n < 1)
            return new ArrayList<TreeNode>();
        return build(1, n);
    }
    
    List<TreeNode> build(int b, int e) {
        List<TreeNode> ans = new ArrayList<>();
        if (e < b) {
            ans.add(null);
            return ans;
        }
        if (b == e) {
            TreeNode node = new TreeNode(b);
            ans.add(node);
            return ans;
        }
        for (int i = b; i <= e; i++) {
            List<TreeNode> ln = build(b, i-1);
            List<TreeNode> rn = build(i+1, e);
            for (TreeNode l : ln) {
                for (TreeNode r : rn) {
                    TreeNode node = new TreeNode(i);
                    node.left = l;
                    node.right = r;
                    ans.add(node);
                }
            }
        }

        return ans;
    }
}
