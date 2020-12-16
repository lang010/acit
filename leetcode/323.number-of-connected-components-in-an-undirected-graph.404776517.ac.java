/*
 * @lc app=leetcode id=323 lang=java
 *
 * [323] Number of Connected Components in an Undirected Graph
 *
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/description/
 *
 * algorithms
 * Medium (57.09%)
 * Total Accepted:    117.6K
 * Total Submissions: 206K
 * Testcase Example:  '5\n[[0,1],[1,2],[3,4]]'
 *
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each
 * edge is a pair of nodes), write a function to find the number of connected
 * components in an undirected graph.
 * 
 * Example 1:
 * 
 * 
 * Input: n = 5 and edges = [[0, 1], [1, 2], [3, 4]]
 * 
 * ⁠    0          3
 * ⁠    |          |
 * ⁠    1 --- 2    4 
 * 
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]]
 * 
 * ⁠    0           4
 * ⁠    |           |
 * ⁠    1 --- 2 --- 3
 * 
 * Output:  1
 * 
 * 
 * Note:
 * You can assume that no duplicate edges will appear in edges. Since all edges
 * are undirected, [0, 1] is the same as [1, 0] and thus will not appear
 * together in edges.
 * 
 */
class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] set = new int[n];
        for (int i = 0; i < n; i++)
            set[i] = i;
        for (int[] e : edges)
            union(set, e[0], e[1]);
        int ans = 0;
        for (int i = 0; i < n; i++)
            if (set[i] == i)
                ans++;
        return ans;
    }
    
    int parent(int[] set, int x) {
        if (x == set[x])
            return x;
        return set[x] = parent(set, set[x]);
    }
    
    void union(int[] set, int x, int y) {
        int px = parent(set, x);
        int py = parent(set, y);
        if (px != py) {
            set[py] = px;
        }
    }
}
