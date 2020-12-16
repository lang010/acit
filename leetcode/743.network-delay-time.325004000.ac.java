/*
 * @lc app=leetcode id=743 lang=java
 *
 * [743] Network Delay Time
 *
 * https://leetcode.com/problems/network-delay-time/description/
 *
 * algorithms
 * Medium (45.16%)
 * Total Accepted:    125.4K
 * Total Submissions: 277.6K
 * Testcase Example:  '[[2,1,1],[2,3,1],[3,4,1]]\n4\n2'
 *
 * There are N network nodes, labelled 1 to N.
 * 
 * Given times, a list of travel times as directed edges times[i] = (u, v, w),
 * where u is the source node, v is the target node, and w is the time it takes
 * for a signal to travel from source to target.
 * 
 * Now, we send a signal from a certain node K. How long will it take for all
 * nodes to receive the signal? If it is impossible, return -1.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
 * Output: 2
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * N will be in the range [1, 100].
 * K will be in the range [1, N].
 * The length of times will be in the range [1, 6000].
 * All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 0 <= w <= 100.
 * 
 * 
 */
class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        int max = 0;
        N++;
        int[] val = new int[N];
        for (int i = 1; i < N; i++)
            val[i] = Integer.MAX_VALUE;
        List<int[]>[] map = new List[N];
        for (int[] e : times) {
            if (map[e[0]] == null)
                map[e[0]] = new ArrayList<>();
            map[e[0]].add(new int[] {e[1], e[2]});
        }
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(K);
        val[K] = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (map[cur] == null)
                continue;
            int tm = val[cur];
            for (int[] next : map[cur]) {
                if (val[next[0]] > tm + next[1]) {
                    val[next[0]] = tm + next[1];
                    queue.offer(next[0]);
                }
            }
        }
        for (int i = 1; i < N; i++) {
            if (val[i] == Integer.MAX_VALUE)
                return -1;
            max = Math.max(max, val[i]);
        }
        
        return max;
    }
}