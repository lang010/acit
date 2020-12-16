/*
 * @lc app=leetcode id=1584 lang=java
 *
 * [1584] Min Cost to Connect All Points
 *
 * https://leetcode.com/problems/min-cost-to-connect-all-points/description/
 *
 * algorithms
 * Medium (49.40%)
 * Total Accepted:    10.9K
 * Total Submissions: 22K
 * Testcase Example:  '[[0,0],[2,2],[3,10],[5,2],[7,0]]'
 *
 * You are given an array points representing integer coordinates of some
 * points on a 2D-plane, where points[i] = [xi, yi].
 * 
 * The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan
 * distance between them: |xi - xj| + |yi - yj|, where |val| denotes the
 * absolute value of val.
 * 
 * Return the minimum cost to make all points connected. All points are
 * connected if there is exactly one simple path between any two points.
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
 * Output: 20
 * Explanation:
 * 
 * We can connect the points as shown above to get the minimum cost of 20.
 * Notice that there is a unique path between every pair of points.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: points = [[3,12],[-2,5],[-4,1]]
 * Output: 18
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: points = [[0,0],[1,1],[1,0],[-1,1]]
 * Output: 4
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: points = [[-1000000,-1000000],[1000000,1000000]]
 * Output: 4000000
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: points = [[0,0]]
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= points.length <= 1000
 * -10^6 <= xi, yi <= 10^6
 * All pairs (xi, yi) are distinct.
 * 
 * 
 */
class Solution {
    int[] set;
    int n;
    public int minCostConnectPoints(int[][] points) {
        n = points.length;
        if (n < 2)
            return 0;
        set = new int[n];
        for (int i = 0; i < n; i++)
            set[i] = i;
        int[][] map = new int[(n-1)*n/2][3];
        int cnt = 0;
        for (int i = 0; i < n; i++)
            for (int j = i+1; j < n; j++) {
                map[cnt][0] = i;
                map[cnt][1] = j;
                map[cnt][2] = Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]);
                cnt++;
            }
        Arrays.sort(map, (a, b) -> a[2] - b[2]);
        int ans = 0;
        for (int[] arr : map) {
            if (union(arr[0], arr[1]))
                ans += arr[2];
        }
        return ans;
    }
    
    boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            set[x] = y;
            return true;
        }
        return false;
    }
    
    int find(int x) {
        if (x == set[x])
            return x;
        set[x] = find(set[x]);
        return set[x];
    }
}
