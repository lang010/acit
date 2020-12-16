/*
 * @lc app=leetcode id=1192 lang=java
 *
 * [1192] Critical Connections in a Network
 *
 * https://leetcode.com/problems/critical-connections-in-a-network/description/
 *
 * algorithms
 * Hard (49.59%)
 * Total Accepted:    86.9K
 * Total Submissions: 175.1K
 * Testcase Example:  '4\n[[0,1],[1,2],[2,0],[1,3]]'
 *
 * There are n servers numbered from 0 to n-1 connected by undirected
 * server-to-server connections forming a network where connections[i] = [a, b]
 * represents a connection between servers a and b. Any server can reach any
 * other server directly or indirectly through the network.
 * 
 * A critical connection is a connection that, if removed, will make some
 * server unable to reach some other server.
 * 
 * Return all critical connections in the network in any order.
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
 * Output: [[1,3]]
 * Explanation: [[3,1]] is also accepted.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 10^5
 * n-1 <= connections.length <= 10^5
 * connections[i][0] != connections[i][1]
 * There are no repeated connections.
 * 
 * 
 */
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    int[] rank;
    Map<Integer, Set<Integer>> map = new HashMap<>();
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        rank = new int[n];
        Arrays.fill(rank, -1);
        for (int i = 0; i < n; i++)
            map.put(i, new HashSet<>());
        connections.forEach(a -> {
            map.get(a.get(0)).add(a.get(1));
            map.get(a.get(1)).add(a.get(0));
        });
        dfs(0, 0, -1);
        return ans;
    }
    
    int dfs(int depth, int node, int p) {
        if (rank[node] >= 0)
            return rank[node];
        rank[node] = depth;
        for (int child : map.get(node)) {
            if (child == p)
                continue;
            int val = dfs(depth+1, child, node);
            if (val > depth)
                ans.add(Arrays.asList(node, child));
            rank[node] = Math.min(rank[node], val);
        }
        return rank[node];
    }
}
