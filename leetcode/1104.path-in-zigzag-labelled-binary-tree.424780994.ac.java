/*
 * @lc app=leetcode id=1104 lang=java
 *
 * [1104] Path In Zigzag Labelled Binary Tree
 *
 * https://leetcode.com/problems/path-in-zigzag-labelled-binary-tree/description/
 *
 * algorithms
 * Medium (72.77%)
 * Total Accepted:    21.5K
 * Total Submissions: 29.5K
 * Testcase Example:  '14'
 *
 * In an infinite binary tree where every node has two children, the nodes are
 * labelled in row order.
 * 
 * In the odd numbered rows (ie., the first, third, fifth,...), the labelling
 * is left to right, while in the even numbered rows (second, fourth,
 * sixth,...), the labelling is right to left.
 * 
 * 
 * 
 * Given the label of a node in this tree, return the labels in the path from
 * the root of the tree to the node with that label.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: label = 14
 * Output: [1,3,4,14]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: label = 26
 * Output: [1,2,6,10,26]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= label <= 10^6
 * 
 * 
 */
class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> ans = new ArrayList<>();
        while (label > 0) {
            ans.add(label);
            label /= 2;
        }
        int n = ans.size();
        int l = 0, r = n-1;
        while (l < r) {
            int t = ans.get(l);
            ans.set(l, ans.get(r));
            ans.set(r, t);
            l++;
            r--;
        }
        for (int i = n-2; i > 0; i -= 2) {
            ans.set(i, (1<<(i+1))-1 - ans.get(i) + (1<<i));
        }
        return ans;
    }
}
