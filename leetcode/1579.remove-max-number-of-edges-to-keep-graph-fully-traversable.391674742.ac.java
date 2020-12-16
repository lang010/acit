/*
 * @lc app=leetcode id=1579 lang=java
 *
 * [1579] Remove Max Number of Edges to Keep Graph Fully Traversable
 *
 * https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/description/
 *
 * algorithms
 * Hard (45.62%)
 * Total Accepted:    5.8K
 * Total Submissions: 12.7K
 * Testcase Example:  '4\n[[3,1,2],[3,2,3],[1,1,3],[1,2,4],[1,1,2],[2,3,4]]'
 *
 * Alice and Bob have an undirected graph of n nodes and 3 types of
 * edges:
 * 
 * 
 * Type 1: Can be traversed by Alice only.
 * Type 2: Can be traversed by Bob only.
 * Type 3: Can by traversed by both Alice and Bob.
 * 
 * 
 * Given an array edges where edges[i] = [typei, ui, vi] represents a
 * bidirectional edge of type typei between nodes ui and vi, find the maximum
 * number of edges you can remove so that after removing the edges, the graph
 * can still be fully traversed by both Alice and Bob. The graph is fully
 * traversed by Alice and Bob if starting from any node, they can reach all
 * other nodes.
 * 
 * Return the maximum number of edges you can remove, or return -1 if it's
 * impossible for the graph to be fully traversed by Alice and Bob.
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: n = 4, edges = [[3,1,2],[3,2,3],[1,1,3],[1,2,4],[1,1,2],[2,3,4]]
 * Output: 2
 * Explanation: If we remove the 2 edges [1,1,2] and [1,1,3]. The graph will
 * still be fully traversable by Alice and Bob. Removing any additional edge
 * will not make it so. So the maximum number of edges we can remove is 2.
 * 
 * 
 * Example 2:
 * 
 * 
 * 
 * 
 * Input: n = 4, edges = [[3,1,2],[3,2,3],[1,1,4],[2,1,4]]
 * Output: 0
 * Explanation: Notice that removing any edge will not make the graph fully
 * traversable by Alice and Bob.
 * 
 * 
 * Example 3:
 * 
 * 
 * 
 * 
 * Input: n = 4, edges = [[3,2,3],[1,1,2],[2,3,4]]
 * Output: -1
 * Explanation: In the current graph, Alice cannot reach node 4 from the other
 * nodes. Likewise, Bob cannot reach 1. Therefore it's impossible to make the
 * graph fully traversable.
 * 
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 10^5
 * 1 <= edges.length <= min(10^5, 3 * n * (n-1) / 2)
 * edges[i].length == 3
 * 1 <= edges[i][0] <= 3
 * 1 <= edges[i][1] < edges[i][2] <= n
 * All tuples (typei, ui, vi) are distinct.
 * 
 * 
 */
class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int[] u1 = new int[n+1];
        int[] u2 = new int[n+1];
        for (int i = 1; i <= n; i++) {
            u1[i] = u2[i] = i;
        }
        int ans = 0;
        for (int[] e : edges)
            if (e[0] == 3) {
                if (!same(u1, e[1], e[2])) {
                    union(u1, e[1], e[2]);
                    union(u2, e[1], e[2]);
                } else
                    ans++;
            }
        for (int[] e : edges)
            if (e[0] != 3) {
                int[] u = e[0] == 1 ? u1 : u2;
                if (!same(u, e[1], e[2])) {
                    union(u, e[1], e[2]);
                } else
                    ans++;
            }
        for (int i = 2; i <= n; i++)
            if (!same(u1, 1, i) || !same(u2, 1, i))
                return -1;
        return ans;
    }
    
    void union(int[] u, int x, int y) {
        int p1 = parent(u, x);
        int p2 = parent(u, y);
        if (p1 != p2) {
            u[p1] = u[p2] = Math.min(p1, p2);
        }
    }
    
    boolean same(int[] u, int x, int y) {
        return parent(u, x) == parent(u, y);
    }
    
    int parent(int[] u, int i) {
        if (i == u[i])
            return i;
        return u[i] = parent(u, u[i]);
    }
}
