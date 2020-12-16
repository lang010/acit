/*
 * @lc app=leetcode id=1538 lang=java
 *
 * [1538] Guess the Majority in a Hidden Array
 *
 * https://leetcode.com/problems/guess-the-majority-in-a-hidden-array/description/
 *
 * algorithms
 * Medium (61.07%)
 * Total Accepted:    684
 * Total Submissions: 1.1K
 * Testcase Example:  '[0,0,1,0,1,1,1,1]'
 *
 * We have an integer array nums, where all the integers in nums are 0 or 1.
 * You will not be given direct access to the array, instead, you will have an
 * API ArrayReader which have the following functions:
 * 
 * 
 * int query(int a, int b, int c, int d): where 0 <= a < b < c < d <
 * ArrayReader.length(). The function returns the distribution of the value of
 * the 4 elements and returns:
 * 
 * 
 * 4 : if the values of the 4 elements are the same (0 or 1).
 * 2 : if three elements have a value equal to 0 and one element has value
 * equal to 1 or vice versa.
 * 0 : if two element have a value equal to 0 and two elements have a value
 * equal to 1.
 * 
 * 
 * int length(): Returns the size of the array.
 * 
 * 
 * You are allowed to call query() 2 * n times at most where n is equal to
 * ArrayReader.length().
 * 
 * Return any index of the most frequent value in nums, in case of tie, return
 * -1.
 * 
 * Follow up: What is the minimum number of calls needed to find the majority
 * element?
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [0,0,1,0,1,1,1,1]
 * Output: 5
 * Explanation: The following calls to the API
 * reader.length() // returns 8 because there are 8 elements in the hidden
 * array.
 * reader.query(0,1,2,3) // returns 2 this is a query that compares the
 * elements nums[0], nums[1], nums[2], nums[3]
 * // Three elements have a value equal to 0 and one element has value equal to
 * 1 or viceversa.
 * reader.query(4,5,6,7) // returns 4 because nums[4], nums[5], nums[6],
 * nums[7] have the same value.
 * we can infer that the most frequent value is found in the last 4 elements.
 * Index 2, 4, 6, 7 is also a correct answer.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [0,0,1,1,0]
 * Output: 0
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [1,0,1,0,1,0,1,0]
 * Output: -1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 5 <= nums.length <= 10^5
 * 0 <= nums[i] <= 1
 * 
 * 
 */
/**
 * // This is the ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *   public:
 *     // Compares 4 different elements in the array
 *     // return 4 if the values of the 4 elements are the same (0 or 1).
 *     // return 2 if three elements have a value equal to 0 and one element has value equal to 1 or vice versa.
 *     // return 0 : if two element have a value equal to 0 and two elements have a value equal to 1.
 *     public int query(int a, int b, int c, int d);
 *
 *     // Returns the length of the array
 *     public int length();
 * };
 */

class Solution {
    public int guessMajority(ArrayReader reader) {
        int x0 = 0, x1, cx, cy, yi = 0, st = 5;
        int n = reader.length();
        // init
        if (reader.query(0, 1, 2, 3) == 4) {
            // XXXX
            x0 = 0;
            x1 = 1;
            cx = 4;
            cy = 0;
            st = 4;
        } else {
            int[] vals = {
                reader.query(1, 2, 3, 4),
                reader.query(0, 2, 3, 4),
                reader.query(0, 1, 3, 4),
                reader.query(0, 1, 2, 4),
                reader.query(0, 1, 2, 3)
            };
            x1 = 4;
            cx = 1;
            cy = 0;
            for (int i = 0; i < 4; i++)
                if (vals[i] == vals[4]) {
                    cx++;
                    x0 = i;
                } else {
                    cy++;
                    yi = i;
                }
        }
        // Check every 2 elements starting from st
        while (st < n-1) {
            switch (reader.query(x0, x1, st, st+1)) {
                case 4:
                    cx += 2;
                    break;
                case 0:
                    cy += 2;
                    yi = st;
                    break;
                case 2:
                    cx++;
                    cy++;
                    break;
            }
            st += 2;
        }
        // check the last one value.
        if (st == n-1 && Math.abs(cx-cy) < 2) {
            int val = 0;
            if (yi < x0)
                val = reader.query(yi, x0, x1, n-1);
            else if (yi < x1)
                val = reader.query(x0, yi, x1, n-1);
            else
                val = reader.query(x0, x1, yi, n-1);
            if (val == 0)
                cy++;
            else
                cx++;
        }
        if (cx == cy)
            return -1;
        return cx > cy ? x0 : yi;
    }
}
