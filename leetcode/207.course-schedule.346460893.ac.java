/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 *
 * https://leetcode.com/problems/course-schedule/description/
 *
 * algorithms
 * Medium (44.02%)
 * Total Accepted:    506.5K
 * Total Submissions: 1.2M
 * Testcase Example:  '2\n[[1,0]]'
 *
 * There are a total of numCourses courses you have to take, labeled from 0 to
 * numCourses-1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have
 * to first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, is it
 * possible for you to finish all courses?
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0. So it is possible.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0, and to take course 0 you
 * should
 * also have finished course 1. So it is impossible.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The input prerequisites is a graph represented by a list of edges, not
 * adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input
 * prerequisites.
 * 1 <= numCourses <= 10^5
 * 
 * 
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] map = new List[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            if (map[prerequisites[i][0]] == null)
                map[prerequisites[i][0]] = new ArrayList<Integer>();
            map[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        boolean[] global = new boolean[numCourses];
        boolean[] local = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (hasCycles(map, global, local, i))
                return false;
        }
        return true;
    }
    
    boolean hasCycles(List<Integer>[] map, boolean[] global, boolean[] local, int s) {
        if (local[s])
            return true;
        if (global[s])
            return false;
        global[s] = true;
        if (map[s] == null)
            return false;
        local[s] = true;
        for (int next : map[s]) {
            if (hasCycles(map, global, local, next))
                return true;
        }
        local[s] = false;
        return false;
    }
    
    /*
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> pre = new HashMap<>();
        Map<Integer, Set<Integer>> post = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            add(pre, prerequisites[i][1], prerequisites[i][0]);
            add(post, prerequisites[i][0], prerequisites[i][1]);
        }
        while (true) {
            int cnt = 0;
            for (int i = 0; i < numCourses; i++) {
                if (pre.get(i) == null|| pre.get(i).size() == 0) {
                    if (post.get(i) != null && post.get(i).size() > 0) {
                        for (int j : post.get(i)) {
                            pre.get(j).remove(i);
                            cnt++;
                        }
                        post.get(i).clear();
                    }
                }
            }
            if (cnt == 0)
                break;
        }
        for (int x : post.keySet()) {
            if (post.get(x).size() > 0)
                return false;
        }
        return true;
    }
    
    void add(Map<Integer, Set<Integer>> map, int x, int y) {
        if (!map.containsKey(x))
            map.put(x, new HashSet<Integer>());
        map.get(x).add(y);
    }
    */
}
