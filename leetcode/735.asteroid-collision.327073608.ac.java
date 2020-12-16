/*
 * @lc app=leetcode id=735 lang=java
 *
 * [735] Asteroid Collision
 *
 * https://leetcode.com/problems/asteroid-collision/description/
 *
 * algorithms
 * Medium (43.11%)
 * Total Accepted:    95.9K
 * Total Submissions: 222.4K
 * Testcase Example:  '[5,10,-5]'
 *
 * We are given an array asteroids of integers representing asteroids in a
 * row.
 * 
 * For each asteroid, the absolute value represents its size, and the sign
 * represents its direction (positive meaning right, negative meaning left).
 * Each asteroid moves at the same speed.
 * 
 * Find out the state of the asteroids after all collisions. If two asteroids
 * meet, the smaller one will explode. If both are the same size, both will
 * explode. Two asteroids moving in the same direction will never meet.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: asteroids = [5,10,-5]
 * Output: [5,10]
 * Explanation: The 10 and -5 collide resulting in 10.  The 5 and 10 never
 * collide.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: asteroids = [8,-8]
 * Output: []
 * Explanation: The 8 and -8 collide exploding each other.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: asteroids = [10,2,-5]
 * Output: [10]
 * Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide
 * resulting in 10.
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: asteroids = [-2,-1,1,2]
 * Output: [-2,-1,1,2]
 * Explanation: The -2 and -1 are moving left, while the 1 and 2 are moving
 * right. Asteroids moving the same direction never meet, so no asteroids will
 * meet each other.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= asteroids <= 10^4
 * -1000 <= asteroids[i] <= 1000
 * asteroids[i] != 0
 * 
 * 
 */
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> ls = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int x : asteroids) {
            if (x > 0)
                stack.push(x);
            else {
                while (!stack.isEmpty()) {
                    int top = stack.peek();
                    if (top > -x) {
                        x = 0;
                        break;
                    } else {
                        stack.pop();
                        if (-x == top) {
                            x = 0;
                            break;
                        }
                    }
                }
                if (x != 0)
                    ls.add(x);
            }
        }
        while (!stack.isEmpty()) {
            ls.add(stack.pollLast());
        }
        int[] ans = new int[ls.size()];
        for (int i = 0; i < ls.size(); i++)
            ans[i] = ls.get(i);
        return ans;
    }
}
