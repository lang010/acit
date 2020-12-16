/*
 * @lc app=leetcode id=1439 lang=java
 *
 * [1439] Find the Kth Smallest Sum of a Matrix With Sorted Rows
 *
 * https://leetcode.com/problems/find-the-kth-smallest-sum-of-a-matrix-with-sorted-rows/description/
 *
 * algorithms
 * Hard (59.83%)
 * Total Accepted:    11.9K
 * Total Submissions: 19.9K
 * Testcase Example:  '[[1,3,11],[2,4,6]]\n5'
 *
 * You are given an m * n matrix, mat, and an integer k, which has its rows
 * sorted in non-decreasing order.
 * 
 * You are allowed to choose exactly 1 element from each row to form an array.
 * Return the Kth smallest array sum among all possible arrays.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: mat = [[1,3,11],[2,4,6]], k = 5
 * Output: 7
 * Explanation: Choosing one element from each row, the first k smallest sum
 * are:
 * [1,2], [1,4], [3,2], [3,4], [1,6]. Where the 5th sum is 7.  
 * 
 * Example 2:
 * 
 * 
 * Input: mat = [[1,3,11],[2,4,6]], k = 9
 * Output: 17
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: mat = [[1,10,10],[1,4,5],[2,3,6]], k = 7
 * Output: 9
 * Explanation: Choosing one element from each row, the first k smallest sum
 * are:
 * [1,1,2], [1,1,3], [1,4,2], [1,4,3], [1,1,6], [1,5,2], [1,5,3]. Where the 7th
 * sum is 9.  
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: mat = [[1,1,10],[2,2,9]], k = 7
 * Output: 12
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == mat.length
 * n == mat.length[i]
 * 1 <= m, n <= 40
 * 1 <= k <= min(200, n ^ m)
 * 1 <= mat[i][j] <= 5000
 * mat[i] is a non decreasing array.
 * 
 * 
 */
class Solution {
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
    int k = 0;
    int n = 0;
    int m = 0;
    public int kthSmallest(int[][] mat, int K) {
        k = K;
        n = mat.length;
        m = mat[0].length;
        dfs(mat, 0, 0);
        return pq.peek();
    }
    
    int dfs(int[][] mat, int d, int pre) {
        if (d == n) {
            if (pq.size() < k)
                pq.add(pre);
            else if (pq.peek() > pre) {
                pq.poll();
                pq.offer(pre);
            } else
                return -1;
            return 0;
        }
        if (pq.size() == k && pq.peek() <= pre)
            return -1;
        for (int i = 0; i < m; i++) {
            if (-1 == dfs(mat, d+1, pre+mat[d][i]) && i == 0)
                return -1;
        }
        return 0;
    }
}
