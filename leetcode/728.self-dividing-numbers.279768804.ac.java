/*
 * @lc app=leetcode id=728 lang=java
 *
 * [728] Self Dividing Numbers
 *
 * https://leetcode.com/problems/self-dividing-numbers/description/
 *
 * algorithms
 * Easy (75.10%)
 * Total Accepted:    140.1K
 * Total Submissions: 186.5K
 * Testcase Example:  '1\n22'
 *
 * 
 * A self-dividing number is a number that is divisible by every digit it
 * contains.
 * 
 * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 ==
 * 0, and 128 % 8 == 0.
 * 
 * Also, a self-dividing number is not allowed to contain the digit zero.
 * 
 * Given a lower and upper number bound, output a list of every possible self
 * dividing number, including the bounds if possible.
 * 
 * Example 1:
 * 
 * Input: 
 * left = 1, right = 22
 * Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * 
 * 
 * 
 * Note:
 * The boundaries of each input argument are 1 .
 * 
 */
class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> r = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (is(i)) {
                r.add(i);
            }
        }
        return r;
    }
    boolean is(int x) {
        int xx = x;
        while (x > 0) {
            int l = x % 10;
            if (l == 0) {
                return false;
            }
            if (xx % l != 0) {
                return false;
            }
            x = x/10;
        }
        return true;
    }
}
