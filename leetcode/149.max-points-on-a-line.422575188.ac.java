/*
 * @lc app=leetcode id=149 lang=java
 *
 * [149] Max Points on a Line
 *
 * https://leetcode.com/problems/max-points-on-a-line/description/
 *
 * algorithms
 * Hard (17.18%)
 * Total Accepted:    166.3K
 * Total Submissions: 967.7K
 * Testcase Example:  '[[1,1],[2,2],[3,3]]'
 *
 * Given n points on a 2D plane, find the maximum number of points that lie on
 * the same straight line.
 * 
 * Example 1:
 * 
 * 
 * Input: [[1,1],[2,2],[3,3]]
 * Output: 3
 * Explanation:
 * ^
 * |
 * |        o
 * |     o
 * |  o  
 * +------------->
 * 0  1  2  3  4
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * Output: 4
 * Explanation:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 * 
 * 
 * NOTE: input types have been changed on April 15, 2019. Please reset to
 * default code definition to get new method signature.
 * 
 */
class Solution {
    public int maxPoints(int[][] points) {
        int ans = 0;
        int n = points.length;
        if (n < 3)
            return n;
        for (int i = 0; i < n; i++) {
            int x = points[i][0];
            int y = points[i][1];
            Map<String, Integer> cnt = new HashMap<>();
            int same = 1;
            for (int j = i+1; j < n; j++) {
                if (x == points[j][0] && y == points[j][1])
                    same++;
                else if (y == points[j][1])
                    cnt.put("Loop", cnt.getOrDefault("Loop", 0) + 1);
                else {
                    int dx = x-points[j][0];
                    int dy = y-points[j][1];
                    int g = gcd(dx, dy);
                    String k = g == 0 ? "0" : (dx/g + "," + dy/g);
                    cnt.put(k, cnt.getOrDefault(k, 0)+1);
                }
            }
            int max = 0;
            for (int v : cnt.values())
                max = Math.max(max, v);
            ans = Math.max(ans, max+same);
        }
        return ans;
    }
    
    int gcd(int x, int y) {
        if (y == 0)
            return x;
        return gcd(y, x%y);
    }
}
