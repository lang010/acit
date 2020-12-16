/*
 * @lc app=leetcode id=954 lang=java
 *
 * [954] Array of Doubled Pairs
 *
 * https://leetcode.com/problems/array-of-doubled-pairs/description/
 *
 * algorithms
 * Medium (35.33%)
 * Total Accepted:    21.7K
 * Total Submissions: 61.3K
 * Testcase Example:  '[3,1,3,6]'
 *
 * Given an array of integers A with even length, return true if and only if it
 * is possible to reorder it such that A[2 * i + 1] = 2 * A[2 * i] for every 0
 * <= i < len(A) / 2.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: A = [3,1,3,6]
 * Output: false
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: A = [2,1,2,6]
 * Output: false
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: A = [4,-2,2,-4]
 * Output: true
 * Explanation: We can take two groups, [-2,-4] and [2,4] to form [-2,-4,2,4]
 * or [2,4,-2,-4].
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: A = [1,2,4,16,8,4]
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= A.length <= 3 * 10^4
 * A.length is even.
 * -10^5 <= A[i] <= 10^5
 * 
 * 
 */
class Solution {
    public boolean canReorderDoubled(int[] A) {
        int n = 100000;
        int[] cnt = new int[n*2+1];
        for (int x : A)
            cnt[x+n]++;
        cnt[n] = 0;
        for (int i = 0; i < cnt.length; i++)
            if (cnt[i] > 0) {
                int x = i - n;
                if (x > 0) {
                    int j = 2*x+n;
                    if (j >= cnt.length || cnt[j] < cnt[i])
                        return false;
                    cnt[j] -= cnt[i];
                } else {
                    int j = x/2 + n;
                    if (x%2 != 0 || cnt[j] < cnt[i])
                        return false;
                    cnt[j] -= cnt[i];
                }
            }
        return true;
    }
}
