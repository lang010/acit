/*
 * @lc app=leetcode id=1182 lang=java
 *
 * [1182] Shortest Distance to Target Color
 *
 * https://leetcode.com/problems/shortest-distance-to-target-color/description/
 *
 * algorithms
 * Medium (53.28%)
 * Total Accepted:    7.8K
 * Total Submissions: 14.7K
 * Testcase Example:  '[1,1,2,1,3,2,2,3,3]\n[[1,3],[2,2],[6,1]]'
 *
 * You are given an array colors, in which there are three colors: 1, 2 and 3.
 * 
 * You are also given some queries. Each query consists of two integers i and
 * c, return the shortest distance between the given index i and the target
 * color c. If there is no solution return -1.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: colors = [1,1,2,1,3,2,2,3,3], queries = [[1,3],[2,2],[6,1]]
 * Output: [3,0,3]
 * Explanation: 
 * The nearest 3 from index 1 is at index 4 (3 steps away).
 * The nearest 2 from index 2 is at index 2 itself (0 steps away).
 * The nearest 1 from index 6 is at index 3 (3 steps away).
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: colors = [1,2], queries = [[0,3]]
 * Output: [-1]
 * Explanation: There is no 3 in the array.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= colors.length <= 5*10^4
 * 1 <= colors[i] <= 3
 * 1 <= queries.length <= 5*10^4
 * queries[i].length == 2
 * 0 <= queries[i][0] < colors.length
 * 1 <= queries[i][1] <= 3
 * 
 * 
 */
class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        Map<Integer, int[]> map = new HashMap<>();
        int n = colors.length;
        for (int[] q : queries) {
            map.put(q[0], new int[] {n, n, n, n});
        }
        int[] pos = new int[] {-n, -n, -n, -n};
        for (int i = 0; i < n; i++) {
            pos[colors[i]] = i;
            if (map.containsKey(i)) {
                int[] dist = map.get(i);
                for (int k = 1; k < 4; k++)
                    dist[k] = Math.min(dist[k], i-pos[k]);
            }                    
        }
        pos = new int[] {n+n, n+n, n+n, n+n};
        for (int i = n-1; i >= 0; i--) {
            pos[colors[i]] = i;
            if (map.containsKey(i)) {
                int[] dist = map.get(i);
                for (int k = 1; k < 4; k++)
                    dist[k] = Math.min(dist[k], pos[k]-i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int[] q : queries) {
            int v = map.get(q[0])[q[1]];
            ans.add(v == n ? -1 : v);
        }
        return ans;
    }
}
