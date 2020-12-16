/*
 * @lc app=leetcode id=947 lang=java
 *
 * [947] Most Stones Removed with Same Row or Column
 *
 * https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/description/
 *
 * algorithms
 * Medium (55.27%)
 * Total Accepted:    61.3K
 * Total Submissions: 110.8K
 * Testcase Example:  '[[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]'
 *
 * On a 2D plane, we place stones at some integer coordinate points.  Each
 * coordinate point may have at most one stone.
 * 
 * Now, a move consists of removing a stone that shares a column or row with
 * another stone on the grid.
 * 
 * What is the largest possible number of moves we can make?
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
 * Output: 5
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
 * Output: 3
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: stones = [[0,0]]
 * Output: 0
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= stones.length <= 1000
 * 0 <= stones[i][j] < 10000
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    int sz = 0;
    public int removeStones(int[][] stones) {
        for (int[] st : stones)
            union(st[0], st[1]+100000);
        return stones.length - sz;
    }
    
    int find(int x) {
        if (!map.containsKey(x)) {
            map.put(x, x);
            sz++;
            return x;
        }
        int p = map.get(x);
        if (p != x)
            p = find(p);
        map.put(x, p);
        return p;
    }
    
    void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            map.put(x, y);
            sz--;
        }
    }
}
