/*
 * @lc app=leetcode id=96 lang=java
 *
 * [96] Unique Binary Search Trees
 *
 * https://leetcode.com/problems/unique-binary-search-trees/description/
 *
 * algorithms
 * Medium (53.93%)
 * Total Accepted:    336.6K
 * Total Submissions: 624.2K
 * Testcase Example:  '3'
 *
 * Given n, how many structurally unique BST's (binary search trees) that store
 * values 1 ... n?
 * 
 * Example:
 * 
 * 
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
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
 * 1 <= n <= 19
 * 
 * 
 */
class Solution {
    public int numTrees(int n) {
        if (n < 2)
            return n;
        int[] ans = new int[n+1];
        ans[1] = 1;
        ans[2] = 2;
        int id = 3;
        while (id <= n) {
            ans[id] = ans[id-1] * 2;
            for (int i = 1; i < id-1; i++) {
                ans[id] += ans[i] * ans[id-1-i];
            }
            id++;
        }
        return ans[n];
    }
}
