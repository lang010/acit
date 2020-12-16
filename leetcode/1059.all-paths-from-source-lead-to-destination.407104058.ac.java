/*
 * @lc app=leetcode id=1059 lang=java
 *
 * [1059] All Paths from Source Lead to Destination
 *
 * https://leetcode.com/problems/all-paths-from-source-lead-to-destination/description/
 *
 * algorithms
 * Medium (43.36%)
 * Total Accepted:    11.5K
 * Total Submissions: 26.6K
 * Testcase Example:  '3\n[[0,1],[0,2]]\n0\n2'
 *
 * Given the edges of a directed graph where edges[i] = [ai, bi] indicates
 * there is an edge between nodes ai and bi, and two nodes source and
 * destination of this graph, determine whether or not all paths starting from
 * source eventually, end at destination, that is:
 * 
 * 
 * At least one path exists from the source node to the destination node
 * If a path exists from the source node to a node with no outgoing edges, then
 * that node is equal to destination.
 * The number of possible paths from source to destination is a finite
 * number.
 * 
 * 
 * Return true if and only if all roads from source lead to destination.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 3, edges = [[0,1],[0,2]], source = 0, destination = 2
 * Output: false
 * Explanation: It is possible to reach and get stuck on both node 1 and node
 * 2.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 4, edges = [[0,1],[0,3],[1,2],[2,1]], source = 0, destination = 3
 * Output: false
 * Explanation: We have two possibilities: to end at node 3, or to loop over
 * node 1 and node 2 indefinitely.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: n = 4, edges = [[0,1],[0,2],[1,3],[2,3]], source = 0, destination = 3
 * Output: true
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: n = 3, edges = [[0,1],[1,1],[1,2]], source = 0, destination = 2
 * Output: false
 * Explanation: All paths from the source node end at the destination node, but
 * there are an infinite number of paths, such as 0-1-2, 0-1-1-2, 0-1-1-1-2,
 * 0-1-1-1-1-2, and so on.
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: n = 2, edges = [[0,1],[1,1]], source = 0, destination = 1
 * Output: false
 * Explanation: There is infinite self-loop at destination node.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 10^4
 * 0 <= edges.length <= 10^4
 * edges.length == 2
 * 0 <= ai, bi <= n - 1
 * 0 <= source <= n - 1
 * 0 <= destination <= n - 1
 * The given graph may have self-loops and parallel edges.
 * 
 * 
 */
class Solution {
    boolean[] visited;
    Map<Integer, Set<Integer>> map = new HashMap();
    int d;
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        visited = new boolean[n];
        d = destination;
        for (int[] e : edges) {
            if (!map.containsKey(e[0]))
                map.put(e[0], new HashSet<>());
            map.get(e[0]).add(e[1]);
        }
        if (map.get(d) != null)
            return false;
        
        return dfs(new HashSet<>(), source);
    }
    
    boolean dfs(Set<Integer> p, int s) {
        if (s == d)
            return true;
        visited[s] = true;
        if (!map.containsKey(s))
            return false;
        p.add(s);
        for (int next : map.get(s)) {
            if (p.contains(next))
                return false;
            if (!visited[next] && !dfs(p, next))
                return false;
        }
        p.remove(s);
        return true;
    }
}
