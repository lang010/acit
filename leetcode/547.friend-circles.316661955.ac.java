/*
 * @lc app=leetcode id=547 lang=java
 *
 * [547] Friend Circles
 *
 * https://leetcode.com/problems/friend-circles/description/
 *
 * algorithms
 * Medium (59.73%)
 * Total Accepted:    214.3K
 * Total Submissions: 358.8K
 * Testcase Example:  '[[1,1,0],[1,1,0],[0,0,1]]'
 *
 * There are N students in a class. Some of them are friends, while some are
 * not. Their friendship is transitive in nature. For example, if A is a direct
 * friend of B, and B is a direct friend of C, then A is an indirect friend of
 * C. And we defined a friend circle is a group of students who are direct or
 * indirect friends.
 * 
 * Given a N*N matrix M representing the friend relationship between students
 * in the class. If M[i][j] = 1, then the ith and jth students are direct
 * friends with each other, otherwise not. And you have to output the total
 * number of friend circles among all the students.
 * 
 * Example 1:
 * 
 * 
 * Input: 
 * [[1,1,0],
 * ⁠[1,1,0],
 * ⁠[0,0,1]]
 * Output: 2
 * Explanation:The 0th and 1st students are direct friends, so they are in a
 * friend circle. 
 * The 2nd student himself is in a friend circle. So return 2.
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 
 * [[1,1,0],
 * ⁠[1,1,1],
 * ⁠[0,1,1]]
 * Output: 1
 * Explanation:The 0th and 1st students are direct friends, the 1st and 2nd
 * students are direct friends, 
 * so the 0th and 2nd students are indirect friends. All of them are in the
 * same friend circle, so return 1.
 * 
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= N <= 200
 * M[i][i] == 1
 * M[i][j] == M[j][i]
 * 
 * 
 */
class Solution {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        int[] circles = new int[n];
        int cnt = 0;
        for (int i = 0; i < n; i++)
            if (circles[i] == 0) {
                dfs(M, circles, i, ++cnt);
            }
        
        return cnt;
    }
    
    void dfs(int[][] M, int[] circles, int id, int cnt) {
        if (circles[id] != 0)
            return;
        circles[id] = cnt;
        for (int i = 0; i < M.length; i++) {
            if (M[id][i] == 1)
                dfs(M, circles, i, cnt);
        }
    }
}
