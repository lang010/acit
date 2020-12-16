/*
 * @lc app=leetcode id=934 lang=java
 *
 * [934] Shortest Bridge
 *
 * https://leetcode.com/problems/shortest-bridge/description/
 *
 * algorithms
 * Medium (49.31%)
 * Total Accepted:    40.4K
 * Total Submissions: 81.9K
 * Testcase Example:  '[[0,1],[1,0]]'
 *
 * In a given 2D binary array A, there are two islands.  (An island is a
 * 4-directionally connected group of 1s not connected to any other 1s.)
 * 
 * Now, we may change 0s to 1s so as to connect the two islands together to
 * form 1 island.
 * 
 * Return the smallest number of 0s that must be flipped.  (It is guaranteed
 * that the answer is at least 1.)
 * 
 * 
 * Example 1:
 * Input: A = [[0,1],[1,0]]
 * Output: 1
 * Example 2:
 * Input: A = [[0,1,0],[0,0,0],[0,0,1]]
 * Output: 2
 * Example 3:
 * Input: A = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * Output: 1
 * 
 * 
 * Constraints:
 * 
 * 
 * 2 <= A.length == A[0].length <= 100
 * A[i][j] == 0 or A[i][j] == 1
 * 
 * 
 */
class Solution {
    int[][] next = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int n, m;
    public int shortestBridge(int[][] A) {
        Queue<int[]> queue = new ArrayDeque<>();
        n = A.length;
        m = A[0].length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (A[i][j] == 1) {
                    dfs(A, i, j, queue);
                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        for (int[] nxt : next)
                            if (check(cur[0] + nxt[0], cur[1]+nxt[1])) {
                                if (A[cur[0]+nxt[0]][cur[1]+nxt[1]] == 1)
                                    return A[cur[0]][cur[1]]-1;
                                if ( A[cur[0]+nxt[0]][cur[1]+nxt[1]] == 0) {
                                     A[cur[0]+nxt[0]][cur[1]+nxt[1]] = A[cur[0]][cur[1]] == -1 ? 2 : A[cur[0]][cur[1]]+1;
                                    queue.offer(new int[] {cur[0]+nxt[0], cur[1]+nxt[1]});
                                }
                            }
                    }
                }
        return 0;
    }
    
    void dfs(int[][] A, int x, int y, Queue<int[]> queue) {
        A[x][y] = -1;
        queue.offer(new int[] {x, y});
        for (int[] nxt : next)
            if (check(x+nxt[0], y+nxt[1]) && A[x+nxt[0]][y+nxt[1]] == 1)
                dfs(A, x+nxt[0], y+nxt[1], queue);
    }
    
    boolean check(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }
}
