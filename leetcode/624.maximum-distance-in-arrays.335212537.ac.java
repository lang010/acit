/*
 * @lc app=leetcode id=624 lang=java
 *
 * [624] Maximum Distance in Arrays
 *
 * https://leetcode.com/problems/maximum-distance-in-arrays/description/
 *
 * algorithms
 * Medium (39.27%)
 * Total Accepted:    29.5K
 * Total Submissions: 75.2K
 * Testcase Example:  '[[1,2,3],[4,5],[1,2,3]]'
 *
 * You are given m arrays, where each array is sorted in ascending order. Now
 * you can pick up two integers from two different arrays (each array picks
 * one) and calculate the distance. We define the distance between two integers
 * a and b to be their absolute difference |a - b|. Your task is to find the
 * maximum distance.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: arrays = [[1,2,3],[4,5],[1,2,3]]
 * Output: 4
 * Explanation: One way to reach the maximum distance 4 is to pick 1 in the
 * first or third array and pick 5 in the second array.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: arrays = [[1],[1]]
 * Output: 0
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: arrays = [[1],[2]]
 * Output: 1
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: arrays = [[1,4],[0,5]]
 * Output: 4
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == arrays.length
 * 2 <= m <= 10^4
 * 1 <= arrays[i].length <= 500
 * -10^4 <= arrays[i][j] <= 10^4
 * arrays[i] is sorted in ascending order.
 * There will be at most 10^5 integers in all the arrays.
 * 
 * 
 */
class Solution {
    public int maxDistance(List<List<Integer>> arr) {
        int ans = 0;
        int min = arr.get(0).get(0);
        int max = arr.get(0).get(arr.get(0).size()-1);
        for (int i = 1; i < arr.size(); i++) {
            int a = arr.get(i).get(0);
            int b = arr.get(i).get(arr.get(i).size()-1);
            ans = Math.max(ans, Math.max(max - a, b - min));
            max = Math.max(b, max);
            min = Math.min(a, min);
        }
        return ans;
    }
}
