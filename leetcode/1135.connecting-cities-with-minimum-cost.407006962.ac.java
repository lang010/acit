/*
 * @lc app=leetcode id=1135 lang=java
 *
 * [1135] Connecting Cities With Minimum Cost
 *
 * https://leetcode.com/problems/connecting-cities-with-minimum-cost/description/
 *
 * algorithms
 * Medium (58.86%)
 * Total Accepted:    20.7K
 * Total Submissions: 35.2K
 * Testcase Example:  '3\n[[1,2,5],[1,3,6],[2,3,1]]'
 *
 * There are N cities numbered from 1 to N.
 * 
 * You are given connections, where each connections[i] = [city1, city2, cost]
 * represents the cost to connect city1 and city2 together.  (A connection is
 * bidirectional: connecting city1 and city2 is the same as connecting city2
 * and city1.)
 * 
 * Return the minimum cost so that for every pair of cities, there exists a
 * path of connections (possibly of length 1) that connects those two cities
 * together.  The cost is the sum of the connection costs used. If the task is
 * impossible, return -1.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: N = 3, connections = [[1,2,5],[1,3,6],[2,3,1]]
 * Output: 6
 * Explanation: 
 * Choosing any 2 edges will connect all cities so we choose the minimum 2.
 * 
 * 
 * Example 2:
 * 
 * 
 * 
 * 
 * Input: N = 4, connections = [[1,2,3],[3,4,4]]
 * Output: -1
 * Explanation: 
 * There is no way to connect all cities even if all edges are used.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= N <= 10000
 * 1 <= connections.length <= 10000
 * 1 <= connections[i][0], connections[i][1] <= N
 * 0 <= connections[i][2] <= 10^5
 * connections[i][0] != connections[i][1]
 * 
 * 
 */
class Solution {
    public int minimumCost(int N, int[][] connections) {
        int[] set = new int[N+1];
        for (int i = 0; i < N+1; i++)
            set[i] = i;
        int cnt = 0;
        int ans = 0;
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
        for (int[] e : connections)
            if (find(set, e[0]) != find(set, e[1])) {
                ans += e[2];
                cnt++;
                union(set, e[0], e[1]);
                if (cnt == N-1)
                    break;
            }
        return cnt == N-1 ? ans : -1;
    }
    
    int find(int[] set, int x) {
        if (set[x] == x)
            return x;
        return set[x] = find(set, set[x]);
    }
    
    void union(int[] set, int x, int y) {
        x = find(set, x);
        y = find(set, y);
        if (x != y)
            set[x] = y;
    }
}
