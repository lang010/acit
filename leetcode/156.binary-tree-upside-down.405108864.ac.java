/*
 * @lc app=leetcode id=156 lang=java
 *
 * [156] Binary Tree Upside Down
 *
 * https://leetcode.com/problems/binary-tree-upside-down/description/
 *
 * algorithms
 * Medium (55.85%)
 * Total Accepted:    64.4K
 * Total Submissions: 115.4K
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * Given the root of a binary tree, turn the tree upside down and return the
 * new root.
 * 
 * You can turn a binary tree upside down with the following steps:
 * 
 * 
 * The original left child becomes the new root.
 * The original root becomes the new right child.
 * The original right child becomes the new left child.
 * 
 * 
 * 
 * 
 * The mentioned steps are done level by level, it is guaranteed that every
 * node in the given tree has either 0 or 2 children.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,2,3,4,5]
 * Output: [4,5,2,null,null,3,1]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = []
 * Output: []
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: root = [1]
 * Output: [1]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree will be in the range [0, 10].
 * 1 <= Node.val <= 10
 * Every node has either 0 or 2 children.
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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null)
            return root;
        TreeNode newRoot = root;
        while (newRoot.left != null)
            newRoot = newRoot.left;
        Queue<TreeNode[]> queue = new ArrayDeque<>();
        if (root.left != null) {
            queue.offer(new TreeNode[] {root, root.left, root.right});
            root.left = root.right = null;
        }
        while (!queue.isEmpty()) {
            TreeNode[] arr = queue.poll();
            if (arr[1].left != null) {
                queue.offer(new TreeNode[] {arr[1], arr[1].left, arr[1].right});
            }
            if (arr[2] != null && arr[2].left != null) {
                queue.offer(new TreeNode[] {arr[2], arr[2].left, arr[2].right});
            }
            arr[1].left = arr[2];
            arr[1].right = arr[0];
            if (arr[2] != null)
                arr[2].left = arr[2].right = null;
        }
        return newRoot;
    }
}
