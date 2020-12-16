/*
 * @lc app=leetcode id=684 lang=java
 *
 * [684] Redundant Connection
 *
 * https://leetcode.com/problems/redundant-connection/description/
 *
 * algorithms
 * Medium (58.49%)
 * Total Accepted:    113.2K
 * Total Submissions: 193.5K
 * Testcase Example:  '[[1,2],[1,3],[2,3]]'
 *
 * 
 * In this problem, a tree is an undirected graph that is connected and has no
 * cycles.
 * 
 * The given input is a graph that started as a tree with N nodes (with
 * distinct values 1, 2, ..., N), with one additional edge added.  The added
 * edge has two different vertices chosen from 1 to N, and was not an edge that
 * already existed.
 * 
 * The resulting graph is given as a 2D-array of edges.  Each element of edges
 * is a pair [u, v] with u < v, that represents an undirected edge connecting
 * nodes u and v.
 * 
 * Return an edge that can be removed so that the resulting graph is a tree of
 * N nodes.  If there are multiple answers, return the answer that occurs last
 * in the given 2D-array.  The answer edge [u, v] should be in the same format,
 * with u < v.
 * Example 1:
 * 
 * Input: [[1,2], [1,3], [2,3]]
 * Output: [2,3]
 * Explanation: The given undirected graph will be like this:
 * ⁠ 1
 * ⁠/ \
 * 2 - 3
 * 
 * 
 * Example 2:
 * 
 * Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
 * Output: [1,4]
 * Explanation: The given undirected graph will be like this:
 * 5 - 1 - 2
 * ⁠   |   |
 * ⁠   4 - 3
 * 
 * 
 * Note:
 * The size of the input 2D-array will be between 3 and 1000.
 * Every integer represented in the 2D-array will be between 1 and N, where N
 * is the size of the input array.
 * 
 * 
 * 
 * 
 * 
 * Update (2017-09-26):
 * We have overhauled the problem description + test cases and specified
 * clearly the graph is an undirected graph. For the directed graph follow up
 * please see Redundant Connection II). We apologize for any inconvenience
 * caused.
 * 
 */
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = 0;
        for (int[] e : edges) {
            if (e[1] > n)
                n = e[1];
        }
        n++;
        UF uf = new UF(n);
        for (int[] e : edges) {
            if (uf.getParent(e[0]) == uf.getParent(e[1])) {
                return e;
            }
            uf.union(e[0], e[1]);
        }
        return new int[0];
    }
    
    static class UF {
        int[] parent;
        int[] rank;
        
        UF(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++)
                parent[i] = i;
        }
        
        int getParent(int id) {
            int[] tmpP = parent;
            if (id == parent[id])
                return id;
            int p = getParent(parent[id]);
            parent[id] = p;
            return p;
        }
        
        void union(int u, int v) {
            int[] tmpP = parent;
            int up = getParent(u);
            int vp = getParent(v);
            if (up == vp)
                return;
            if (rank[up] > rank[vp]) {
                parent[up] = vp;
                rank[vp]++;
            } else {
                parent[vp] = up;
                rank[up]++;
            }
        }
    }
}
