/*
 * @lc app=leetcode id=505 lang=java
 *
 * [505] The Maze II
 *
 * https://leetcode.com/problems/the-maze-ii/description/
 *
 * algorithms
 * Medium (48.21%)
 * Total Accepted:    54.4K
 * Total Submissions: 112.8K
 * Testcase Example:  '[[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]]\n[0,4]\n[4,4]'
 *
 * There is a ball in a maze with empty spaces and walls. The ball can go
 * through empty spaces by rolling up, down, left or right, but it won't stop
 * rolling until hitting a wall. When the ball stops, it could choose the next
 * direction.
 * 
 * Given the ball's start position, the destination and the maze, find the
 * shortest distance for the ball to stop at the destination. The distance is
 * defined by the number of empty spaces traveled by the ball from the start
 * position (excluded) to the destination (included). If the ball cannot stop
 * at the destination, return -1.
 * 
 * The maze is represented by a binary 2D array. 1 means the wall and 0 means
 * the empty space. You may assume that the borders of the maze are all walls.
 * The start and destination coordinates are represented by row and column
 * indexes.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input 1: a maze represented by a 2D array
 * 
 * 0 0 1 0 0
 * 0 0 0 0 0
 * 0 0 0 1 0
 * 1 1 0 1 1
 * 0 0 0 0 0
 * 
 * Input 2: start coordinate (rowStart, colStart) = (0, 4)
 * Input 3: destination coordinate (rowDest, colDest) = (4, 4)
 * 
 * Output: 12
 * 
 * Explanation: One shortest way is : left -> down -> left -> down -> right ->
 * down -> right.
 * ⁠            The total distance is 1 + 1 + 3 + 1 + 2 + 2 + 2 = 12.
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input 1: a maze represented by a 2D array
 * 
 * 0 0 1 0 0
 * 0 0 0 0 0
 * 0 0 0 1 0
 * 1 1 0 1 1
 * 0 0 0 0 0
 * 
 * Input 2: start coordinate (rowStart, colStart) = (0, 4)
 * Input 3: destination coordinate (rowDest, colDest) = (3, 2)
 * 
 * Output: -1
 * 
 * Explanation: There is no way for the ball to stop at the destination.
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * There is only one ball and one destination in the maze.
 * Both the ball and the destination exist on an empty space, and they will not
 * be at the same position initially.
 * The given maze does not contain border (like the red rectangle in the
 * example pictures), but you could assume the border of the maze are all
 * walls.
 * The maze contains at least 2 empty spaces, and both the width and height of
 * the maze won't exceed 100.
 * 
 * 
 */
class Solution {
    boolean[][] visited;
    int n, m;
    int[][] next = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        n = maze.length;
        m = maze[0].length;
        visited = new boolean[n][m];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        queue.offer(new int[] {start[0], start[1], 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            visited[cur[0]][cur[1]] = true;
            if (cur[0] == destination[0] && cur[1] == destination[1])
                return cur[2];
            for (int i = 0; i < 4; i++) {
                int x = cur[0];
                int y = cur[1];
                int cnt = 0;
                while (check(x, y) && maze[x][y] == 0) {
                    x += next[i][0];
                    y += next[i][1];
                    cnt++;
                }
                x -= next[i][0];
                y -= next[i][1];
                cnt--;
                if (!visited[x][y])
                    queue.offer(new int[] {x, y, cur[2]+cnt});
            }
        }
        return -1;
    }
    
    boolean check(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }
}
