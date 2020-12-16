/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 *
 * https://leetcode.com/problems/word-ladder/description/
 *
 * algorithms
 * Medium (30.86%)
 * Total Accepted:    502K
 * Total Submissions: 1.6M
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * the length of shortest transformation sequence from beginWord to endWord,
 * such that:
 * 
 * 
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list.
 * 
 * 
 * Note:
 * 
 * 
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 
 * Output: 5
 * 
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" ->
 * "dog" -> "cog",
 * return its length 5.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 
 * Output: 0
 * 
 * Explanation: The endWord "cog" is not in wordList, therefore no possible
 * transformation.
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        List<Integer>[] graph = new List[n];
        int end = -1;
        for (int i = 0; i < wordList.size(); i++) {
            if (endWord.equals(wordList.get(i)))
                end = i;
            for (int j = i+1; j < wordList.size(); j++) {
                if (validated(wordList.get(i), wordList.get(j))) {
                    if (graph[i] == null)
                        graph[i] = new ArrayList<>();
                    if (graph[j] == null)
                        graph[j] = new ArrayList<>();
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }
        if (end < 0)
            return 0;
        boolean[] visited = new boolean[n];
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(end, 1));
        visited[end] = true;
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            int cur = pair.getKey();
            int len = pair.getValue();
            if (validated(wordList.get(cur), beginWord))
                return len+1;
            List<Integer> next = graph[cur];
            if (next != null) {
                for (int x : next) {
                    if (!visited[x]) {
                        queue.offer(new Pair<>(x, len+1));
                        visited[x] = true;
                    }
                }
            }
        }
        
        return 0;
    }
    
    /*
    Time Limit Exceeded
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord))
            return 0;
        LinkedList<Pair<String, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(beginWord, 1));
        while (!queue.isEmpty()) {
            Pair<String, Integer> pair = queue.poll();
            String cur = pair.getKey();
            int cnt = pair.getValue();
            if (cur.equals(endWord))
                return cnt;
            
            for (String s : set) {
                if (validated(cur, s)) {
                    queue.offer(new Pair<>(s, cnt+1));
                }
            }
            for (Pair<String, Integer> p : queue) {
                set.remove(p.getKey());
            }
        }
        
        return 0;
    }
    */

    
    boolean validated(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); i++)
            if (s1.charAt(i) != s2.charAt(i))
                diff++;
        return diff == 1;
    }
}
