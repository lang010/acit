/*
 * @lc app=leetcode id=1334 lang=java
 *
 * [1334] Find the City With the Smallest Number of Neighbors at a Threshold Distance
 *
 * https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/description/
 *
 * algorithms
 * Medium (46.34%)
 * Total Accepted:    17.2K
 * Total Submissions: 37.2K
 * Testcase Example:  '4\n[[0,1,3],[1,2,1],[1,3,4],[2,3,1]]\n4'
 *
 * There are n cities numbered from 0 to n-1. Given the array edges where
 * edges[i] = [fromi, toi, weighti] represents a bidirectional and weighted
 * edge between cities fromi and toi, and given the integer distanceThreshold.
 * 
 * Return the city with the smallest number of cities that are reachable
 * through some path and whose distance is at most distanceThreshold, If there
 * are multiple such cities, return the city with the greatest number.
 * 
 * Notice that the distance of a path connecting cities i and j is equal to the
 * sum of the edges' weights along that path.
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: n = 4, edges = [[0,1,3],[1,2,1],[1,3,4],[2,3,1]], distanceThreshold =
 * 4
 * Output: 3
 * Explanation: The figure above describes the graph. 
 * The neighboring cities at a distanceThreshold = 4 for each city are:
 * City 0 -> [City 1, City 2] 
 * City 1 -> [City 0, City 2, City 3] 
 * City 2 -> [City 0, City 1, City 3] 
 * City 3 -> [City 1, City 2] 
 * Cities 0 and 3 have 2 neighboring cities at a distanceThreshold = 4, but we
 * have to return city 3 since it has the greatest number.
 * 
 * 
 * Example 2:
 * 
 * 
 * 
 * 
 * Input: n = 5, edges = [[0,1,2],[0,4,8],[1,2,3],[1,4,2],[2,3,1],[3,4,1]],
 * distanceThreshold = 2
 * Output: 0
 * Explanation: The figure above describes the graph. 
 * The neighboring cities at a distanceThreshold = 2 for each city are:
 * City 0 -> [City 1] 
 * City 1 -> [City 0, City 4] 
 * City 2 -> [City 3, City 4] 
 * City 3 -> [City 2, City 4]
 * City 4 -> [City 1, City 2, City 3] 
 * The city 0 has 1 neighboring city at a distanceThreshold = 2.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 2 <= n <= 100
 * 1 <= edges.length <= n * (n - 1) / 2
 * edges[i].length == 3
 * 0 <= fromi < toi < n
 * 1 <= weighti, distanceThreshold <= 10^4
 * All pairs (fromi, toi) are distinct.
 * 
 * 
 */
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold)  {
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE/3);
        for (int i = 0; i < n; i++)
            dist[i][i] = 0;
        for (int[] e : edges) {
            dist[e[0]][e[1]] = e[2];
            dist[e[1]][e[0]] = e[2];
        }
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < n; k++)
                    dist[j][k] = Math.min(dist[j][k], dist[j][i]+dist[i][k]);
        int ans = 0;
        int min = n;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++)
                if (dist[i][j] <= distanceThreshold)
                    cnt++;
            if (min >= cnt) {
                min = cnt;
                ans = i;
            }
        }
        return ans;
    }
    
    public int findTheCity2(int n, int[][] edges, int distanceThreshold) {
        Map<Integer, Integer>[] map = new HashMap[n];
        for (int i = 0; i < n; i++)
            map[i] = new HashMap<>();
        for (int[] e : edges) {
            map[e[0]].put(e[1], e[2]);
            map[e[1]].put(e[0], e[2]);
        }
        int ans = n;
        int min = n;
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> cur = new HashMap<>();
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
            pq.offer(new int[] {i, distanceThreshold});
            while (!pq.isEmpty()) {
                int[] p = pq.poll();
                cur.put(p[0], p[1]);
                map[p[0]].forEach((k, v) -> {
                    if (cur.getOrDefault(k, -1) < p[1] - v)
                        pq.offer(new int[] {k, p[1]-v});
                });
            }
            if (min >= cur.size()) {
                ans = i;
                min = cur.size();
            }
        }
        return ans;
    }
}
