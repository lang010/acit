/*
 * @lc app=leetcode id=582 lang=java
 *
 * [582] Kill Process
 *
 * https://leetcode.com/problems/kill-process/description/
 *
 * algorithms
 * Medium (62.12%)
 * Total Accepted:    39K
 * Total Submissions: 62.8K
 * Testcase Example:  '[1,3,10,5]\n[3,0,5,3]\n5'
 *
 * Given n processes, each process has a unique PID (process id) and its PPID
 * (parent process id). 
 * 
 * Each process only has one parent process, but may have one or more children
 * processes. This is just like a tree structure.  Only one process has PPID
 * that is 0, which means this process has no parent process. All the PIDs will
 * be distinct positive integers.
 * 
 * We use two list of integers to represent a list of processes, where the
 * first list contains PID for each process and the second list contains the
 * corresponding PPID. 
 * ⁠
 * Now given the two lists, and a PID representing a process you want to kill,
 * return a list of PIDs of processes that will be killed in the end. You
 * should assume that when a process is killed, all its children processes will
 * be killed. No order is required for the final answer.
 * 
 * Example 1:
 * 
 * Input: 
 * pid =  [1, 3, 10, 5]
 * ppid = [3, 0, 5, 3]
 * kill = 5
 * Output: [5,10]
 * Explanation: 
 * ⁠          3
 * ⁠        /   \
 * ⁠       1     5
 * ⁠            /
 * ⁠           10
 * Kill 5 will also kill 10.
 * 
 * 
 * 
 * Note:
 * 
 * The given kill id is guaranteed to be one of the given PIDs.
 * n >= 1.
 * 
 * 
 */
class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < pid.size(); i++) {
            Integer pp = ppid.get(i);
            Integer p = pid.get(i);
            if (!map.containsKey(pp))
                map.put(pp, new HashSet<>());
            map.get(pp).add(p);
        }
        List<Integer> ans = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<Integer>();
        queue.offer(kill);
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            ans.add(cur);
            if (map.containsKey(cur))
                for (Integer i : map.get(cur))
                    queue.offer(i);
        }
        return ans;
    }
}
