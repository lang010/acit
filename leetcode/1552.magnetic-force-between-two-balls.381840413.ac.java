/*
 * @lc app=leetcode id=1552 lang=java
 *
 * [1552] Magnetic Force Between Two Balls
 *
 * https://leetcode.com/problems/magnetic-force-between-two-balls/description/
 *
 * algorithms
 * Medium (48.46%)
 * Total Accepted:    10.8K
 * Total Submissions: 22.2K
 * Testcase Example:  '[1,2,3,4,7]\n3'
 *
 * In universe Earth C-137, Rick discovered a special form of magnetic force
 * between two balls if they are put in his new invented basket. Rick has n
 * empty baskets, the i^th basket is at position[i], Morty has m balls and
 * needs to distribute the balls into the baskets such that the minimum
 * magnetic force between any two balls is maximum.
 * 
 * Rick stated that magnetic force between two different balls at positions x
 * and y is |x - y|.
 * 
 * Given the integer array position and the integer m. Return the required
 * force.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: position = [1,2,3,4,7], m = 3
 * Output: 3
 * Explanation: Distributing the 3 balls into baskets 1, 4 and 7 will make the
 * magnetic force between ball pairs [3, 3, 6]. The minimum magnetic force is
 * 3. We cannot achieve a larger minimum magnetic force than 3.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: position = [5,4,3,2,1,1000000000], m = 2
 * Output: 999999999
 * Explanation: We can use baskets 1 and 1000000000.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * n == position.length
 * 2 <= n <= 10^5
 * 1 <= position[i] <= 10^9
 * All integers in position are distinct.
 * 2 <= m <= position.length
 * 
 * 
 */
class Solution {
    int min = Integer.MAX_VALUE;
    int n = 0;
    
    public int maxDistance(int[] pos, int m) {
        n = pos.length;
        Arrays.sort(pos);
        int l = 0, r = pos[n-1] - pos[0] + 1;
        while (l < r) {
            int d = r - (r-l)/2;
            if (count(pos, d) >= m) {
                l = d;
            } else {
                r = d-1;
            }
        }
        return l;
    }
    
    int count(int[] pos, int d) {
        int ans = 1;
        int pre = pos[0];
        for (int x : pos) {
            if (x-pre >= d) {
                pre = x;
                ans++;
            }
        }
        return ans;
    }
}
