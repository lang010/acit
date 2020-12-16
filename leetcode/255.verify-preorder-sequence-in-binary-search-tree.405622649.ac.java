/*
 * @lc app=leetcode id=255 lang=java
 *
 * [255] Verify Preorder Sequence in Binary Search Tree
 *
 * https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree/description/
 *
 * algorithms
 * Medium (45.99%)
 * Total Accepted:    52.2K
 * Total Submissions: 113.5K
 * Testcase Example:  '[5,2,6,1,3]'
 *
 * Given an array of numbers, verify whether it is the correct preorder
 * traversal sequence of a binary search tree.
 * 
 * You may assume each number in the sequence is unique.
 * 
 * Consider the following binary search tree: 
 * 
 * 
 * ⁠    5
 * ⁠   / \
 * ⁠  2   6
 * ⁠ / \
 * ⁠1   3
 * 
 * Example 1:
 * 
 * 
 * Input: [5,2,6,1,3]
 * Output: false
 * 
 * Example 2:
 * 
 * 
 * Input: [5,2,1,3,6]
 * Output: true
 * 
 * Follow up:
 * Could you do it using only constant space complexity?
 * 
 */
class Solution {
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        int lower = Integer.MIN_VALUE;
        for (int v : preorder) {
            if (v < lower)
                return false;
            while (!stack.isEmpty() && stack.peek() < v)
                lower = stack.pop();
            stack.push(v);
        }
        return true;
    }
}
