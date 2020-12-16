/*
 * @lc app=leetcode id=218 lang=java
 *
 * [218] The Skyline Problem
 *
 * https://leetcode.com/problems/the-skyline-problem/description/
 *
 * algorithms
 * Hard (35.85%)
 * Total Accepted:    155.6K
 * Total Submissions: 433.9K
 * Testcase Example:  '[[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]'
 *
 * A city's skyline is the outer contour of the silhouette formed by all the
 * buildings in that city when viewed from a distance. Given the locations and
 * heights of all the buildings, return the skyline formed by these buildings
 * collectively.
 * 
 * The geometric information of each building is given in the array buildings
 * where buildings[i] = [lefti, righti, heighti]:
 * 
 * 
 * lefti is the x coordinate of the left edge of the i^th building.
 * righti is the x coordinate of the right edge of the i^th building.
 * heighti is the height of the i^th building.
 * 
 * 
 * You may assume all buildings are perfect rectangles grounded on an
 * absolutely flat surface at height 0.
 * 
 * The skyline should be represented as a list of "key points" sorted by their
 * x-coordinate in the form [[x1,y1],[x2,y2],...]. Each key point is the left
 * endpoint of some horizontal segment in the skyline except the last point in
 * the list, which always has a y-coordinate 0 and is used to mark the
 * skyline's termination where the rightmost building ends. Any ground between
 * the leftmost and rightmost buildings should be part of the skyline's
 * contour.
 * 
 * Note: There must be no consecutive horizontal lines of equal height in the
 * output skyline. For instance, [...,[2 3],[4 5],[7 5],[11 5],[12 7],...] is
 * not acceptable; the three lines of height 5 should be merged into one in the
 * final output as such: [...,[2 3],[4 5],[12 7],...]
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
 * Output: [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
 * Explanation:
 * Figure A shows the buildings of the input.
 * Figure B shows the skyline formed by those buildings. The red points in
 * figure B represent the key points in the output list.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: buildings = [[0,2,3],[2,5,3]]
 * Output: [[0,3],[5,0]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= buildings.length <= 10^4
 * 0 <= lefti < righti <= 2^31 - 1
 * 1 <= heighti <= 2^31 - 1
 * buildings is sorted by lefti in non-decreasing order.
 * 
 * 
 */
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(Integer.MAX_VALUE, 0);
        for (int[] b : buildings) {
            while (map.firstKey() < b[0]) {
                int k = map.firstKey();
                map.remove(k);
                ans.add(Arrays.asList(k, map.firstEntry().getValue()));
            }
            int h = map.firstEntry().getValue();
            if (b[2] > h) {
                // [[1,2,1],[1,2,2],[1,2,3]]
                if (ans.size() > 0 && ans.get(ans.size()-1).get(0) == b[0])
                    ans.get(ans.size()-1).set(1, b[2]);
                else
                    ans.add(Arrays.asList(b[0], b[2]));
            }
            if (map.ceilingEntry(b[1]).getValue() >= b[2])
                continue;
            map.put(b[1], b[2]);
            while (true) {
                Map.Entry<Integer, Integer> entry = map.lowerEntry(b[1]);
                if (entry == null || entry.getValue() > b[2])
                    break;
                map.remove(entry.getKey());
            }
        }
        while (map.size() > 1) {
            Map.Entry<Integer, Integer> entry = map.firstEntry();
            map.remove(entry.getKey());
            ans.add(Arrays.asList(entry.getKey(), map.firstEntry().getValue()));
        }
        if (map.get(Integer.MAX_VALUE) != 0)
            ans.add(Arrays.asList(Integer.MAX_VALUE, 0));
        return ans;
    }
}
