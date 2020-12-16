/*
 * @lc app=leetcode id=490 lang=java
 *
 * [490] The Maze
 *
 * https://leetcode.com/problems/the-maze/description/
 *
 * algorithms
 * Medium (52.46%)
 * Total Accepted:    79.1K
 * Total Submissions: 150.7K
 * Testcase Example:  '[[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]]\n[0,4]\n[4,4]'
 *
 * There is a ball in a maze with empty spaces (represented as 0) and walls
 * (represented as 1). The ball can go through the empty spaces by rolling up,
 * down, left or right, but it won't stop rolling until hitting a wall. When
 * the ball stops, it could choose the next direction.
 * 
 * Given the maze, the ball's start position and the destination, where start =
 * [startrow, startcol] and destination = [destinationrow, destinationcol],
 * return true if the ball can stop at the destination, otherwise return
 * false.
 * 
 * You may assume that the borders of the maze are all walls (see examples).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]],
 * start = [0,4], destination = [4,4]
 * Output: true
 * Explanation: One possible way is : left -> down -> left -> down -> right ->
 * down -> right.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]],
 * start = [0,4], destination = [3,2]
 * Output: false
 * Explanation: There is no way for the ball to stop at the destination. Notice
 * that you can pass through the destination but you cannot stop there.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: maze = [[0,0,0,0,0],[1,1,0,0,1],[0,0,0,0,0],[0,1,0,0,1],[0,1,0,0,0]],
 * start = [4,3], destination = [0,1]
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= maze.length, maze[i].length <= 100
 * maze[i][j] is 0 or 1.
 * start.length == 2
 * destination.length == 2
 * 0 <= startrow, destinationrow <= maze.length
 * 0 <= startcol, destinationcol <= maze[i].length
 * Both the ball and the destination exist on an empty space, and they will not
 * be at the same position initially.
 * The maze contains at least 2 empty spaces.
 * 
 * 
 */
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    int m = 0;
    int n = 0;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        n = maze.length;
        m = maze[0].length;
        return dfs(maze, start, destination);
    }
    
    boolean dfs(int[][] maze, int[] cur, int[] dest) {
        if (cur[0] == dest[0] && cur[1] == dest[1])
            return true;
        for (int i = 0; i < 4; i++) {
            int x = cur[0];
            int y = cur[1];
            int k = x*m + y;
            int v = map.getOrDefault(k, 0);
            if (((1<<i) & v) == 0) {
                map.put(k, (1<<i) | v);
                while (check(x, y) && maze[x][y] != 1) {
                    x += next[i][0];
                    y += next[i][1];
                }
                x -= next[i][0];
                y -= next[i][1];
                if (x != cur[0] || y != cur[1])
                    if (dfs(maze, new int[] {x, y}, dest))
                        return true;
            }
        }
        return false;
    }
    
    boolean check(int x, int y) {
        if (x >= 0 && y >= 0 && x < n && y < m)
            return true;
        return false;
    }
}
