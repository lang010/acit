/*
 * @lc app=leetcode id=605 lang=java
 *
 * [605] Can Place Flowers
 *
 * https://leetcode.com/problems/can-place-flowers/description/
 *
 * algorithms
 * Easy (32.01%)
 * Total Accepted:    142.5K
 * Total Submissions: 445.4K
 * Testcase Example:  '[1,0,0,0,1]\n1'
 *
 * You have a long flowerbed in which some of the plots are planted, and some
 * are not. However, flowers cannot be planted in adjacent plots.
 * 
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty
 * and 1 means not empty, and an integer n, return if n new flowers can be
 * planted in the flowerbed without violating the no-adjacent-flowers rule.
 * 
 * 
 * Example 1:
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: true
 * Example 2:
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: false
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= flowerbed.length <= 2 * 10^4
 * flowerbed[i] is 0 or 1.
 * There are no two adjacent flowers in flowerbed.
 * 0 <= n <= flowerbed.length
 * 
 * 
 */
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }
        int cnt = 0;
        int sum = 1;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                sum++;
            } else {
                if (sum > 2) {
                    cnt += (sum - 1)/2;
                    if (cnt >= n) {
                        return true;
                    }
                }
                sum = 0;
            }
        }
        sum++;
        if (sum > 2) {
            cnt += (sum - 1)/2;
            if (cnt >= n) {
                return true;
            }
        }
        return false;
    }
}
