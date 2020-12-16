/*
 * @lc app=leetcode id=1066 lang=java
 *
 * [1066] Campus Bikes II
 *
 * https://leetcode.com/problems/campus-bikes-ii/description/
 *
 * algorithms
 * Medium (53.97%)
 * Total Accepted:    25.2K
 * Total Submissions: 46.7K
 * Testcase Example:  '[[0,0],[2,1]]\n[[1,2],[3,3]]'
 *
 * On a campus represented as a 2D grid, there are N workers and M bikes, with
 * N <= M. Each worker and bike is a 2D coordinate on this grid.
 * 
 * We assign one unique bike to each worker so that the sum of the Manhattan
 * distances between each worker and their assigned bike is minimized.
 * 
 * The Manhattan distance between two points p1 and p2 is Manhattan(p1, p2) =
 * |p1.x - p2.x| + |p1.y - p2.y|.
 * 
 * Return the minimum possible sum of Manhattan distances between each worker
 * and their assigned bike.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: workers = [[0,0],[2,1]], bikes = [[1,2],[3,3]]
 * Output: 6
 * Explanation: 
 * We assign bike 0 to worker 0, bike 1 to worker 1. The Manhattan distance of
 * both assignments is 3, so the output is 6.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: workers = [[0,0],[1,1],[2,0]], bikes = [[1,0],[2,2],[2,1]]
 * Output: 4
 * Explanation: 
 * We first assign bike 0 to worker 0, then assign bike 1 to worker 1 or worker
 * 2, bike 2 to worker 2 or worker 1. Both assignments lead to sum of the
 * Manhattan distances as 4.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: workers = [[0,0],[1,0],[2,0],[3,0],[4,0]], bikes =
 * [[0,999],[1,999],[2,999],[3,999],[4,999]]
 * Output: 4995
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * N == workers.length
 * M == bikes.length
 * 1 <= N <= M <= 10
 * workers[i].length == 2
 * bikes[i].length == 2
 * 0 <= workers[i][0], workers[i][1], bikes[i][0], bikes[i][1] < 1000
 * All the workers and the bikes locations are unique.
 * 
 * 
 */
class Solution {
    
    int visited = 0;
    int[] dp = new int[1100];
    
    public int assignBikes(int[][] workers, int[][] bikes) {
        return dfs(workers, bikes, 0);
    }
    
    int dfs(int[][] workers, int[][] bikes, int cnt) {
        if (cnt == workers.length)
            return 0;
        if (dp[visited] > 0)
            return dp[visited];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < bikes.length; i++)
            if ((visited & (1<<i)) == 0) {
                visited |= (1 << i);
                min = Math.min(min, dist(workers, bikes, cnt, i) + dfs(workers, bikes, cnt+1));
                visited ^= (1 << i);
            }
        dp[visited] = min;
        return min;
    }
    
    int dist(int[][] workers, int[][] bikes, int x, int y) {
        return Math.abs(workers[x][0]-bikes[y][0]) + Math.abs(workers[x][1]-bikes[y][1]);
    }
}
