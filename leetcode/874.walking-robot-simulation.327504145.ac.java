/*
 * @lc app=leetcode id=874 lang=java
 *
 * [874] Walking Robot Simulation
 *
 * https://leetcode.com/problems/walking-robot-simulation/description/
 *
 * algorithms
 * Easy (36.50%)
 * Total Accepted:    22.3K
 * Total Submissions: 61.1K
 * Testcase Example:  '[4,-1,3]\n[]'
 *
 * A robot on an infinite grid starts at point (0, 0) and faces north.  The
 * robot can receive one of three possible types of commands:
 * 
 * 
 * -2: turn left 90 degrees
 * -1: turn right 90 degrees
 * 1 <= x <= 9: move forward x units
 * 
 * 
 * Some of the grid squares are obstacles. 
 * 
 * The i-th obstacle is at grid point (obstacles[i][0], obstacles[i][1])
 * 
 * If the robot would try to move onto them, the robot stays on the previous
 * grid square instead (but still continues following the rest of the route.)
 * 
 * Return the square of the maximum Euclidean distance that the robot will be
 * from the origin.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: commands = [4,-1,3], obstacles = []
 * Output: 25
 * Explanation: robot will go to (3, 4)
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * Output: 65
 * Explanation: robot will be stuck at (1, 4) before turning left and going to
 * (1, 8)
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 0 <= commands.length <= 10000
 * 0 <= obstacles.length <= 10000
 * -30000 <= obstacle[i][0] <= 30000
 * -30000 <= obstacle[i][1] <= 30000
 * The answer is guaranteed to be less than 2 ^ 31.
 * 
 * 
 */
class Solution {
    int[][] next = { {0, 1}, { 1, 0 }, {0, -1}, {-1, 0}};
    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0, y = 0;
        int dir = 0;
        Set<Pair<Integer, Integer>> obs = new HashSet<>();
        for (int[] pos : obstacles) {
            obs.add(new Pair(pos[0], pos[1]));
        }
        int ans = 0;
        for (int k : commands) {
            if (k < 0) {
                if (k == -1)
                    dir++;
                else if (k == -2)
                    dir += 3;
                dir %= 4;
            } else {
                while (k-- > 0) {
                    int nx = x + next[dir][0];
                    int ny = y + next[dir][1];
                    if (obs.contains(new Pair(nx, ny)))
                        break;
                    x = nx;
                    y = ny;
                }
                ans = Math.max(ans, x*x + y*y);
            }
        }
        return ans;
    }
}
