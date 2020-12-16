/*
 * @lc app=leetcode id=295 lang=java
 *
 * [295] Find Median from Data Stream
 *
 * https://leetcode.com/problems/find-median-from-data-stream/description/
 *
 * algorithms
 * Hard (46.04%)
 * Total Accepted:    250.8K
 * Total Submissions: 544.8K
 * Testcase Example:  '["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]\n' +
  '[[],[1],[2],[],[3],[]]'
 *
 * Median is the middle value in an ordered integer list. If the size of the
 * list is even, there is no middle value. So the median is the mean of the two
 * middle value.
 * For example,
 * 
 * [2,3,4], the median is 3
 * 
 * [2,3], the median is (2 + 3) / 2 = 2.5
 * 
 * Design a data structure that supports the following two operations:
 * 
 * 
 * void addNum(int num) - Add a integer number from the data stream to the data
 * structure.
 * double findMedian() - Return the median of all elements so far.
 * 
 * 
 * 
 * 
 * Example:
 * 
 * 
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3) 
 * findMedian() -> 2
 * 
 * 
 * 
 * 
 * Follow up:
 * 
 * 
 * If all integer numbers from the stream are between 0 and 100, how would you
 * optimize it?
 * If 99% of all integer numbers from the stream are between 0 and 100, how
 * would you optimize it?
 * 
 * 
 */
class MedianFinder {
    PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> b-a);
    PriorityQueue<Integer> min = new PriorityQueue<>();

    /** initialize your data structure here. */
    public MedianFinder() {
    }
    
    public void addNum(int num) {
        if (max.size() == 0 || max.peek() >= num)
            max.offer(num);
        else
            min.offer(num);
        if (max.size() < min.size()) {
            max.offer(min.poll());
        } else if (max.size() > min.size()+1)
            min.offer(max.poll());
    }
    
    public double findMedian() {
        PriorityQueue<Integer> p1 = max, p2 = min;
        if (max.size() > min.size())
            return max.peek();
        else
            return (max.peek() + min.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
