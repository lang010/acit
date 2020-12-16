/*
 * @lc app=leetcode id=356 lang=java
 *
 * [356] Line Reflection
 *
 * https://leetcode.com/problems/line-reflection/description/
 *
 * algorithms
 * Medium (32.49%)
 * Total Accepted:    24.5K
 * Total Submissions: 75.3K
 * Testcase Example:  '[[1,1],[-1,1]]'
 *
 * Given n points on a 2D plane, find if there is such a line parallel to
 * y-axis that reflect the given points symmetrically, in other words, answer
 * whether or not if there exists a line that after reflecting all points over
 * the given line the set of the original points is the same that the reflected
 * ones.
 * 
 * Note that there can be repeated points.
 * 
 * Follow up:
 * Could you do better than O(n^2) ?
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: points = [[1,1],[-1,1]]
 * Output: true
 * Explanation: We can choose the line x = 0.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: points = [[1,1],[-1,-1]]
 * Output: false
 * Explanation: We can't choose a line.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * n == points.length
 * 1 <= n <= 10^4
 * -10^8 <= points[i][j] <= 10^8
 * 
 * 
 */
class Solution {
    public boolean isReflected(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int k = points[0][1];
        int max, min;
        min = max = points[0][0];
        for (int[] p : points) {
            if (p[1] == k) {
                min = Math.min(min, p[0]);
                max = Math.max(max, p[0]);
            }
            if (!map.containsKey(p[1]))
                map.put(p[1], new HashSet<>());
            map.get(p[1]).add(p[0]);
        }
        int sum = max+min;
        for (Integer key : map.keySet()) {
            Set<Integer> set = map.get(key);
            for (int x : set) {
                if (!set.contains(sum-x))
                    return false;
            }
        }
        return true;
    }
}
