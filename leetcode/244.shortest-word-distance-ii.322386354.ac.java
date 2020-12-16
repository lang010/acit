/*
 * @lc app=leetcode id=244 lang=java
 *
 * [244] Shortest Word Distance II
 *
 * https://leetcode.com/problems/shortest-word-distance-ii/description/
 *
 * algorithms
 * Medium (53.22%)
 * Total Accepted:    76.5K
 * Total Submissions: 143.8K
 * Testcase Example:  '["WordDistance","shortest","shortest"]\n' +
  '[[["practice","makes","perfect","coding","makes"]],["coding","practice"],["makes","coding"]]'
 *
 * Design a class which receives a list of words in the constructor, and
 * implements a method that takes two words word1 and word2 and return the
 * shortest distance between these two words in the list. Your method will be
 * called repeatedly many times with different parameters. 
 * 
 * Example:
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * 
 * 
 * Input: word1 = “coding”, word2 = “practice”
 * Output: 3
 * 
 * 
 * 
 * Input: word1 = "makes", word2 = "coding"
 * Output: 1
 * 
 * Note:
 * You may assume that word1 does not equal to word2, and word1 and word2 are
 * both in the list.
 * 
 */
class WordDistance {
    
    Map<String, Integer> cache = new HashMap<>();
    Map<String, List<Integer>> map = new HashMap<>();

    public WordDistance(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) {
                map.put(words[i], new ArrayList<>());
            }
            map.get(words[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        String key = word1+"-$-"+word2;
        if (cache.containsKey(key))
            return cache.get(key);
        int ans = Integer.MAX_VALUE;
        List<Integer> ls1 = map.get(word1);
        List<Integer> ls2 = map.get(word2);
        int i, j;
        i = j = 0;
        while (i < ls1.size() && j < ls2.size()) {
            int val = Math.abs(ls1.get(i) - ls2.get(j));
            ans = Math.min(val, ans);
            if (ls1.get(i) > ls2.get(j)) {
                j++;
            } else {
                i++;
            }
        }
        cache.put(key, ans);
        return ans;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
