/*
 * @lc app=leetcode id=460 lang=java
 *
 * [460] LFU Cache
 *
 * https://leetcode.com/problems/lfu-cache/description/
 *
 * algorithms
 * Hard (35.34%)
 * Total Accepted:    89.1K
 * Total Submissions: 252.2K
 * Testcase Example:  '["LFUCache","put","put","get","put","get","get","put","get","get","get"]\n' +
  '[[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]'
 *
 * Design and implement a data structure for Least Frequently Used (LFU)
 * cache.
 * 
 * Implement the LFUCache class:
 * 
 * 
 * LFUCache(int capacity) Initializes the object with the capacity of the data
 * structure.
 * int get(int key) Gets the value of the key if the key exists in the cache.
 * Otherwise, returns -1.
 * void put(int key, int value) Sets or inserts the value if the key is not
 * already present. When the cache reaches its capacity, it should invalidate
 * the least frequently used item before inserting a new item. For this
 * problem, when there is a tie (i.e., two or more keys with the same
 * frequency), the least recently used key would be evicted.
 * 
 * 
 * Notice that the number of times an item is used is the number of calls to
 * the get and put functions for that item since it was inserted. This number
 * is set to zero when the item is removed.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input
 * ["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get",
 * "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, 3, null, -1, 3, 4]
 * 
 * Explanation
 * LFUCache lfu = new LFUCache(2);
 * lfu.put(1, 1);
 * lfu.put(2, 2);
 * lfu.get(1);      // return 1
 * lfu.put(3, 3);   // evicts key 2
 * lfu.get(2);      // return -1 (not found)
 * lfu.get(3);      // return 3
 * lfu.put(4, 4);   // evicts key 1.
 * lfu.get(1);      // return -1 (not found)
 * lfu.get(3);      // return 3
 * lfu.get(4);      // return 4
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= capacity, key, value <= 10^4
 * At most 10^5 calls will be made to get and put.
 * 
 * 
 * 
 * Follow up: Could you do both operations in O(1) time complexity? 
 */
class LFUCache {
    static class HNode {
        int sz = 0;
        int cnt = -1;
        VNode head = new VNode(0, 0);
        HNode pre, next;
        HNode() {
            pre = next = this;
            head.p = this;
        }
    };
    static class VNode {
        int k, v;
        HNode p;
        VNode pre, next;
        VNode(int k, int v) {
            this.k = k;
            this.v = v;
            pre = next = this;
        }
    };
    
    Map<Integer, VNode> map = new HashMap<>();
    HNode head = new HNode();
    int cap;

    public LFUCache(int capacity) {
        cap = capacity;
    }
    
    public int get(int key) {
        VNode node = map.get(key);
        if (node == null)
            return -1;
        forward(node);
        return node.v;
    }
    
    public void put(int key, int value) {
        if (cap < 1)
            return;
        VNode node = map.get(key);
        if (node == null) {
            if (cap == map.size()) {
                remove(head.next.head.pre);
                if (head.next.sz == 0)
                    remove(head.next);
            }
            node = new VNode(key, value);
            add(head);              
            add(node, head.next);
        } else {
            node.v = value;
            forward(node);
        }
    }
    
    void forward(VNode node) {
        HNode p = node.p;
        if (p.sz == 1 && p.next.cnt != p.cnt+1) {
            node.p.cnt++;
            return;
        }
        add(p);
        remove(node);
        add(node, p.next);
        if (p.sz == 0)
            remove(p);
    }

    void add(VNode node, HNode p) {
        p.sz++;
        node.p = p;
        node.next = p.head.next;
        node.pre = p.head;
        p.head.next.pre = node;
        p.head.next = node;
        map.put(node.k, node);
    }
    
    void add(HNode p) {
        if (p.next.cnt == p.cnt+1)
            return;
        HNode h = new HNode();
        h.cnt = p.cnt+1;
        h.next = p.next;
        h.pre = p;
        p.next.pre = h;
        p.next = h;
    }
    
    void remove(VNode node) {
        node.p.sz--;
        node.next.pre = node.pre;
        node.pre.next = node.next;
        node.pre = node.next = null;
        map.remove(node.k);
    }
    
    void remove(HNode p) {
        p.next.pre = p.pre;
        p.pre.next = p.next;
        p.pre = p.next = null;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
