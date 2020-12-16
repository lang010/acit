/*
 * @lc app=leetcode id=1054 lang=java
 *
 * [1054] Distant Barcodes
 *
 * https://leetcode.com/problems/distant-barcodes/description/
 *
 * algorithms
 * Medium (44.09%)
 * Total Accepted:    20K
 * Total Submissions: 45.3K
 * Testcase Example:  '[1,1,1,2,2,2]'
 *
 * In a warehouse, there is a row of barcodes, where the i^th barcode is
 * barcodes[i].
 * 
 * Rearrange the barcodes so that no two adjacent barcodes are equal. You may
 * return any answer, and it is guaranteed an answer exists.
 * 
 * 
 * Example 1:
 * Input: barcodes = [1,1,1,2,2,2]
 * Output: [2,1,2,1,2,1]
 * Example 2:
 * Input: barcodes = [1,1,1,1,2,2,3,3]
 * Output: [1,3,1,3,1,2,1,2]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= barcodes.length <= 10000
 * 1 <= barcodes[i] <= 10000
 * 
 * 
 */
class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int[] cnt = new int[10001];
        int max = 0;
        for (int x : barcodes) {
            cnt[x]++;
            if (cnt[x] > cnt[max])
                max = x;
        }
        int n = barcodes.length;
        int l = 0;
        for (; l < n && cnt[max] > 0; l += 2) {
            barcodes[l] = max;
            cnt[max]--;
        }
        for (int i = 1; i < 10001; i++) {
            while (cnt[i] > 0) {
                if (l >= n)
                    l = 1;
                barcodes[l] = i;
                cnt[i]--;
                l += 2;
            }
        }
        return barcodes;
    }
}
