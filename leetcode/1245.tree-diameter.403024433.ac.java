/*
 * @lc app=leetcode id=1245 lang=java
 *
 * [1245] Tree Diameter
 *
 * https://leetcode.com/problems/tree-diameter/description/
 *
 * algorithms
 * Medium (61.02%)
 * Total Accepted:    16K
 * Total Submissions: 26.2K
 * Testcase Example:  '[[0,1],[0,2]]'
 *
 * Given an undirected tree, return its diameter: the number of edges in a
 * longest path in that tree.
 * 
 * The tree is given as an array of edges where edges[i] = [u, v] is a
 * bidirectional edge between nodes u and v.  Each node has labels in the set
 * {0, 1, ..., edges.length}.
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: edges = [[0,1],[0,2]]
 * Output: 2
 * Explanation: 
 * A longest path of the tree is the path 1 - 0 - 2.
 * 
 * 
 * Example 2:
 * 
 * 
 * 
 * 
 * Input: edges = [[0,1],[1,2],[2,3],[1,4],[4,5]]
 * Output: 4
 * Explanation: 
 * A longest path of the tree is the path 3 - 2 - 1 - 4 - 5.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= edges.length < 10^4
 * edges[i][0] != edges[i][1]
 * 0 <= edges[i][j] <= edges.length
 * The given edges form an undirected tree.
 * 
 * 
 */
class Solution {
    Map<Integer, Set<Integer>> tr = new HashMap<>();
    int max = 0;
    public int treeDiameter(int[][] edges) {
        for (int[] e : edges) {
            add(e[0], e[1]);
            add(e[1], e[0]);
        }
        dfs(edges[0][0], -1);
        return max;
    }
    
    void add(int p, int c) {
        if (!tr.containsKey(p))
            tr.put(p, new HashSet<>());
        tr.get(p).add(c);
    }
    
    int dfs(int cur, int p) {
        if (!tr.containsKey(cur))
            return 1;
        int d1 = 0, d2 = 0;
        for (int c : tr.get(cur)) {
            if (c != p) {
                int d = dfs(c, cur);
                if (d >= d1) {
                    d2 = d1;
                    d1 = d;
                } else if (d > d2)
                    d2 = d;
            }
        }
        max = Math.max(max, d1+d2);
        return d1 + 1;
    }
}
