/*
 * @lc app=leetcode id=1428 lang=java
 *
 * [1428] Leftmost Column with at Least a One
 *
 * https://leetcode.com/problems/leftmost-column-with-at-least-a-one/description/
 *
 * algorithms
 * Medium (48.47%)
 * Total Accepted:    70.4K
 * Total Submissions: 145.2K
 * Testcase Example:  '[[0,0],[1,1]]'
 *
 * (This problem is an interactive problem.)
 * 
 * A row-sorted binary matrix means that all elements are 0 or 1 and each row
 * of the matrix is sorted in non-decreasing order.
 * 
 * Given a row-sorted binary matrix binaryMatrix, return the index (0-indexed)
 * of the leftmost column with a 1 in it. If such an index does not exist,
 * return -1.
 * 
 * You can't access the Binary Matrix directly. You may only access the matrix
 * using a BinaryMatrix interface:
 * 
 * 
 * BinaryMatrix.get(row, col) returns the element of the matrix at index (row,
 * col) (0-indexed).
 * BinaryMatrix.dimensions() returns the dimensions of the matrix as a list of
 * 2 elements [rows, cols], which means the matrix is rows x cols.
 * 
 * 
 * Submissions making more than 1000 calls to BinaryMatrix.get will be judged
 * Wrong Answer. Also, any solutions that attempt to circumvent the judge will
 * result in disqualification.
 * 
 * For custom testing purposes, the input will be the entire binary matrix mat.
 * You will not have access to the binary matrix directly.
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: mat = [[0,0],[1,1]]
 * Output: 0
 * 
 * 
 * Example 2:
 * 
 * 
 * 
 * 
 * Input: mat = [[0,0],[0,1]]
 * Output: 1
 * 
 * 
 * Example 3:
 * 
 * 
 * 
 * 
 * Input: mat = [[0,0],[0,0]]
 * Output: -1
 * 
 * Example 4:
 * 
 * 
 * 
 * 
 * Input: mat = [[0,0,0,1],[0,0,1,1],[0,1,1,1]]
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * rows == mat.length
 * cols == mat[i].length
 * 1 <= rows, cols <= 100
 * mat[i][j] is either 0 or 1.
 * mat[i] is sorted in non-decreasing order.
 * 
 * 
 */
/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int x, int y) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix bm) {
        List<Integer> dim = bm.dimensions();
        int n = dim.get(0);
        int m = dim.get(1);
        int i = 0;
        int j = m-1;
        int ans = -1;
        while (i < n && j >= 0) {
            if (bm.get(i, j) == 1) {
                ans = j;
                j--;
            } else
                i++;
        }
        return ans;
    }
}
