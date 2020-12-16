/*
 * @lc app=leetcode id=362 lang=java
 *
 * [362] Design Hit Counter
 *
 * https://leetcode.com/problems/design-hit-counter/description/
 *
 * algorithms
 * Medium (64.72%)
 * Total Accepted:    103.6K
 * Total Submissions: 160.1K
 * Testcase Example:  '["HitCounter","hit","hit","hit","getHits","hit","getHits","getHits"]\n' +
  '[[],[1],[2],[3],[4],[300],[300],[301]]'
 *
 * Design a hit counter which counts the number of hits received in the past 5
 * minutes.
 * 
 * Each function accepts a timestamp parameter (in seconds granularity) and you
 * may assume that calls are being made to the system in chronological order
 * (ie, the timestamp is monotonically increasing). You may assume that the
 * earliest timestamp starts at 1.
 * 
 * It is possible that several hits arrive roughly at the same time.
 * 
 * Example:
 * 
 * 
 * HitCounter counter = new HitCounter();
 * 
 * // hit at timestamp 1.
 * counter.hit(1);
 * 
 * // hit at timestamp 2.
 * counter.hit(2);
 * 
 * // hit at timestamp 3.
 * counter.hit(3);
 * 
 * // get hits at timestamp 4, should return 3.
 * counter.getHits(4);
 * 
 * // hit at timestamp 300.
 * counter.hit(300);
 * 
 * // get hits at timestamp 300, should return 4.
 * counter.getHits(300);
 * 
 * // get hits at timestamp 301, should return 3.
 * counter.getHits(301); 
 * 
 * 
 * Follow up:
 * What if the number of hits per second could be very large? Does your design
 * scale?
 */
class HitCounter {
    
    int N = 300;
    int[] cnt = new int[N];
    int curTm = 1;
    int base = 0;

    /** Initialize your data structure here. */
    public HitCounter() {
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        forward(timestamp);
        cnt[base]++;
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        forward(timestamp);
        int ans = 0;
        for(int x : cnt) {
            ans += x;
        }
        return ans;
    }
    
    void forward(int timestamp) {
        if (curTm == timestamp)
            return;
        if (timestamp - curTm >= N) {
            for (int i = 0; i < N; i++)
                cnt[i] = 0;
            base = 0;
            curTm = timestamp;
            return;
        }
        int n = timestamp - curTm;
        while (n-- > 0) {
            ++base;
            base = base == N ? 0 : base;
            cnt[base] = 0;
        }
        curTm = timestamp;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
