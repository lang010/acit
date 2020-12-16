/*
 * @lc app=leetcode id=1482 lang=java
 *
 * [1482] Minimum Number of Days to Make m Bouquets
 *
 * https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/
 *
 * algorithms
 * Medium (49.20%)
 * Total Accepted:    16.3K
 * Total Submissions: 33.1K
 * Testcase Example:  '[1,10,3,10,2]\n3\n1'
 *
 * Given an integer array bloomDay, an integer m and an integer k.
 * 
 * We need to make m bouquets. To make a bouquet, you need to use k adjacent
 * flowers from the garden.
 * 
 * The garden consists of n flowers, the ith flower will bloom in the
 * bloomDay[i] and then can be used in exactly one bouquet.
 * 
 * Return the minimum number of days you need to wait to be able to make m
 * bouquets from the garden. If it is impossible to make m bouquets return
 * -1.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
 * Output: 3
 * Explanation: Let's see what happened in the first three days. x means flower
 * bloomed and _ means flower didn't bloom in the garden.
 * We need 3 bouquets each should contain 1 flower.
 * After day 1: [x, _, _, _, _]   // we can only make one bouquet.
 * After day 2: [x, _, _, _, x]   // we can only make two bouquets.
 * After day 3: [x, _, x, _, x]   // we can make 3 bouquets. The answer is 3.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: bloomDay = [1,10,3,10,2], m = 3, k = 2
 * Output: -1
 * Explanation: We need 3 bouquets each has 2 flowers, that means we need 6
 * flowers. We only have 5 flowers so it is impossible to get the needed
 * bouquets and we return -1.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: bloomDay = [7,7,7,7,12,7,7], m = 2, k = 3
 * Output: 12
 * Explanation: We need 2 bouquets each should have 3 flowers.
 * Here's the garden after the 7 and 12 days:
 * After day 7: [x, x, x, x, _, x, x]
 * We can make one bouquet of the first three flowers that bloomed. We cannot
 * make another bouquet from the last three flowers that bloomed because they
 * are not adjacent.
 * After day 12: [x, x, x, x, x, x, x]
 * It is obvious that we can make two bouquets in different ways.
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: bloomDay = [1000000000,1000000000], m = 1, k = 1
 * Output: 1000000000
 * Explanation: You need to wait 1000000000 days to have a flower ready for a
 * bouquet.
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: bloomDay = [1,10,2,9,3,8,4,7,5,6], m = 4, k = 2
 * Output: 9
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * bloomDay.length == n
 * 1 <= n <= 10^5
 * 1 <= bloomDay[i] <= 10^9
 * 1 <= m <= 10^6
 * 1 <= k <= n
 * 
 */
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (m*k > n)
            return -1;
        Set<Integer> set = new HashSet<>();
        for (int x : bloomDay)
            set.add(x);
        int[] arr = new int[set.size()];
        int i = 0;
        for (int x : set)
            arr[i++] = x;
        Arrays.sort(arr);
        int l = 0;
        int r = arr.length-1;
        while (l < r) {
            int mid = l + (r-l)/2;
            if (check(bloomDay, arr[mid], m, k)) {
                r = mid;
            } else {
                l = mid+1;
            }
        }
        
        return arr[l];
    }
    
    boolean check(int[] bd, int x, int m, int k) {
        int cur = 0;
        for (int i : bd) {
            if (i <= x) {
                cur++;
                if (cur == k) {
                    cur = 0;
                    m--;
                    if (m == 0)
                        return true;
                }
            } else {
                cur = 0;
            }
        }
        return false;
    }
}
