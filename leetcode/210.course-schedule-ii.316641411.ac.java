/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 *
 * https://leetcode.com/problems/course-schedule-ii/description/
 *
 * algorithms
 * Medium (41.95%)
 * Total Accepted:    340.1K
 * Total Submissions: 810.8K
 * Testcase Example:  '2\n[[1,0]]'
 *
 * There are a total of n courses you have to take labelled from 0 to n - 1.
 * 
 * Some courses may have prerequisites, for example, if prerequisites[i] = [ai,
 * bi] this means you must take the course bi before the course ai.
 * 
 * Given the total number of courses numCourses and a list of the prerequisite
 * pairs, return the ordering of courses you should take to finish all
 * courses.
 * 
 * If there are many valid answers, return any of them. If it is impossible to
 * finish all courses, return an empty array.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you
 * should have finished course 0. So the correct course order is [0,1].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you
 * should have finished both courses 1 and 2. Both courses 1 and 2 should be
 * taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is
 * [0,2,1,3].
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: numCourses = 1, prerequisites = []
 * Output: [0]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * ai != bi
 * All the pairs [ai, bi] are distinct.
 * 
 * 
 */
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] map = new List[numCourses];
        for (int[] dep : prerequisites) {
            if (map[dep[0]] == null)
                map[dep[0]] = new ArrayList<>();
            map[dep[0]].add(dep[1]);
        }
        List<Integer> postOrder = new ArrayList<>(numCourses);
        boolean[] checked = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, map, checked, path, postOrder))
                return new int[0];
        }
        int[] ans = new int[numCourses];
        int i = 0;
        for (int x : postOrder)
            ans[i++] = x;
        return ans;
    }
    
    boolean dfs(int curr, List<Integer>[] map, boolean[] checked, boolean[] path, List<Integer> postOrder) {
        if (path[curr])
            return true;
        if (checked[curr])
            return false;
        
        checked[curr] = true;
        if (map[curr] == null) {
            postOrder.add(curr);
            return false;
        }
        path[curr] = true;
        for (int next : map[curr]) {
            if (dfs(next, map, checked, path, postOrder))
                return true;
        }
        path[curr] = false;
        postOrder.add(curr);
        return false;
    }
}
