/*
 * @lc app=leetcode id=1197 lang=java
 *
 * [1197] Minimum Knight Moves
 *
 * https://leetcode.com/problems/minimum-knight-moves/description/
 *
 * algorithms
 * Medium (36.83%)
 * Total Accepted:    46.4K
 * Total Submissions: 125.9K
 * Testcase Example:  '2\n1'
 *
 * In an infinite chess board with coordinates from -infinity to +infinity, you
 * have a knight at square [0, 0].
 * 
 * A knight has 8 possible moves it can make, as illustrated below. Each move
 * is two squares in a cardinal direction, then one square in an orthogonal
 * direction.
 * 
 * 
 * 
 * Return the minimum number of steps needed to move the knight to the square
 * [x, y].  It is guaranteed the answer exists.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: x = 2, y = 1
 * Output: 1
 * Explanation: [0, 0] → [2, 1]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: x = 5, y = 5
 * Output: 4
 * Explanation: [0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * |x| + |y| <= 300
 * 
 * 
 */
class Solution {
    int N = 1000;
    int[] next = { N+2, 2*N+1, -N+2, -2*N+1, -N-2, -2*N-1, N-2, 2*N-1 };
    public int minKnightMoves(int x, int y) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        int target = x*N + y;
        if (target == 0)
            return 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int n = map.get(cur)+1;
            for (int nx : next) {
                if (nx+cur == target)
                    return n;
                if (!map.containsKey(nx+cur)) {
                    map.put(nx+cur, n);
                    queue.offer(nx+cur);
                }
            }
        }
        return -1;
    }
}
