/*
 * @lc app=leetcode id=346 lang=java
 *
 * [346] Moving Average from Data Stream
 *
 * https://leetcode.com/problems/moving-average-from-data-stream/description/
 *
 * algorithms
 * Easy (72.59%)
 * Total Accepted:    158.4K
 * Total Submissions: 218.2K
 * Testcase Example:  '["MovingAverage","next","next","next","next"]\n[[3],[1],[10],[3],[5]]'
 *
 * Given a stream of integers and a window size, calculate the moving average
 * of all integers in the sliding window.
 * 
 * Example:
 * 
 * 
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 * 
 * 
 * 
 * 
 */
class MovingAverage {
    
    int sz;
    double sum = 0;
    Deque<Integer> queue = new ArrayDeque<>();

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        sz = size;
    }
    
    public double next(int val) {
        queue.offer(val);
        sum += val;
        if (queue.size() > sz) {
            sum -= queue.poll();
        }
        return sum/queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
