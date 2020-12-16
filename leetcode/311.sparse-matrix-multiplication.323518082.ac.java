/*
 * @lc app=leetcode id=311 lang=java
 *
 * [311] Sparse Matrix Multiplication
 *
 * https://leetcode.com/problems/sparse-matrix-multiplication/description/
 *
 * algorithms
 * Medium (63.27%)
 * Total Accepted:    114.8K
 * Total Submissions: 181.4K
 * Testcase Example:  '[[1,0,0],[-1,0,3]]\n[[7,0,0],[0,0,0],[0,0,1]]'
 *
 * Given two sparse matrices A and B, return the result of AB.
 * 
 * You may assume that A's column number is equal to B's row number.
 * 
 * Example:
 * 
 * 
 * Input:
 * 
 * A = [
 * ⁠ [ 1, 0, 0],
 * ⁠ [-1, 0, 3]
 * ]
 * 
 * B = [
 * ⁠ [ 7, 0, 0 ],
 * ⁠ [ 0, 0, 0 ],
 * ⁠ [ 0, 0, 1 ]
 * ]
 * 
 * Output:
 * 
 * ⁠    |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
 * AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
 * ⁠                 | 0 0 1 |
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= A.length, B.length <= 100
 * 1 <= A[i].length, B[i].length <= 100
 * -100 <= A[i][j], B[i][j] <= 100
 * 
 * 
 */
class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int n = A.length;
        int m = A[0].length;
        int l = B[0].length;
        int[][] ans = new int[n][l];
        Map<Integer, List<int[]>> aMap = create(A);
        Map<Integer, List<int[]>> bMap = create(B);
        for (int i : aMap.keySet()) {
            for (int[] a : aMap.get(i)) {
                if (!bMap.containsKey(a[0]))
                    continue;
                for (int[] b : bMap.get(a[0])) {
                    ans[i][b[0]] += a[1] * b[1];
                }
            }
        }
        
        return ans;
    }
    
    Map<Integer, List<int[]>> create(int[][] A) {
        Map<Integer, List<int[]>> aMap = new HashMap<>();
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < A[0].length; j++)
                if (A[i][j] != 0) {
                    if (!aMap.containsKey(i)) {
                        aMap.put(i, new ArrayList<>());
                    }
                    aMap.get(i).add(new int[] {j, A[i][j]});
                }
        return aMap;
    }
}
