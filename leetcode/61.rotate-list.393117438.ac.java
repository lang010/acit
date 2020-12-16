/*
 * @lc app=leetcode id=61 lang=java
 *
 * [61] Rotate List
 *
 * https://leetcode.com/problems/rotate-list/description/
 *
 * algorithms
 * Medium (31.38%)
 * Total Accepted:    336.8K
 * Total Submissions: 1.1M
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * Given the head of a linked list, rotate the list to the right by k
 * places.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: head = [0,1,2], k = 4
 * Output: [2,0,1]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the list is in the range [0, 500].
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 10^9
 * 
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;
        int n = cnt(head);
        k %= n;
        if (k == 0)
            return head;
        ListNode h1, e1, h2, e2;
        h1 = e1 = head;
        for (int i = 1; i < n - k; i++)
            e1 = e1.next;
        h2 = e2 = e1.next;
        while (e2.next != null)
            e2 = e2.next;
        e1.next = null;
        e2.next = h1;
        return h2;
    }
    
    int cnt(ListNode h) {
        int ans = 0;
        while (h != null) {
            ans++;
            h = h.next;
        }
        return ans;
    }
}
