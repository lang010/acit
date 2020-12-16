/*
 * @lc app=leetcode id=328 lang=java
 *
 * [328] Odd Even Linked List
 *
 * https://leetcode.com/problems/odd-even-linked-list/description/
 *
 * algorithms
 * Medium (56.66%)
 * Total Accepted:    330.3K
 * Total Submissions: 582.9K
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * Given a singly linked list, group all odd nodes together followed by the
 * even nodes. Please note here we are talking about the node number and not
 * the value in the nodes.
 * 
 * You should try to do it in place. The program should run in O(1) space
 * complexity and O(nodes) time complexity.
 * 
 * Example 1:
 * 
 * 
 * Input: 1->2->3->4->5->NULL
 * Output: 1->3->5->2->4->NULL
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 2->1->3->5->6->4->7->NULL
 * Output: 2->3->6->7->1->5->4->NULL
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The relative order inside both the even and odd groups should remain as it
 * was in the input.
 * The first node is considered odd, the second node even and so on ...
 * The length of the linked list is between [0, 10^4].
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
    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return head;
        ListNode o, e, c, ohead = head.next;
        int cnt = 0;
        o = e = new ListNode();
        c = head;
        cnt = 0;
        while (c != null) {
            if (cnt%2 == 0) {
                e.next = c;
                e = c;
                c = c.next;
                e.next = null;
            } else {
                o.next = c;
                o = c;
                c = c.next;
                o.next = null;
            }
            cnt++;
        }
        e.next = ohead;
        return head;
    }
}
