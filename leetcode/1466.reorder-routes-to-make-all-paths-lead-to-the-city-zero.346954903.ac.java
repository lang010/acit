/*
 * @lc app=leetcode id=1466 lang=java
 *
 * [1466] Reorder Routes to Make All Paths Lead to the City Zero
 *
 * https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/description/
 *
 * algorithms
 * Medium (61.38%)
 * Total Accepted:    21.2K
 * Total Submissions: 34.5K
 * Testcase Example:  '6\n[[0,1],[1,3],[2,3],[4,0],[4,5]]'
 *
 * There are n cities numbered from 0 to n-1 and n-1 roads such that there is
 * only one way to travel between two different cities (this network form a
 * tree). Last year, The ministry of transport decided to orient the roads in
 * one direction because they are too narrow.
 * 
 * Roads are represented by connections where connections[i] = [a, b]
 * represents a road from city a to b.
 * 
 * This year, there will be a big event in the capital (city 0), and many
 * people want to travel to this city.
 * 
 * Your task consists of reorienting some roads such that each city can visit
 * the city 0. Return the minimum number of edges changed.
 * 
 * It's guaranteed that each city can reach the city 0 after reorder.
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
 * Output: 3
 * Explanation: Change the direction of edges show in red such that each node
 * can reach the node 0 (capital).
 * 
 * Example 2:
 * 
 * 
 * 
 * 
 * Input: n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
 * Output: 2
 * Explanation: Change the direction of edges show in red such that each node
 * can reach the node 0 (capital).
 * 
 * Example 3:
 * 
 * 
 * Input: n = 3, connections = [[1,0],[2,0]]
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 2 <= n <= 5 * 10^4
 * connections.length == n-1
 * connections[i].length == 2
 * 0 <= connections[i][0], connections[i][1] <= n-1
 * connections[i][0] != connections[i][1]
 * 
 * 
 */
class Solution {
    Map<Integer, Set<Integer>> in = new HashMap<>();
    Map<Integer, Set<Integer>> out = new HashMap<>();
    public int minReorder(int n, int[][] con) {
        int ans = 0;
        for (int[] d : con) {
            add(in, d[1], d[0]);
            add(out, d[0], d[1]);
        }
        Set<Integer> set = new HashSet<>();
        set.add(0);
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (out.containsKey(cur)) {
                for (int o : out.get(cur)) {
                   if (!set.contains(o)) {
                        ans++;
                        set.add(o);
                        queue.offer(o);
                    }
                }
            }
            if (in.containsKey(cur)) {
                for (int i : in.get(cur)) {
                   if (!set.contains(i)) {
                        set.add(i);
                        queue.offer(i);
                    }
                }
            }
        }
        
        return ans;
    }
    
    void add(Map<Integer, Set<Integer>> m, int i, int o) {
        if (!m.containsKey(i))
            m.put(i, new HashSet<>());
        m.get(i).add(o);
    }
}
