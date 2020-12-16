/*
 * @lc app=leetcode id=1005 lang=java
 *
 * [1005] Maximize Sum Of Array After K Negations
 *
 * https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/description/
 *
 * algorithms
 * Easy (52.19%)
 * Total Accepted:    33.2K
 * Total Submissions: 63.7K
 * Testcase Example:  '[4,2,3]\n1'
 *
 * Given an array A of integers, we must modify the array in the following way:
 * we choose an i and replace A[i] with -A[i], and we repeat this process K
 * times in total.  (We may choose the same index i multiple times.)
 * 
 * Return the largest possible sum of the array after modifying it in this
 * way.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: A = [4,2,3], K = 1
 * Output: 5
 * Explanation: Choose indices (1,) and A becomes [4,-2,3].
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: A = [3,-1,0,2], K = 3
 * Output: 6
 * Explanation: Choose indices (1, 2, 2) and A becomes [3,1,0,2].
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: A = [2,-3,-1,5,-4], K = 2
 * Output: 13
 * Explanation: Choose indices (1, 4) and A becomes [2,3,-1,5,4].
 * 
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= A.length <= 10000
 * 1 <= K <= 10000
 * -100 <= A[i] <= 100
 * 
 * 
 */
class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        int[] cnt = new int[201];
        for (int x : A) {
            cnt[x + 100]++;
        }
        for (int i = 0; i < 100; i++) {
            if (cnt[i] > 0) {
                if (K > 0) {
                    if (K > cnt[i]) {
                        cnt[200-i] += cnt[i];
                        K -= cnt[i];
                        cnt[i] = 0;
                    } else {
                        cnt[200-i] += K;
                        cnt[i] -= K;
                        K = 0;
                    }
                } else
                    break;
            }
        }
        int ans = 0;
        int small = 200;
        for (int i = 0; i < 201; i++) {
            if (cnt[i] > 0) {
                int v = i - 100;
                if (small > 100)
                    small = v;
                ans += v * cnt[i];
            }
        }
        if (K%2 == 1) {
            ans -= 2 * small;
        }
        return ans;
    }
}
