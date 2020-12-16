/*
 * @lc app=leetcode id=923 lang=java
 *
 * [923] 3Sum With Multiplicity
 *
 * https://leetcode.com/problems/3sum-with-multiplicity/description/
 *
 * algorithms
 * Medium (35.95%)
 * Total Accepted:    21.3K
 * Total Submissions: 59.3K
 * Testcase Example:  '[1,1,2,2,3,3,4,4,5,5]\n8'
 *
 * Given an integer array A, and an integer target, return the number of tuples
 * i, j, k  such that i < j < k and A[i] + A[j] + A[k] == target.
 * 
 * As the answer can be very large, return it modulo 10^9 + 7.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: A = [1,1,2,2,3,3,4,4,5,5], target = 8
 * Output: 20
 * Explanation: 
 * Enumerating by the values (A[i], A[j], A[k]):
 * (1, 2, 5) occurs 8 times;
 * (1, 3, 4) occurs 8 times;
 * (2, 2, 4) occurs 2 times;
 * (2, 3, 3) occurs 2 times.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: A = [1,1,2,2,2,2], target = 5
 * Output: 12
 * Explanation: 
 * A[i] = 1, A[j] = A[k] = 2 occurs 12 times:
 * We choose one 1 from [1,1] in 2 ways,
 * and two 2s from [2,2,2,2] in 6 ways.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 3 <= A.length <= 3000
 * 0 <= A[i] <= 100
 * 0 <= target <= 300
 * 
 * 
 */
class Solution {
    int mod = 1000000007;
    public int threeSumMulti(int[] A, int target) {
        long[] cnt = new long[101];
        for (int x : A)
            cnt[x]++;
        long ans = 0;
        for (int i = 0; i < 101; i++)
            if (cnt[i] > 0) {
                for (int j = i; j < 101; j++) {
                    if (cnt[j] == 0)
                        continue;
                    int t = target - i - j;
                    if (t < j || t > 100 || cnt[t] == 0)
                        continue;
                    if (t == j) {
                        if (j == i) {
                            ans = (ans + cnt[i] * (cnt[i]-1) * (cnt[i] - 2)/6) % mod;
                        } else
                            ans = (ans + cnt[i] * cnt[j] * (cnt[j]-1)/2) % mod;
                    } else {
                        if (i == j)
                            ans = (ans + cnt[i] * (cnt[i]-1) * cnt[t]/2) % mod;
                        else
                            ans = (ans + cnt[i] * cnt[j] * cnt[t]) % mod;
                    }
                }
            }
        return (int) ans;
    }
}
