/*
 * @lc app=leetcode id=179 lang=java
 *
 * [179] Largest Number
 *
 * https://leetcode.com/problems/largest-number/description/
 *
 * algorithms
 * Medium (30.24%)
 * Total Accepted:    227.2K
 * Total Submissions: 751.4K
 * Testcase Example:  '[10,2]'
 *
 * Given a list of non-negative integers nums, arrange them such that they form
 * the largest number.
 * 
 * Note: The result may be very large, so you need to return a string instead
 * of an integer.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [10,2]
 * Output: "210"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [3,30,34,5,9]
 * Output: "9534330"
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [1]
 * Output: "1"
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: nums = [10]
 * Output: "10"
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 10^9
 * 
 * 
 */
class Solution {
    public String largestNumber(int[] nums) {
        int sum = 0;
        for (int x : nums) {
            sum += x;
            if (sum != 0)
                break;
        }
        if (sum == 0)
            return "0";
        Character[][] chars = new Character[nums.length][];
        for (int i = 0; i < nums.length; i++) {
            chars[i] = toChar(nums[i]);
        }
        Arrays.sort(chars, new Comparator<Character[]>() {
            @Override
            public int compare(Character[] x, Character[] y) {
                int i = 0;
                int j = 0;
                while (true) {
                    if (x[i] != y[j])
                        return y[j] - x[i];
                    i++;
                    j++;
                    if (i == x.length && j == y.length)
                        break;
                    else if (i == x.length)
                        i = 0;
                    else if (j == y.length)
                        j = 0;
                }
                return 0;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++)
                sb.append(chars[i][j]);
        }
        return sb.toString();
    }
    
    Character[] toChar(int x) {
        int l = 1;
        int t = x/10;
        while (t > 0) {
            l++;
            t = t/10;
        }
        Character[] ans = new Character[l];
        t = 0;
        while (t < l) {
            ans[t++] = (char) ('0' + x % 10);
            x /= 10;
        }
        int i = 0;
        int j = l-1;
        while (i < j) {
            Character c = ans[i];
            ans[i] = ans[j];
            ans[j] = c;
            i++;
            j--;
        }
        return ans;
    }
}
