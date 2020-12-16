/*
 * @lc app=leetcode id=1691 lang=java
 *
 * [1691] Maximum Height by Stacking Cuboids 
 *
 * https://leetcode.com/problems/maximum-height-by-stacking-cuboids/description/
 *
 * algorithms
 * Hard (47.15%)
 * Total Accepted:    2.3K
 * Total Submissions: 4.9K
 * Testcase Example:  '[[50,45,20],[95,37,53],[45,23,12]]'
 *
 * Given n cuboids where the dimensions of the i^th cuboid is cuboids[i] =
 * [widthi, lengthi, heighti] (0-indexed). Choose a subset of cuboids and place
 * them on each other.
 * 
 * You can place cuboid i on cuboid j if widthi <= widthj and lengthi <=
 * lengthj and heighti <= heightj. You can rearrange any cuboid's dimensions by
 * rotating it to put it on another cuboid.
 * 
 * Return the maximum height of the stacked cuboids.
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: cuboids = [[50,45,20],[95,37,53],[45,23,12]]
 * Output: 190
 * Explanation:
 * Cuboid 1 is placed on the bottom with the 53x37 side facing down with height
 * 95.
 * Cuboid 0 is placed next with the 45x20 side facing down with height 50.
 * Cuboid 2 is placed next with the 23x12 side facing down with height 45.
 * The total height is 95 + 50 + 45 = 190.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: cuboids = [[38,25,45],[76,35,3]]
 * Output: 76
 * Explanation:
 * You can't place any of the cuboids on the other.
 * We choose cuboid 1 and rotate it so that the 35x3 side is facing down and
 * its height is 76.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: cuboids =
 * [[7,11,17],[7,17,11],[11,7,17],[11,17,7],[17,7,11],[17,11,7]]
 * Output: 102
 * Explanation:
 * After rearranging the cuboids, you can see that all cuboids have the same
 * dimension.
 * You can place the 11x7 side down on all cuboids so their heights are 17.
 * The maximum height of stacked cuboids is 6 * 17 = 102.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * n == cuboids.length
 * 1 <= n <= 100
 * 1 <= widthi, lengthi, heighti <= 100
 * 
 * 
 */
class Solution {
    public int maxHeight(int[][] cuboids) {
        for (int[] cub : cuboids)
            Arrays.sort(cub);
        int n = cuboids.length;
        int[] dp = new int[n];
        Arrays.sort(cuboids, (a, b) -> {
            if (a[0] != b[0])
                return a[0]-b[0];
            if (a[1] != b[1])
                return a[1]-b[1];
            return a[2]-b[2];
        });
        for (int i = 0; i < n; i++) {
            dp[i] = cuboids[i][2];
            for (int j = 0; j < i; j++)
                if (check(cuboids, j, i))
                    dp[i] = Math.max(dp[i], dp[j] + cuboids[i][2]);
        }
        int ans = 0;
        for (int x : dp)
            ans = Math.max(ans, x);
        return ans;
    }
    
    boolean check(int[][] cubs, int x, int y) {
        if (cubs[x][0] <= cubs[y][0] && cubs[x][1] <= cubs[y][1] && cubs[x][2] <= cubs[y][2])
            return true;
        return false;
    }
}
