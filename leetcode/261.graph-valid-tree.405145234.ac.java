/*
 * @lc app=leetcode id=261 lang=java
 *
 * [261] Graph Valid Tree
 *
 * https://leetcode.com/problems/graph-valid-tree/description/
 *
 * algorithms
 * Medium (42.77%)
 * Total Accepted:    144.6K
 * Total Submissions: 338.1K
 * Testcase Example:  '5\n[[0,1],[0,2],[0,3],[1,4]]'
 *
 * Given n nodes labeled from 0 to n-1 and a list of undirected edges (each
 * edge is a pair of nodes), write a function to check whether these edges make
 * up a valid tree.
 * 
 * Example 1:
 * 
 * 
 * Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
 * Output: true
 * 
 * Example 2:
 * 
 * 
 * Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
 * Output: false
 * 
 * Note: you can assume that no duplicate edges will appear in edges. Since all
 * edges are undirected, [0,1] is the same as [1,0] and thus will not appear
 * together in edges.
 * 
 */
class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] set = new int[n];
        for (int i = 0; i < n; i++)
            set[i] = i;
        for (int[] e : edges) {
            int p1 = parent(set, e[0]);
            int p2 = parent(set, e[1]);
            if (p1 == p2)
                return false;
            set[p1] = p2;
        }
        int cnt = 0;
        for (int i = 0; i < n; i++)
            if (set[i] == i)
                cnt++;
        return cnt == 1;
    }
    
    int parent(int[] set, int x) {
        if (x == set[x])
            return x;
        return set[x] = parent(set, set[x]);
    }
}
