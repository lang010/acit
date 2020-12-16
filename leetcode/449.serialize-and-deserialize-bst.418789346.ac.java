/*
 * @lc app=leetcode id=449 lang=java
 *
 * [449] Serialize and Deserialize BST
 *
 * https://leetcode.com/problems/serialize-and-deserialize-bst/description/
 *
 * algorithms
 * Medium (53.59%)
 * Total Accepted:    137.4K
 * Total Submissions: 256.5K
 * Testcase Example:  '[2,1,3]'
 *
 * Serialization is converting a data structure or object into a sequence of
 * bits so that it can be stored in a file or memory buffer, or transmitted
 * across a network connection link to be reconstructed later in the same or
 * another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary search tree. There
 * is no restriction on how your serialization/deserialization algorithm should
 * work. You need to ensure that a binary search tree can be serialized to a
 * string, and this string can be deserialized to the original tree structure.
 * 
 * The encoded string should be as compact as possible.
 * 
 * 
 * Example 1:
 * Input: root = [2,1,3]
 * Output: [2,1,3]
 * Example 2:
 * Input: root = []
 * Output: []
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [0, 10^4].
 * 0 <= Node.val <= 10^4
 * The input tree is guaranteed to be a binary search tree.
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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> ans = new ArrayList<>();
        pre(root, ans);
        return String.join(",", ans);
    }
    
    void pre(TreeNode node, List<String> ans) {
        if (node == null)
            return;
        ans.add(String.valueOf(node.val));
        pre(node.left, ans);
        pre(node.right, ans);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("".equals(data))
            return null;
        String[] ls = data.split(",");
        int n = ls.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.valueOf(ls[i]);
        return dfs(arr, 0, n-1);
    }
    
    TreeNode dfs(int[] arr, int l, int r) {
        if (l > r)
            return null;
        TreeNode node = new TreeNode(arr[l]);
        int m = l+1;
        while (m <= r && arr[m] < arr[l])
            m++;
        node.left = dfs(arr, l+1, m-1);
        node.right = dfs(arr, m, r);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
