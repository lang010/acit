/*
 * @lc app=leetcode id=277 lang=java
 *
 * [277] Find the Celebrity
 *
 * https://leetcode.com/problems/find-the-celebrity/description/
 *
 * algorithms
 * Medium (42.89%)
 * Total Accepted:    143.7K
 * Total Submissions: 335.1K
 * Testcase Example:  '[[1,1,0],[0,1,0],[1,1,1]]'
 *
 * Suppose you are at a party with n people (labeled from 0 to n - 1), and
 * among them, there may exist one celebrity. The definition of a celebrity is
 * that all the other n - 1 people know him/her, but he/she does not know any
 * of them.
 * 
 * Now you want to find out who the celebrity is or verify that there is not
 * one. The only thing you are allowed to do is to ask questions like: "Hi, A.
 * Do you know B?" to get information about whether A knows B. You need to find
 * out the celebrity (or verify there is not one) by asking as few questions as
 * possible (in the asymptotic sense).
 * 
 * You are given a helper function bool knows(a, b) which tells you whether A
 * knows B. Implement a function int findCelebrity(n). There will be exactly
 * one celebrity if he/she is in the party. Return the celebrity's label if
 * there is a celebrity in the party. If there is no celebrity, return -1.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: graph = [[1,1,0],[0,1,0],[1,1,1]]
 * Output: 1
 * Explanation: There are three persons labeled with 0, 1 and 2. graph[i][j] =
 * 1 means person i knows person j, otherwise graph[i][j] = 0 means person i
 * does not know person j. The celebrity is the person labeled as 1 because
 * both 0 and 2 know him but 1 does not know anybody.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: graph = [[1,0,1],[1,1,0],[0,1,1]]
 * Output: -1
 * Explanation: There is no celebrity.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * n == graph.length
 * n == graph[i].length
 * 2 <= n <= 100
 * graph[i][j] is 0 or 1.
 * graph[i][i] == 1
 * 
 * 
 */
/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        Map<Integer, Set<Integer>> pre = new HashMap<>();
        Map<Integer, Set<Integer>> post = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (knows(i,j)) {
                    add(pre, i, j);
                    add(post, j, i);
                }
                if (knows(j,i)) {
                    add(pre, j, i);
                    add(post, i, j);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            Set<Integer> set = post.get(i);
            if (pre.get(i) == null && set != null && set.size() == n-1) {
                return i;
            }
        }
        return -1;
    }
    void add(Map<Integer, Set<Integer>> map, int x, int y) {
        if (!map.containsKey(x)) {
            map.put(x, new HashSet<Integer>());
        }
        map.get(x).add(y);
    }
}
