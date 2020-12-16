/*
 * @lc app=leetcode id=886 lang=java
 *
 * [886] Possible Bipartition
 *
 * https://leetcode.com/problems/possible-bipartition/description/
 *
 * algorithms
 * Medium (44.76%)
 * Total Accepted:    66.9K
 * Total Submissions: 149.5K
 * Testcase Example:  '4\n[[1,2],[1,3],[2,4]]'
 *
 * Given a set of N people (numbered 1, 2, ..., N), we would like to split
 * everyone into two groups of any size.
 * 
 * Each person may dislike some other people, and they should not go into the
 * same group. 
 * 
 * Formally, if dislikes[i] = [a, b], it means it is not allowed to put the
 * people numbered a and b into the same group.
 * 
 * Return true if and only if it is possible to split everyone into two groups
 * in this way.
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
 * Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
 * Output: true
 * Explanation: group1 [1,4], group2 [2,3]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
 * Output: false
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 * Output: false
 * 
 * 
 * 
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= N <= 2000
 * 0 <= dislikes.length <= 10000
 * dislikes[i].length == 2
 * 1 <= dislikes[i][j] <= N
 * dislikes[i][0] < dislikes[i][1]
 * There does not exist i != j for which dislikes[i] == dislikes[j].
 * 
 */
class Solution {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    int[] set;
    public boolean possibleBipartition(int N, int[][] dislikes) {
        N++;
        set = new int[N];
        for (int[] dl : dislikes) {
            add(dl[0], dl[1]);
            add(dl[1], dl[0]);
        }
        for (int i = 1; i < N; i++)
            if (set[i] == 0)
                if (!set(i, 1))
                    return false;
        return true;
    }
    
    void add(int x, int y) {
        Set<Integer> s = map.get(x);
        if (s == null) {
            s = new HashSet<>();
            map.put(x, s);
        }
        s.add(y);
    }
    
    boolean set(int x, int v) {
        set[x] = v;
        Set<Integer> dl = map.get(x);
        int yv = v == 1 ? 2 : 1;
        if (dl != null)
            for (int y : dl) {
                if (set[y] > 0 && set[y] == v)
                    return false;
                if (set[y] == 0 && !set(y, yv))
                    return false;
            }
        return true;
    }
}
