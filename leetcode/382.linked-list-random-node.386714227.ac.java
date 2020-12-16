/*
 * @lc app=leetcode id=382 lang=java
 *
 * [382] Linked List Random Node
 *
 * https://leetcode.com/problems/linked-list-random-node/description/
 *
 * algorithms
 * Medium (53.66%)
 * Total Accepted:    98.3K
 * Total Submissions: 183.2K
 * Testcase Example:  '["Solution","getRandom","getRandom","getRandom","getRandom","getRandom"]\n' +
  '[[[1,2,3]],[],[],[],[],[]]'
 *
 * Given a singly linked list, return a random node's value from the linked
 * list. Each node must have the same probability of being chosen.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input
 * ["Solution", "getRandom", "getRandom", "getRandom", "getRandom",
 * "getRandom"]
 * [[[1, 2, 3]], [], [], [], [], []]
 * Output
 * [null, 1, 3, 2, 2, 3]
 * 
 * Explanation
 * Solution solution = new Solution([1, 2, 3]);
 * solution.getRandom(); // return 1
 * solution.getRandom(); // return 3
 * solution.getRandom(); // return 2
 * solution.getRandom(); // return 2
 * solution.getRandom(); // return 3
 * // getRandom() should return either 1, 2, or 3 randomly. Each element should
 * have equal probability of returning.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the linked list will be in the range [1, 10^4]
 * -10^4 <= Node.val <= 10^4
 * At most 10^4 calls will be made to getRandom.
 * 
 * 
 * 
 * Follow up:
 * 
 * 
 * What if the linked list is extremely large and its length is unknown to
 * you?
 * Could you solve this efficiently without using extra space?
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
    
    int n = 0;
    ListNode head;
    Random r = new Random();

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
        while (head != null) {
            head = head.next;
            n++;
        }
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode p = head;
        for (int i = n; i > 0; i--) {
            if (r.nextInt(i) == 0)
                break;
            p = p.next;
        }
        return p.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
