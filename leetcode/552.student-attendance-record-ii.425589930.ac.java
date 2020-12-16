/*
 * @lc app=leetcode id=552 lang=java
 *
 * [552] Student Attendance Record II
 *
 * https://leetcode.com/problems/student-attendance-record-ii/description/
 *
 * algorithms
 * Hard (37.06%)
 * Total Accepted:    27K
 * Total Submissions: 72.8K
 * Testcase Example:  '1'
 *
 * Given a positive integer n, return the number of all possible attendance
 * records with length n, which will be regarded as rewardable. The answer may
 * be very large, return it after mod 10^9 + 7.
 * 
 * A student attendance record is a string that only contains the following
 * three characters:
 * 
 * 
 * 
 * 'A' : Absent. 
 * 'L' : Late.
 * ⁠'P' : Present. 
 * 
 * 
 * 
 * 
 * A record is regarded as rewardable if it doesn't contain more than one 'A'
 * (absent) or more than two continuous 'L' (late).
 * 
 * Example 1:
 * 
 * Input: n = 2
 * Output: 8 
 * Explanation:
 * There are 8 records with length 2 will be regarded as rewardable:
 * "PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"
 * Only "AA" won't be regarded as rewardable owing to more than one absent
 * times. 
 * 
 * 
 * 
 * Note:
 * The value of n won't exceed 100,000.
 * 
 * 
 * 
 * 
 */
class Solution {
    public int checkRecord(int n) {
        // Initial states.
        long all = 3, hasA = 1, end1L = 1, end2L = 0, hasAEnd1L = 0, hasAEnd2L = 0;
        long mod = 1000000007l;
        for (int i = 1; i < n; i++) {
            // Next states.
            long all0 = all + all - hasA + all - end2L;
            long hasA0 = all - hasA + hasA + hasA - hasAEnd2L;
            long end1L0 = all - end1L - end2L;
            long end2L0 = end1L;
            long hasAEnd1L0 = hasA - hasAEnd1L - hasAEnd2L;
            long hasAEnd2L0 = hasAEnd1L;
            all = all0 % mod;
            hasA = hasA0 % mod;
            end1L = end1L0 % mod;
            end2L = end2L0 % mod;
            hasAEnd1L = hasAEnd1L0 % mod;
            hasAEnd2L = hasAEnd2L0 % mod;
        }
        return (int) ((all+mod) % mod);
    }
}
