/*
 * @lc app=leetcode id=708 lang=java
 *
 * [708] Insert into a Sorted Circular Linked List
 *
 * https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/description/
 *
 * algorithms
 * Medium (32.28%)
 * Total Accepted:    50.6K
 * Total Submissions: 156.9K
 * Testcase Example:  '[3,4,1]\n2'
 *
 * Given a node from a Circular Linked List which is sorted in ascending order,
 * write a function to insert a value insertVal into the list such that it
 * remains a sorted circular list. The given node can be a reference to any
 * single node in the list, and may not be necessarily the smallest value in
 * the circular list.
 * 
 * If there are multiple suitable places for insertion, you may choose any
 * place to insert the new value. After the insertion, the circular list should
 * remain sorted.
 * 
 * If the list is empty (i.e., given node is null), you should create a new
 * single circular list and return the reference to that single node.
 * Otherwise, you should return the original given node.
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: head = [3,4,1], insertVal = 2
 * Output: [3,4,1,2]
 * Explanation: In the figure above, there is a sorted circular list of three
 * elements. You are given a reference to the node with value 3, and we need to
 * insert 2 into the list. The new node should be inserted between node 1 and
 * node 3. After the insertion, the list should look like this, and we should
 * still return node 3.
 * 
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: head = [], insertVal = 1
 * Output: [1]
 * Explanation: The list is empty (given head is null). We create a new single
 * circular list and return the reference to that single node.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: head = [1], insertVal = 0
 * Output: [1,0]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= Number of Nodes <= 5 * 10^4
 * -10^6 <= Node.val <= 10^6
 * -10^6 <= insertVal <= 10^6
 * 
 * 
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            head = new Node(insertVal);
            head.next = head;
            return head;
        }
        if (head.next == head) {
            head.next = new Node(insertVal);
            head.next.next = head;
            return head;
        }
        Node pre = head, next = head.next;
        while (true) {
            if (next == head && pre.val == head.val)
                return insert(pre, next, insertVal);
            if (pre.val <= next.val) {
                if (pre.val <= insertVal && insertVal <= next.val)
                    return insert(pre, next, insertVal);
            } else {
                if (pre.val <= insertVal || insertVal <= next.val)
                    return insert(pre, next, insertVal);
            }
            pre = next;
            next = next.next;
        }
    }
    
    Node insert(Node pre, Node next, int val) {
        pre.next = new Node(val, next);
        return pre;
    }
}
