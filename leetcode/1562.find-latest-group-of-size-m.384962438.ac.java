/*
 * @lc app=leetcode id=1562 lang=java
 *
 * [1562] Find Latest Group of Size M
 *
 * https://leetcode.com/problems/find-latest-group-of-size-m/description/
 *
 * algorithms
 * Medium (38.99%)
 * Total Accepted:    8.6K
 * Total Submissions: 22K
 * Testcase Example:  '[3,5,1,2,4]\n1'
 *
 * Given an array arr that represents a permutation of numbers from 1 to n. You
 * have a binary string of size n that initially has all its bits set to zero.
 * 
 * At each step i (assuming both the binary string and arr are 1-indexed) from
 * 1 to n, the bit at position arr[i] is set to 1. You are given an integer m
 * and you need to find the latest step at which there exists a group of ones
 * of length m. A group of ones is a contiguous substring of 1s such that it
 * cannot be extended in either direction.
 * 
 * Return the latest step at which there exists a group of ones of length
 * exactly m. If no such group exists, return -1.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: arr = [3,5,1,2,4], m = 1
 * Output: 4
 * Explanation:
 * Step 1: "00100", groups: ["1"]
 * Step 2: "00101", groups: ["1", "1"]
 * Step 3: "10101", groups: ["1", "1", "1"]
 * Step 4: "11101", groups: ["111", "1"]
 * Step 5: "11111", groups: ["11111"]
 * The latest step at which there exists a group of size 1 is step 4.
 * 
 * Example 2:
 * 
 * 
 * Input: arr = [3,1,5,4,2], m = 2
 * Output: -1
 * Explanation:
 * Step 1: "00100", groups: ["1"]
 * Step 2: "10100", groups: ["1", "1"]
 * Step 3: "10101", groups: ["1", "1", "1"]
 * Step 4: "10111", groups: ["1", "111"]
 * Step 5: "11111", groups: ["11111"]
 * No group of size 2 exists during any step.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: arr = [1], m = 1
 * Output: 1
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: arr = [2,1], m = 2
 * Output: 2
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * n == arr.length
 * 1 <= n <= 10^5
 * 1 <= arr[i] <= n
 * All integers in arr are distinct.
 * 1 <= m <= arr.length
 * 
 * 
 */
class Solution {
    public int findLatestStep(int[] arr, int m) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 0);
        int ans = -1;
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i];
            int len = 1;
            if (map.containsKey(cur+1)) {
                if (map.get(cur+1) == m)
                    cnt--;
                len += map.get(cur+1);
                map.remove(cur+1);
            }
            int l = map.lowerKey(cur);
            if (l + map.get(l) == cur) {
                if (map.get(l) == m)
                    cnt--;
                len += map.get(l);
                cur = l;
            }
            if (len == m) {
                cnt++;
            }
            if (cnt > 0)
                ans = i+1;
            map.put(cur, len);
        }
        return ans;
    }
}
