/*
 * @lc app=leetcode id=715 lang=java
 *
 * [715] Range Module
 *
 * https://leetcode.com/problems/range-module/description/
 *
 * algorithms
 * Hard (39.72%)
 * Total Accepted:    22.3K
 * Total Submissions: 56K
 * Testcase Example:  '["RangeModule","addRange","removeRange","queryRange","queryRange","queryRange"]\n' +
  '[[],[10,20],[14,16],[10,14],[13,15],[16,17]]'
 *
 * A Range Module is a module that tracks ranges of numbers. Your task is to
 * design and implement the following interfaces in an efficient manner.
 * 
 * addRange(int left, int right) Adds the half-open interval [left, right),
 * tracking every real number in that interval.  Adding an interval that
 * partially overlaps with currently tracked numbers should add any numbers in
 * the interval [left, right) that are not already tracked.
 * 
 * queryRange(int left, int right) Returns true if and only if every real
 * number in the interval [left, right)
 * ⁠is currently being tracked.
 * 
 * removeRange(int left, int right) Stops tracking every real number currently
 * being tracked in the interval [left, right).
 * 
 * Example 1:
 * 
 * addRange(10, 20): null
 * removeRange(14, 16): null
 * queryRange(10, 14): true (Every number in [10, 14) is being tracked)
 * queryRange(13, 15): false (Numbers like 14, 14.03, 14.17 in [13, 15) are not
 * being tracked)
 * queryRange(16, 17): true (The number 16 in [16, 17) is still being tracked,
 * despite the remove operation)
 * 
 * 
 * 
 * Note:
 * A half open interval [left, right) denotes all real numbers left .
 * 
 * 0 < left < right < 10^9 in all calls to addRange, queryRange, removeRange.
 * The total number of calls to addRange in a single test case is at most 1000.
 * The total number of calls to queryRange in a single test case is at most
 * 5000.
 * The total number of calls to removeRange in a single test case is at most
 * 1000.
 * 
 */
class RangeModule {
    
    TreeMap<Integer, Integer> first = new TreeMap<>();

    public RangeModule() {
    }
    
    public void addRange(int left, int right) {
        while (true) {
            Map.Entry<Integer, Integer> entry = first.floorEntry(right);
            if (entry == null || entry.getValue() < left)
                break;
            left = Math.min(left, entry.getKey());
            right = Math.max(right, entry.getValue());
            first.remove(entry.getKey());
        }
        first.put(left, right);
    }
    
    public boolean queryRange(int left, int right) {
        Map.Entry<Integer, Integer> entry = first.floorEntry(left);
        return entry != null && entry.getValue() >= right;
    }
    
    public void removeRange(int left, int right) {
        addRange(left, right);
        Map.Entry<Integer, Integer> entry = first.floorEntry(left);
        first.remove(entry.getKey());
        if (entry.getKey() < left)
            first.put(entry.getKey(), left);
        if (entry.getValue() > right)
            first.put(right, entry.getValue());
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
