/*
 * @lc app=leetcode id=118 lang=java
 *
 * [118] Pascal's Triangle
 *
 * https://leetcode.com/problems/pascals-triangle/description/
 *
 * algorithms
 * Easy (54.02%)
 * Total Accepted:    437.2K
 * Total Submissions: 809.3K
 * Testcase Example:  '5'
 *
 * Given a non-negative integer numRows, generate the first numRows of Pascal's
 * triangle.
 * 
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it.
 * 
 * Example:
 * 
 * 
 * Input: 5
 * Output:
 * [
 * ⁠    [1],
 * ⁠   [1,1],
 * ⁠  [1,2,1],
 * ⁠ [1,3,3,1],
 * ⁠[1,4,6,4,1]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> ls = new ArrayList<>(i+1);
            ls.add(1);
            for (int j = 1; j < i; j++) {
                ls.add(ret.get(i-1).get(j-1) + ret.get(i-1).get(j));
            }
            if (i > 0) {
                ls.add(1);
            }
            ret.add(ls);
        }
        
        return ret;
    }
}
