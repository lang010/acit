/*
 * @lc app=leetcode id=1348 lang=java
 *
 * [1348] Tweet Counts Per Frequency
 *
 * https://leetcode.com/problems/tweet-counts-per-frequency/description/
 *
 * algorithms
 * Medium (32.51%)
 * Total Accepted:    9.1K
 * Total Submissions: 28K
 * Testcase Example:  '["TweetCounts","recordTweet","recordTweet","recordTweet","getTweetCountsPerFrequency","getTweetCountsPerFrequency","recordTweet","getTweetCountsPerFrequency"]\n' +
  '[[],["tweet3",0],["tweet3",60],["tweet3",10],["minute","tweet3",0,59],["minute","tweet3",0,60],["tweet3",120],["hour","tweet3",0,210]]'
 *
 * Implement the class TweetCounts that supports two methods:
 * 
 * 1. recordTweet(string tweetName, int time)
 * 
 * 
 * Stores the tweetName at the recorded time (in seconds).
 * 
 * 
 * 2. getTweetCountsPerFrequency(string freq, string tweetName, int startTime,
 * int endTime)
 * 
 * 
 * Returns the total number of occurrences for the given tweetName per minute,
 * hour, or day (depending on freq) starting from the startTime (in seconds)
 * and ending at the endTime (in seconds).
 * freq is always minute, hour or day, representing the time interval to get
 * the total number of occurrences for the given tweetName.
 * The first time interval always starts from the startTime, so the time
 * intervals are [startTime, startTime + delta*1>,  [startTime + delta*1,
 * startTime + delta*2>, [startTime + delta*2, startTime + delta*3>, ... ,
 * [startTime + delta*i, min(startTime + delta*(i+1), endTime + 1)> for some
 * non-negative number i and delta (which depends on freq).  
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input
 * 
 * ["TweetCounts","recordTweet","recordTweet","recordTweet","getTweetCountsPerFrequency","getTweetCountsPerFrequency","recordTweet","getTweetCountsPerFrequency"]
 * 
 * [[],["tweet3",0],["tweet3",60],["tweet3",10],["minute","tweet3",0,59],["minute","tweet3",0,60],["tweet3",120],["hour","tweet3",0,210]]
 * 
 * Output
 * [null,null,null,null,[2],[2,1],null,[4]]
 * 
 * Explanation
 * TweetCounts tweetCounts = new TweetCounts();
 * tweetCounts.recordTweet("tweet3", 0);
 * tweetCounts.recordTweet("tweet3", 60);
 * tweetCounts.recordTweet("tweet3", 10);                             // All
 * tweets correspond to "tweet3" with recorded times at 0, 10 and 60.
 * tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 59); // return
 * [2]. The frequency is per minute (60 seconds), so there is one interval of
 * time: 1) [0, 60> - > 2 tweets.
 * tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 60); // return
 * [2, 1]. The frequency is per minute (60 seconds), so there are two intervals
 * of time: 1) [0, 60> - > 2 tweets, and 2) [60,61> - > 1 tweet.
 * tweetCounts.recordTweet("tweet3", 120);                            // All
 * tweets correspond to "tweet3" with recorded times at 0, 10, 60 and 120.
 * tweetCounts.getTweetCountsPerFrequency("hour", "tweet3", 0, 210);  // return
 * [4]. The frequency is per hour (3600 seconds), so there is one interval of
 * time: 1) [0, 211> - > 4 tweets.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * There will be at most 10000 operations considering both recordTweet and
 * getTweetCountsPerFrequency.
 * 0 <= time, startTime, endTime <= 10^9
 * 0 <= endTime - startTime <= 10^4
 * 
 * 
 */
class TweetCounts {
    
    Map<String, TreeMap<Integer, Integer>> map = new HashMap<>();
    
    int MIN = 60;
    int HOUR = 3600;
    int DAY = 3600*24;

    public TweetCounts() {
    }
    
    public void recordTweet(String tweetName, int time) {
        if (!map.containsKey(tweetName)) {
            map.put(tweetName, new TreeMap<>());
        }
        TreeMap<Integer, Integer> tmp = map.get(tweetName);
        tmp.put(time, tmp.getOrDefault(time, 0)+1);
    }
    
    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        int d = 60;
        if (freq.equals("hour")) {
            d = 3600;
        } else if (freq.equals("day")) {
            d = 3600*24;
        }
        TreeMap<Integer, Integer> m = map.get(tweetName);
        List<Integer> ans = new ArrayList<>();
        if (m == null)
            return ans;
        int n = 0;
        for (int i = startTime; i <= endTime; i += d) {
            int end = Math.min(i+d, endTime+1);
            int sum = 0;
            for (int x : m.subMap(i, end).values())
                sum += x;
            ans.add(sum);
        }
        
        return ans;
    }
}

/**
 * Your TweetCounts object will be instantiated and called as such:
 * TweetCounts obj = new TweetCounts();
 * obj.recordTweet(tweetName,time);
 * List<Integer> param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
 */
