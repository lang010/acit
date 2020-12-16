/*
 * @lc app=leetcode id=1102 lang=java
 *
 * [1102] Path With Maximum Minimum Value
 *
 * https://leetcode.com/problems/path-with-maximum-minimum-value/description/
 *
 * algorithms
 * Medium (49.98%)
 * Total Accepted:    25.7K
 * Total Submissions: 51.4K
 * Testcase Example:  '[[5,4,5],[1,2,6],[7,4,6]]'
 *
 * Given a matrix of integers A with R rows and C columns, find the maximum
 * score of a path starting at [0,0] and ending at [R-1,C-1].
 * 
 * The score of a path is the minimum value in that path.  For example, the
 * value of the path 8 →  4 →  5 →  9 is 4.
 * 
 * A path moves some number of times from one visited cell to any neighbouring
 * unvisited cell in one of the 4 cardinal directions (north, east, west,
 * south).
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: [[5,4,5],[1,2,6],[7,4,6]]
 * Output: 4
 * Explanation: 
 * The path with the maximum score is highlighted in yellow. 
 * 
 * 
 * Example 2:
 * 
 * 
 * 
 * 
 * Input: [[2,2,1,2,2,2],[1,2,2,2,1,2]]
 * Output: 2
 * 
 * Example 3:
 * 
 * 
 * 
 * 
 * Input:
 * [[3,4,6,3,4],[0,2,1,1,7],[8,8,3,2,7],[3,2,4,9,8],[4,1,2,0,0],[4,6,5,4,3]]
 * Output: 3
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= R, C <= 100
 * 0 <= A[i][j] <= 10^9
 * 
 * 
 */
class Solution {
    
    int[][] next = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int maximumMinimumPath(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++)
            Arrays.fill(dist[i], -1);
        dist[0][0] = A[0][0];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int x = cur/m;
            int y = cur%m;
            int sc = dist[x][y];
            for (int i = 0; i < next.length; i++) {
                int xx = x+next[i][0];
                int yy = y+next[i][1];
                if (xx < 0 || yy < 0 || xx >= n || yy >= m)
                    continue;
                if (dist[xx][yy] < 0) {
                    dist[xx][yy] = Math.min(sc, A[xx][yy]);
                    queue.add(xx*m + yy);
                } else if (dist[xx][yy] < sc && dist[xx][yy] < A[xx][yy]) {
                    dist[xx][yy] = Math.min(sc, A[xx][yy]);
                    queue.add(xx*m + yy);
                }
            }
        }
        return dist[n-1][m-1];
    }
}
