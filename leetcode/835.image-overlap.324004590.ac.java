/*
 * @lc app=leetcode id=835 lang=java
 *
 * [835] Image Overlap
 *
 * https://leetcode.com/problems/image-overlap/description/
 *
 * algorithms
 * Medium (62.03%)
 * Total Accepted:    42.4K
 * Total Submissions: 68.4K
 * Testcase Example:  '[[1,1,0],[0,1,0],[0,1,0]]\n[[0,0,0],[0,1,1],[0,0,1]]'
 *
 * You are given two images img1 and img2 both of size n x n, represented as
 * binary, square matrices of the same size. (A binary matrix has only 0s and
 * 1s as values.)
 * 
 * We translate one image however we choose (sliding it left, right, up, or
 * down any number of units), and place it on top of the other image.  After,
 * the overlap of this translation is the number of positions that have a 1 in
 * both images.
 * 
 * (Note also that a translation does not include any kind of rotation.)
 * 
 * What is the largest possible overlap?
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: img1 = [[1,1,0],[0,1,0],[0,1,0]], img2 = [[0,0,0],[0,1,1],[0,0,1]]
 * Output: 3
 * Explanation: We slide img1 to right by 1 unit and down by 1 unit.
 * 
 * The number of positions that have a 1 in both images is 3. (Shown in red)
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: img1 = [[1]], img2 = [[1]]
 * Output: 1
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: img1 = [[0]], img2 = [[0]]
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * n == img1.length
 * n == img1[i].length
 * n == img2.length 
 * n == img2[i].length
 * 1 <= n <= 30
 * img1[i][j] is 0 or 1.
 * img2[i][j] is 0 or 1.
 * 
 * 
 */
class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        int n = A.length;
        int m = A[0].length;
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1)
                    a[i] |= 1 << j;
                if (B[i][j] == 1)
                    b[i] |= 1 << j;
            }
        int ans = 0;
        for (int lr = 0; lr < n; lr++)
            for (int ud = 0; ud < m; ud++) {
                int lval = 0;
                int rval = 0;
                int uval = 0;
                int dval = 0;
                for (int i = 0; i < n-ud; i++) {
                    lval += cnt((a[i+ud]>>lr) & b[i]);
                    rval += cnt((a[i+ud]<<lr) & b[i]);
                    uval += cnt((a[i]<<lr) & b[i+ud]);
                    dval += cnt((a[i]>>lr) & b[i+ud]);
                }
                ans = Math.max(ans,
                               Math.max(
                                   Math.max(lval, rval), Math.max(uval, dval)));
            }
        
        return ans;
    }
    
    int cnt(int x) {
        int ans = 0;
        while (x > 0) {
            x = x & (x-1);
            ans++;
        }
        return ans;
    }
}
