/*
 * @lc app=leetcode id=1198 lang=java
 *
 * [1198] Find Smallest Common Element in All Rows
 *
 * https://leetcode.com/problems/find-smallest-common-element-in-all-rows/description/
 *
 * algorithms
 * Medium (75.06%)
 * Total Accepted:    11.7K
 * Total Submissions: 15.6K
 * Testcase Example:  '[[1,2,3,4,5],[2,4,5,8,10],[3,5,7,9,11],[1,3,5,7,9]]'
 *
 * Given a matrix mat where every row is sorted in strictly increasing order,
 * return the smallest common element in all rows.
 * 
 * If there is no common element, return -1.
 * 
 * 
 * Example 1:
 * Input: mat = [[1,2,3,4,5],[2,4,5,8,10],[3,5,7,9,11],[1,3,5,7,9]]
 * Output: 5
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= mat.length, mat[i].length <= 500
 * 1 <= mat[i][j] <= 10^4
 * mat[i] is sorted in strictly increasing order.
 * 
 * 
 */
class Solution {
    public int smallestCommonElement(int[][] mat) {
        int n = mat.length;
        int[] pos = new int[n];
        int cur = 0;
        int cnt = 0;
        while (true) {
            for (int i = 0; i < n; i++) {
                while (pos[i] < mat[i].length && mat[i][pos[i]] < cur)
                    pos[i]++;
                if (pos[i] == mat[i].length)
                    return -1;
                if (cur != mat[i][pos[i]]) {
                    cnt = 1;
                    cur = mat[i][pos[i]];
                } else {
                    cnt++;
                    if (cnt == n)
                        return cur;
                }
            }
        }
    }
}
