/*
 * @lc app=leetcode id=737 lang=java
 *
 * [737] Sentence Similarity II
 *
 * https://leetcode.com/problems/sentence-similarity-ii/description/
 *
 * algorithms
 * Medium (46.35%)
 * Total Accepted:    45.7K
 * Total Submissions: 98.6K
 * Testcase Example:  '["great","acting","skills"]\n' +
  '["fine","drama","talent"]\n' +
  '[["great","good"],["fine","good"],["drama","acting"],["skills","talent"]]'
 *
 * Given two sentences words1, words2 (each represented as an array of
 * strings), and a list of similar word pairs pairs, determine if two sentences
 * are similar.
 * 
 * For example, words1 = ["great", "acting", "skills"] and words2 = ["fine",
 * "drama", "talent"] are similar, if the similar word pairs are pairs =
 * [["great", "good"], ["fine", "good"], ["acting","drama"],
 * ["skills","talent"]].
 * 
 * Note that the similarity relation is transitive. For example, if "great" and
 * "good" are similar, and "fine" and "good" are similar, then "great" and
 * "fine" are similar.
 * 
 * Similarity is also symmetric. For example, "great" and "fine" being similar
 * is the same as "fine" and "great" being similar.
 * 
 * Also, a word is always similar with itself. For example, the sentences
 * words1 = ["great"], words2 = ["great"], pairs = [] are similar, even though
 * there are no specified similar word pairs.
 * 
 * Finally, sentences can only be similar if they have the same number of
 * words. So a sentence like words1 = ["great"] can never be similar to words2
 * = ["doubleplus","good"].
 * 
 * Note:
 * 
 * 
 * The length of words1 and words2 will not exceed 1000.
 * The length of pairs will not exceed 2000.
 * The length of each pairs[i] will be 2.
 * The length of each words[i] and pairs[i][j] will be in the range [1,
 * 20].
 * 
 * 
 * 
 * 
 */
class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length)
            return false;
        Map<String, String> map = new HashMap<>();
        for (List<String> ls : pairs)
            union(map, ls.get(0), ls.get(1));
        Map<String, Integer> cnt = new HashMap<>();
        for (String s : words1) {
            s = find(map, s);
            cnt.put(s, cnt.getOrDefault(s, 0)+1);
        }
        for (String s : words2) {
            s = find(map, s);
            int v = cnt.getOrDefault(s, 0);
            if (v == 0)
                return false;
            cnt.put(s, v-1);
        }
        return true;
    }
    
    String find(Map<String, String> map, String s) {
        if (!map.containsKey(s))
            return s;
        map.put(s, find(map, map.get(s)));
        return map.get(s);
    }
    
    void union(Map<String, String> map, String s1, String s2) {
        s1 = find(map, s1);
        s2 = find(map, s2);
        if (!s1.equals(s2))
            map.put(s1, s2);
    }
}
