/*
 * @lc app=leetcode id=119 lang=java
 *
 * [119] Pascal's Triangle II
 *
 * https://leetcode.com/problems/pascals-triangle-ii/description/
 *
 * algorithms
 * Easy (51.61%)
 * Total Accepted:    342.4K
 * Total Submissions: 663.4K
 * Testcase Example:  '3'
 *
 * Given an integer rowIndex, return the rowIndex^th row of the Pascal's
 * triangle.
 * 
 * Notice that the row index starts from 0.
 * 
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it.
 * 
 * Follow up:
 * 
 * Could you optimize your algorithm to use only O(k) extra space?
 * 
 * 
 * Example 1:
 * Input: rowIndex = 3
 * Output: [1,3,3,1]
 * Example 2:
 * Input: rowIndex = 0
 * Output: [1]
 * Example 3:
 * Input: rowIndex = 1
 * Output: [1,1]
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= rowIndex <= 33
 * 
 * 
 */
class Solution {
    public List<Integer> getRow(int n) {
        List<Integer> ans = new ArrayList<>(n+1);
        for (int i = 0; i <= n; i++)
            ans.add(1);
        for (int i = 0; i < n; i++) {
            int pre = 1;
            for (int j = 1; j <= i; j++) {
                int v = pre + ans.get(j);
                pre = ans.get(j);
                ans.set(j, v);
            }
        }
        return ans;
    }
}
