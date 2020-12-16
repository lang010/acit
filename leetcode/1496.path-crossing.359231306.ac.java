/*
 * @lc app=leetcode id=1496 lang=java
 *
 * [1496] Path Crossing
 *
 * https://leetcode.com/problems/path-crossing/description/
 *
 * algorithms
 * Easy (55.60%)
 * Total Accepted:    20.5K
 * Total Submissions: 36.9K
 * Testcase Example:  '"NES"'
 *
 * Given a string path, where path[i] = 'N', 'S', 'E' or 'W', each representing
 * moving one unit north, south, east, or west, respectively. You start at the
 * origin (0, 0) on a 2D plane and walk on the path specified by path.
 * 
 * Return True if the path crosses itself at any point, that is, if at any time
 * you are on a location you've previously visited. Return False otherwise.
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: path = "NES"
 * Output: false 
 * Explanation: Notice that the path doesn't cross any point more than once.
 * 
 * 
 * Example 2:
 * 
 * 
 * 
 * 
 * Input: path = "NESWW"
 * Output: true
 * Explanation: Notice that the path visits the origin twice.
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= path.length <= 10^4
 * path will only consist of characters in {'N', 'S', 'E', 'W}
 * 
 * 
 */
class Solution {
    public boolean isPathCrossing(String path) {
        Set<Integer> set = new HashSet<>();
        int cur = 0;
        set.add(cur);
        for (char c : path.toCharArray()) {
            cur = next(cur, c);
            if (set.contains(cur))
                return true;
            set.add(cur);
        }
        return false;
    }
    
    int next(int cur, char c) {
        switch(c) {
            case 'N':
                return cur+1;
            case 'S':
                return cur-1;
            case 'E':
                return cur+10001;
            case 'W':
                return cur-10001;
        }
        return cur;
    }
}
