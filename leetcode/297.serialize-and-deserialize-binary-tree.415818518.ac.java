/*
 * @lc app=leetcode id=297 lang=java
 *
 * [297] Serialize and Deserialize Binary Tree
 *
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
 *
 * algorithms
 * Hard (49.05%)
 * Total Accepted:    389.3K
 * Total Submissions: 793.6K
 * Testcase Example:  '[1,2,3,null,null,4,5]'
 *
 * Serialization is the process of converting a data structure or object into a
 * sequence of bits so that it can be stored in a file or memory buffer, or
 * transmitted across a network connection link to be reconstructed later in
 * the same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary tree. There is no
 * restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and
 * this string can be deserialized to the original tree structure.
 * 
 * Clarification: The input/output format is the same as how LeetCode
 * serializes a binary tree. You do not necessarily need to follow this format,
 * so please be creative and come up with different approaches yourself.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,2,3,null,null,4,5]
 * Output: [1,2,3,null,null,4,5]
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
 * Example 4:
 * 
 * 
 * Input: root = [1,2]
 * Output: [1,2]
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
public class Codec {
    
     public String serialize(TreeNode root) {
         if (root == null)
             return "null";
         TreeNode e = new TreeNode();
         Queue<TreeNode> queue = new ArrayDeque<>();
         queue.offer(root);
         StringBuilder sb = new StringBuilder();
         while (!queue.isEmpty()) {
             TreeNode node = queue.poll();
             if (sb.length() > 0)
                 sb.append(',');
             if (node == e)
                 sb.append("null");
             else {
                 sb.append(node.val);
                 queue.offer(node.left == null ? e : node.left);
                 queue.offer(node.right == null ? e : node.right);
             }
         }
         return sb.toString();
     }
    
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        TreeNode root = arr[0].equals("null") ? null : new TreeNode(Integer.valueOf(arr[0]));
        if (root == null)
            return root;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int id = 1;
        int n = arr.length;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (id < n) {
                node.left = arr[id].equals("null") ? null : new TreeNode(Integer.valueOf(arr[id]));
                id++;
            }
            if (id < n) {
                node.right = arr[id].equals("null") ? null : new TreeNode(Integer.valueOf(arr[id]));
                id++;
            }
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }
        return root;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
