/*
 * @lc app=leetcode id=447 lang=java
 *
 * [447] Number of Boomerangs
 *
 * https://leetcode.com/problems/number-of-boomerangs/description/
 *
 * algorithms
 * Medium (52.23%)
 * Total Accepted:    71.3K
 * Total Submissions: 136.6K
 * Testcase Example:  '[[0,0],[1,0],[2,0]]'
 *
 * You are given n points in the plane that are all distinct, where points[i] =
 * [xi, yi]. A boomerang is a tuple of points (i, j, k) such that the distance
 * between i and j equals the distance between i and k (the order of the tuple
 * matters).
 * 
 * Return the number of boomerangs.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: points = [[0,0],[1,0],[2,0]]
 * Output: 2
 * Explanation: The two boomerangs are [[1,0],[0,0],[2,0]] and
 * [[1,0],[2,0],[0,0]].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: points = [[1,1],[2,2],[3,3]]
 * Output: 2
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: points = [[1,1]]
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * n == points.length
 * 1 <= n <= 500
 * points[i].length == 2
 * -10^4 <= xi, yi <= 10^4
 * All the points are unique.
 * 
 * 
 */
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = points.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            map.clear();
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                int d = (points[i][0]-points[j][0]) * (points[i][0]-points[j][0])
                    + (points[i][1]-points[j][1]) * (points[i][1]-points[j][1]);
                map.put(d, map.getOrDefault(d, 0)+1);
            }
            for (int k : map.keySet()) {
                int v = map.get(k);
                ans += v * (v-1);
            }
        }
        return ans;
    }
}
