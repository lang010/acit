/*
 * @lc app=leetcode id=536 lang=java
 *
 * [536] Construct Binary Tree from String
 *
 * https://leetcode.com/problems/construct-binary-tree-from-string/description/
 *
 * algorithms
 * Medium (50.02%)
 * Total Accepted:    33.8K
 * Total Submissions: 67.5K
 * Testcase Example:  '"4(2(3)(1))(6(5))"'
 *
 * You need to construct a binary tree from a string consisting of parenthesis
 * and integers.
 * 
 * The whole input represents a binary tree. It contains an integer followed by
 * zero, one or two pairs of parenthesis. The integer represents the root's
 * value and a pair of parenthesis contains a child binary tree with the same
 * structure.
 * 
 * You always start to construct the left child node of the parent first if it
 * exists.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "4(2(3)(1))(6(5))"
 * Output: [4,2,6,3,1,5]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "4(2(3)(1))(6(5)(7))"
 * Output: [4,2,6,3,1,5,7]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "-4(2(3)(1))(6(5)(7))"
 * Output: [-4,2,6,3,1,5,7]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= s.length <= 3 * 10^4
 * s consists of digits, '(', ')', and '-' only.
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
    public TreeNode str2tree(String s) {
        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')')
                stack.pop();
            else if (c == '-' || c >= '0' && c <= '9') {
                int j = i+1;
                while (j < s.length()) {
                    char next = s.charAt(j);
                    if (next >= '0' && next <= '9')
                        j++;
                    else
                        break;
                }
                TreeNode node = new TreeNode(Integer.valueOf(s.substring(i,j)));
                if (!stack.isEmpty()) {
                    TreeNode p = stack.peek();
                    if (p.left == null)
                        p.left = node;
                    else
                        p.right = node;
                }
                stack.push(node);
                i = j-1;
            }
        }
        return stack.isEmpty() ? null : stack.peek();
    }
}
