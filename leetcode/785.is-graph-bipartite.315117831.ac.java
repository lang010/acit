/*
 * @lc app=leetcode id=785 lang=java
 *
 * [785] Is Graph Bipartite?
 *
 * https://leetcode.com/problems/is-graph-bipartite/description/
 *
 * algorithms
 * Medium (48.05%)
 * Total Accepted:    150.2K
 * Total Submissions: 312.6K
 * Testcase Example:  '[[1,3],[0,2],[1,3],[0,2]]'
 *
 * Given an undirected graph, return true if and only if it is bipartite.
 * 
 * Recall that a graph is bipartite if we can split its set of nodes into two
 * independent subsets A and B, such that every edge in the graph has one node
 * in A and another node in B.
 * 
 * The graph is given in the following form: graph[i] is a list of indexes j
 * for which the edge between nodes i and j exists.  Each node is an integer
 * between 0 and graph.length - 1.  There are no self edges or parallel edges:
 * graph[i] does not contain i, and it doesn't contain any element twice.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: graph = [[1,3],[0,2],[1,3],[0,2]]
 * Output: true
 * Explanation: We can divide the vertices into two groups: {0, 2} and {1,
 * 3}.
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
 * Output: false
 * Explanation: We cannot find a way to divide the set of nodes into two
 * independent subsets.
 * 
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= graph.length <= 100
 * 0 <= graph[i].length < 100
 * 0 <= graph[i][j] <= graph.length - 1
 * graph[i][j] != i
 * All the values of graph[i] are unique.
 * The graph is guaranteed to be undirected. 
 * 
 * 
 */
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] visited = new int[n];
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                s1.add(i);
                queue.add(i);
                while (!queue.isEmpty()) {
                    int cur = queue.poll();
                    if (visited[cur] == 1) {
                        continue;
                    }
                    visited[cur] = 1;
                    Set<Integer> set = s1.contains(cur) ? s1 : s2;
                    Set<Integer> another = set == s1 ? s2 : s1;
                    for (int j = 0; j < graph[cur].length; j++) {
                        if (set.contains(graph[cur][j]))
                            return false;
                        if (!another.contains(graph[cur][j])) {
                            another.add(graph[cur][j]);
                            queue.add(graph[cur][j]);
                        }
                    }
                }
            }
        }
        
        return true;
    }
}
