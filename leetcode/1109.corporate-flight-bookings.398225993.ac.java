/*
 * @lc app=leetcode id=1109 lang=java
 *
 * [1109] Corporate Flight Bookings
 *
 * https://leetcode.com/problems/corporate-flight-bookings/description/
 *
 * algorithms
 * Medium (53.92%)
 * Total Accepted:    22K
 * Total Submissions: 40.7K
 * Testcase Example:  '[[1,2,10],[2,3,20],[2,5,25]]\n5'
 *
 * There are n flights, and they are labeled from 1 to n.
 * 
 * We have a list of flight bookings.  The i-th booking bookings[i] = [i, j, k]
 * means that we booked k seats from flights labeled i to j inclusive.
 * 
 * Return an array answer of length n, representing the number of seats booked
 * on each flight in order of their label.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * Output: [10,55,45,25,25]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= bookings.length <= 20000
 * 1 <= bookings[i][0] <= bookings[i][1] <= n <= 20000
 * 1 <= bookings[i][2] <= 10000
 * 
 */
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        for (int[] b : bookings) {
            ans[b[0]-1] += b[2];
            if (b[1] < n)
                ans[b[1]] -= b[2];
        }
        for (int i = 1; i < n; i++)
            ans[i] += ans[i-1];
        return ans;
    }
}
