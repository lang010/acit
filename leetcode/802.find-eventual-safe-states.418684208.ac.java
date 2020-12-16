/*
 * @lc app=leetcode id=802 lang=java
 *
 * [802] Find Eventual Safe States
 *
 * https://leetcode.com/problems/find-eventual-safe-states/description/
 *
 * algorithms
 * Medium (49.46%)
 * Total Accepted:    46.1K
 * Total Submissions: 93.2K
 * Testcase Example:  '[[1,2],[2,3],[5],[0],[5],[],[]]'
 *
 * We start at some node in a directed graph, and every turn, we walk along a
 * directed edge of the graph. If we reach a terminal node (that is, it has no
 * outgoing directed edges), we stop.
 * 
 * We define a starting node to be safe if we must eventually walk to a
 * terminal node. More specifically, there is a natural number k, so that we
 * must have stopped at a terminal node in less than k steps for any choice of
 * where to walk.
 * 
 * Return an array containing all the safe nodes of the graph. The answer
 * should be sorted in ascending order.
 * 
 * The directed graph has n nodes with labels from 0 to n - 1, where n is the
 * length of graph. The graph is given in the following form: graph[i] is a
 * list of labels j such that (i, j) is a directed edge of the graph, going
 * from node i to node j.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
 * Output: [2,4,5,6]
 * Explanation: The given graph is shown above.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
 * Output: [4]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * n == graph.length
 * 1 <= n <= 10^4
 * 0 <= graph[i].legnth <= n
 * graph[i] is sorted in a strictly increasing order.
 * The graph may contain self-loops.
 * The number of edges in the graph will be in the range [1, 4 * 10^4].
 * 
 * 
 */
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] degree = new int[n];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++)
            for (int j = 0; graph[i] != null && j < graph[i].length; j++) {
                degree[i]++;
                if (!map.containsKey(graph[i][j]))
                    map.put(graph[i][j], new HashSet<>());
                map.get(graph[i][j]).add(i);
            }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++)
            if (degree[i] == 0)
                queue.offer(i);
        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            int x = queue.poll();
            ans.add(x);
            if (!map.containsKey(x))
                continue;
            for (int y : map.get(x)) {
                degree[y]--;
                if (degree[y] == 0)
                    queue.offer(y);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
