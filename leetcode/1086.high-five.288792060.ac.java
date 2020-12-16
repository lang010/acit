/*
 * @lc app=leetcode id=1086 lang=java
 *
 * [1086] High Five
 *
 * https://leetcode.com/problems/high-five/description/
 *
 * algorithms
 * Easy (79.27%)
 * Total Accepted:    43.7K
 * Total Submissions: 55.2K
 * Testcase Example:  '[[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]'
 *
 * Given a list of the scores of different students, items, where items[i] =
 * [IDi, scorei] represents one score from a student with IDi, calculate each
 * student's top five average.
 * 
 * Return the answer as an array of pairs result, where result[j] = [IDj,
 * topFiveAveragej] represents the student with IDj and their top five average.
 * Sort result by IDj in increasing order.
 * 
 * A student's top five average is calculated by taking the sum of their top
 * five scores and dividing it by 5 using integer division.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: items =
 * [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
 * Output: [[1,87],[2,88]]
 * Explanation: 
 * The student with ID = 1 got scores 91, 92, 60, 65, 87, and 100. Their top
 * five average is (100 + 92 + 91 + 87 + 65) / 5 = 87.
 * The student with ID = 2 got scores 93, 97, 77, 100, and 76. Their top five
 * average is (100 + 97 + 93 + 77 + 76) / 5 = 88.6, but with integer division
 * their average converts to 88.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: items =
 * [[1,100],[7,100],[1,100],[7,100],[1,100],[7,100],[1,100],[7,100],[1,100],[7,100]]
 * Output: [[1,100],[7,100]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= items.length <= 1000
 * items[i].length == 2
 * 1 <= IDi <= 1000
 * 0 <= scorei <= 100
 * For each IDi, there will be at least five scores.
 * 
 * 
 */
class Solution {
    static class Comp implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return b[1] - a[1];
        }
    };
    public int[][] highFive(int[][] items) {
        Arrays.sort(items, new Comp());
        List<int[]> ans = new ArrayList<>();
        int n = items.length;
        for (int i = 0; i < n; ) {
            int sum = 0;
            int cnt = 0;
            int id = items[i][0];
            while (i < n && id == items[i][0] && cnt < 5) {
                cnt++;
                sum += items[i][1];
                i++;
            }
            while (i < n && id == items[i][0]) {
                i++;
            }
            int[] ls = new int[2];
            ls[0] = id;
            ls[1] = sum/cnt;
            ans.add(ls);
        }
        int[][] res = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}
