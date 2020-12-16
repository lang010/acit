/*
 * @lc app=leetcode id=815 lang=java
 *
 * [815] Bus Routes
 *
 * https://leetcode.com/problems/bus-routes/description/
 *
 * algorithms
 * Hard (43.08%)
 * Total Accepted:    43.4K
 * Total Submissions: 100.7K
 * Testcase Example:  '[[1,2,7],[3,6,7]]\n1\n6'
 *
 * We have a list of bus routes. Each routes[i] is a bus route that the i-th
 * bus repeats forever. For example if routes[0] = [1, 5, 7], this means that
 * the first bus (0-th indexed) travels in the sequence
 * 1->5->7->1->5->7->1->... forever.
 * 
 * We start at bus stop S (initially not on a bus), and we want to go to bus
 * stop T. Travelling by buses only, what is the least number of buses we must
 * take to reach our destination? Return -1 if it is not possible.
 * 
 * 
 * Example:
 * Input: 
 * routes = [[1, 2, 7], [3, 6, 7]]
 * S = 1
 * T = 6
 * Output: 2
 * Explanation: 
 * The best strategy is take the first bus to the bus stop 7, then take the
 * second bus to the bus stop 6.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= routes.length <= 500.
 * 1 <= routes[i].length <= 10^5.
 * 0 <= routes[i][j] < 10 ^ 6.
 * 
 * 
 */
class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        Map<Integer, Set<Integer>> stops2Bus = new HashMap<>();
        int n = routes.length;
        int m = 0;
        for (int i = 0; i < n; i++) {
            for (int j : routes[i]) {
                if (!stops2Bus.containsKey(j))
                    stops2Bus.put(j, new HashSet<>());
                stops2Bus.get(j).add(i);
                m = Math.max(m, j);
            }
        }
        int[] stops = new int[m+1];
        int[] bus = new int[n];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {S, 1});
        stops[S] = 1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == T)
                return cur[1]-1;
            for (int b : stops2Bus.get(cur[0]))
                if (bus[b] == 0) {
                    bus[b] = cur[1];
                    for (int s : routes[b])
                        if (stops[s] == 0) {
                            stops[s] = cur[1] + 1;
                            queue.offer(new int[] { s, cur[1] + 1});
                        }
                }
        }
        return -1;
    }
}
