/*
 * @lc app=leetcode id=849 lang=java
 *
 * [849] Maximize Distance to Closest Person
 *
 * https://leetcode.com/problems/maximize-distance-to-closest-person/description/
 *
 * algorithms
 * Medium (44.32%)
 * Total Accepted:    94.3K
 * Total Submissions: 212.7K
 * Testcase Example:  '[1,0,0,0,1,0,1]'
 *
 * You are given an array representing a row of seats where seats[i] = 1
 * represents a person sitting in the i^th seat, and seats[i] = 0 represents
 * that the i^th seat is empty (0-indexed).
 * 
 * There is at least one empty seat, and at least one person sitting.
 * 
 * Alex wants to sit in the seat such that the distance between him and the
 * closest person to him is maximized. 
 * 
 * Return that maximum distance to the closest person.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: seats = [1,0,0,0,1,0,1]
 * Output: 2
 * Explanation: 
 * If Alex sits in the second open seat (i.e. seats[2]), then the closest
 * person has distance 2.
 * If Alex sits in any other open seat, the closest person has distance 1.
 * Thus, the maximum distance to the closest person is 2.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: seats = [1,0,0,0]
 * Output: 3
 * Explanation: 
 * If Alex sits in the last seat (i.e. seats[3]), the closest person is 3 seats
 * away.
 * This is the maximum distance possible, so the answer is 3.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: seats = [0,1]
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 2 <= seats.length <= 2 * 10^4
 * seats[i] is 0 or 1.
 * At least one seat is empty.
 * At least one seat is occupied.
 * 
 * 
 */
class Solution {
    public int maxDistToClosest(int[] seats) {
        int l = 0, r = seats.length-1;
        int max = 0;
        while (seats[l] != 1) {
            l++;
        }
        while (seats[r] != 1) {
            r--;
        }
        max = seats.length - r - 1;
        max = max < l ? l : max;
        int cnt = 0;
        for (int i = l; i <= r; i++) {
            if (seats[i] == 1) {
                cnt = (cnt+1) / 2;
                max = max < cnt ? cnt : max;
                cnt = 0;
            } else {
                cnt++;
            }
        }
        return max;
    }
}
