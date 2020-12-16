/*
 * @lc app=leetcode id=542 lang=java
 *
 * [542] 01 Matrix
 *
 * https://leetcode.com/problems/01-matrix/description/
 *
 * algorithms
 * Medium (40.40%)
 * Total Accepted:    106.8K
 * Total Submissions: 264.3K
 * Testcase Example:  '[[0,0,0],[0,1,0],[0,0,0]]'
 *
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for
 * each cell.
 * 
 * The distance between two adjacent cells is 1.
 * 
 * 
 * 
 * Example 1: 
 * 
 * 
 * Input:
 * [[0,0,0],
 * ⁠[0,1,0],
 * ⁠[0,0,0]]
 * 
 * Output:
 * [[0,0,0],
 * [0,1,0],
 * [0,0,0]]
 * 
 * 
 * Example 2: 
 * 
 * 
 * Input:
 * [[0,0,0],
 * ⁠[0,1,0],
 * ⁠[1,1,1]]
 * 
 * Output:
 * [[0,0,0],
 * ⁠[0,1,0],
 * ⁠[1,2,1]]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * The number of elements of the given matrix will not exceed 10,000.
 * There are at least one 0 in the given matrix.
 * The cells are adjacent in only four directions: up, down, left and right.
 * 
 * 
 */
class Solution {
    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> queue = new ArrayDeque<>();
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (matrix[i][j] == 1)
                    matrix[i][j] = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (matrix[i][j] == 0)
                    add(matrix, i, j, 1, queue);

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            add(matrix, cur[0], cur[1], matrix[cur[0]][cur[1]]+1, queue);
        }
        return matrix;
    }
    
    void add(int[][] matrix, int x, int y, int val, Queue<int[]> queue) {
        for (int[] d : dir) {
            int nx = x+d[0];
            int ny = y+d[1];
            if (nx >= 0 && ny >= 0 && nx < matrix.length && ny < matrix[0].length && matrix[nx][ny] > val) {
                matrix[nx][ny] = val;
                queue.offer(new int[] {nx, ny});
            }
        }
    }
}
