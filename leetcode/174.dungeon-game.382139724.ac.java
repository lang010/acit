/*
 * @lc app=leetcode id=174 lang=java
 *
 * [174] Dungeon Game
 *
 * https://leetcode.com/problems/dungeon-game/description/
 *
 * algorithms
 * Hard (32.97%)
 * Total Accepted:    117.8K
 * Total Submissions: 357.2K
 * Testcase Example:  '[[-2,-3,3],[-5,-10,1],[10,30,-5]]'
 *
 * table.dungeon, .dungeon th, .dungeon td {
 * ⁠ border:3px solid black;
 * }
 * 
 * ⁠.dungeon th, .dungeon td {
 * ⁠   text-align: center;
 * ⁠   height: 70px;
 * ⁠   width: 70px;
 * }
 * 
 * The demons had captured the princess (P) and imprisoned her in the
 * bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid
 * out in a 2D grid. Our valiant knight (K) was initially positioned in the
 * top-left room and must fight his way through the dungeon to rescue the
 * princess.
 * 
 * The knight has an initial health point represented by a positive integer. If
 * at any point his health point drops to 0 or below, he dies immediately.
 * 
 * Some of the rooms are guarded by demons, so the knight loses health
 * (negative integers) upon entering these rooms; other rooms are either empty
 * (0's) or contain magic orbs that increase the knight's health (positive
 * integers).
 * 
 * In order to reach the princess as quickly as possible, the knight decides to
 * move only rightward or downward in each step.
 * 
 * 
 * 
 * Write a function to determine the knight's minimum initial health so that he
 * is able to rescue the princess.
 * 
 * For example, given the dungeon below, the initial health of the knight must
 * be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN ->
 * DOWN.
 * 
 * 
 * 
 * 
 * -2 (K)
 * -3
 * 3
 * 
 * 
 * -5
 * -10
 * 1
 * 
 * 
 * 10
 * 30
 * -5 (P)
 * 
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * The knight's health has no upper bound.
 * Any room can contain threats or power-ups, even the first room the knight
 * enters and the bottom-right room where the princess is imprisoned.
 * 
 * 
 */
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int l = 1;
        int r = 1;
        for (int[] ls : dungeon) {
            for (int x : ls)
                if (x < 0)
                    r -= x;
        }
        while (l < r) {
            int m = l + (r-l)/2;
            if (check(dungeon, m)) {
                r = m;
            } else {
                l = m+1;
            }
        }
        return l;
    }
    
    boolean check(int[][] dungeon, int hp) {
        int n = dungeon[0].length;
        int[] dp = new int[n];
        dp[0] = hp;
        for (int[] ls : dungeon) {
            if (dp[0] > 0)
                dp[0] += ls[0];
            for (int i = 1; i < n; i++) {
                int v = Math.max(dp[i-1], dp[i]);
                if (v > 0)
                    dp[i] = v + ls[i];
            }
        }
        return dp[n-1] > 0;
    }
}
