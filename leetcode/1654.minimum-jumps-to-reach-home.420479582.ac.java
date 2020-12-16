/*
 * @lc app=leetcode id=1654 lang=java
 *
 * [1654] Minimum Jumps to Reach Home
 *
 * https://leetcode.com/problems/minimum-jumps-to-reach-home/description/
 *
 * algorithms
 * Medium (26.74%)
 * Total Accepted:    4.4K
 * Total Submissions: 16.5K
 * Testcase Example:  '[14,4,18,1,15]\n3\n15\n9'
 *
 * A certain bug's home is on the x-axis at position x. Help them get there
 * from position 0.
 * 
 * The bug jumps according to the following rules:
 * 
 * 
 * It can jump exactly a positions forward (to the right).
 * It can jump exactly b positions backward (to the left).
 * It cannot jump backward twice in a row.
 * It cannot jump to any forbidden positions.
 * 
 * 
 * The bug may jump forward beyond its home, but it cannot jump to positions
 * numbered with negative integers.
 * 
 * Given an array of integers forbidden, where forbidden[i] means that the bug
 * cannot jump to the position forbidden[i], and integers a, b, and x, return
 * the minimum number of jumps needed for the bug to reach its home. If there
 * is no possible sequence of jumps that lands the bug on position x, return
 * -1.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: forbidden = [14,4,18,1,15], a = 3, b = 15, x = 9
 * Output: 3
 * Explanation: 3 jumps forward (0 -> 3 -> 6 -> 9) will get the bug home.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: forbidden = [8,3,16,6,12,20], a = 15, b = 13, x = 11
 * Output: -1
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: forbidden = [1,6,2,14,5,17,4], a = 16, b = 9, x = 7
 * Output: 2
 * Explanation: One jump forward (0 -> 16) then one jump backward (16 -> 7)
 * will get the bug home.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= forbidden.length <= 1000
 * 1 <= a, b, forbidden[i] <= 2000
 * 0 <= x <= 2000
 * All the elements in forbidden are distinct.
 * Position x is not forbidden.
 * 
 * 
 */
class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer> seen = new HashSet<>();
        int max = x;
        for (int f : forbidden) {
            seen.add(f);
            max = Math.max(max, f);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a0, b0) -> a0[1] - b0[1]);
        pq.offer(new int[] {0, 0});
        int ans = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (seen.contains(cur[0]))
                continue;
            seen.add(cur[0]);
            if (cur[0] == x)
                return cur[1];
            if (cur[0] > max + a + b)
                continue;
            if (cur[0]-b == x)
                return cur[1]+1;
            if (!seen.contains(cur[0]+a))
                pq.offer(new int[] { cur[0]+a, cur[1]+1});
            if (cur[0] - b > 0 && !seen.contains(cur[0]-b) && !seen.contains(cur[0]-b+a))
                pq.offer(new int[] {cur[0]-b+a, cur[1]+2});
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    
    boolean helper(int z, int a, int b) {
        if (z == b)
            return false;
        if (b <= a)
            return true;
        int g = gcd(a, b);
        if (z%g != 0)
            return true;
        return false;
    }
    
    int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a%b);
    }
}
