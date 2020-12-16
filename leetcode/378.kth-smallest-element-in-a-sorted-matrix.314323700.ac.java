/*
 * @lc app=leetcode id=378 lang=java
 *
 * [378] Kth Smallest Element in a Sorted Matrix
 *
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
 *
 * algorithms
 * Medium (55.62%)
 * Total Accepted:    226.2K
 * Total Submissions: 406.7K
 * Testcase Example:  '[[1,5,9],[10,11,13],[12,13,15]]\n8'
 *
 * Given a n x n matrix where each of the rows and columns are sorted in
 * ascending order, find the kth smallest element in the matrix.
 * 
 * 
 * Note that it is the kth smallest element in the sorted order, not the kth
 * distinct element.
 * 
 * 
 * Example:
 * 
 * matrix = [
 * ⁠  [ 1,  5,  9],
 * ⁠  [10, 11, 13],
 * ⁠  [12, 13, 15]
 * ],
 * k = 8,
 * 
 * return 13.
 * 
 * 
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ n^2.
 */
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        int i = 0;
        int j = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++)
                if (pq.size() < k)
                    pq.add(matrix[i][j]);
                else if (pq.peek() > matrix[i][j]) {
                    pq.poll();
                    pq.add(matrix[i][j]);
                } else
                    break;
        }
        return pq.peek();
    }
}
