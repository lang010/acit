/*
 * @lc app=leetcode id=642 lang=java
 *
 * [642] Design Search Autocomplete System
 *
 * https://leetcode.com/problems/design-search-autocomplete-system/description/
 *
 * algorithms
 * Hard (45.69%)
 * Total Accepted:    71.6K
 * Total Submissions: 156.8K
 * Testcase Example:  '["AutocompleteSystem","input","input","input","input"]\n' +
  '[[["i love you","island","iroman","i love leetcode"],[5,3,2,2]],["i"],[" "],["a"],["#"]]'
 *
 * Design a search autocomplete system for a search engine. Users may input a
 * sentence (at least one word and end with a special character '#'). For each
 * character they type except '#', you need to return the top 3 historical hot
 * sentences that have prefix the same as the part of sentence already typed.
 * Here are the specific rules:
 * 
 * 
 * The hot degree for a sentence is defined as the number of times a user typed
 * the exactly same sentence before.
 * The returned top 3 hot sentences should be sorted by hot degree (The first
 * is the hottest one). If several sentences have the same degree of hot, you
 * need to use ASCII-code order (smaller one appears first).
 * If less than 3 hot sentences exist, then just return as many as you can.
 * When the input is a special character, it means the sentence ends, and in
 * this case, you need to return an empty list.
 * 
 * 
 * Your job is to implement the following functions:
 * 
 * The constructor function:
 * 
 * AutocompleteSystem(String[] sentences, int[] times): This is the
 * constructor. The input is historical data. Sentences is a string array
 * consists of previously typed sentences. Times is the corresponding times a
 * sentence has been typed. Your system should record these historical data.
 * 
 * Now, the user wants to input a new sentence. The following function will
 * provide the next character the user types:
 * 
 * List<String> input(char c): The input c is the next character typed by the
 * user. The character will only be lower-case letters ('a' to 'z'), blank
 * space (' ') or a special character ('#'). Also, the previously typed
 * sentence should be recorded in your system. The output will be the top 3
 * historical hot sentences that have prefix the same as the part of sentence
 * already typed.
 * 
 * 
 * Example:
 * Operation: AutocompleteSystem(["i love you", "island","ironman", "i love
 * leetcode"], [5,3,2,2])
 * The system have already tracked down the following sentences and their
 * corresponding times:
 * "i love you" : 5 times
 * "island" : 3 times
 * "ironman" : 2 times
 * "i love leetcode" : 2 times
 * Now, the user begins another search:
 * 
 * Operation: input('i')
 * Output: ["i love you", "island","i love leetcode"]
 * Explanation:
 * There are four sentences that have prefix "i". Among them, "ironman" and "i
 * love leetcode" have same hot degree. Since ' ' has ASCII code 32 and 'r' has
 * ASCII code 114, "i love leetcode" should be in front of "ironman". Also we
 * only need to output top 3 hot sentences, so "ironman" will be ignored.
 * 
 * Operation: input(' ')
 * Output: ["i love you","i love leetcode"]
 * Explanation:
 * There are only two sentences that have prefix "i ".
 * 
 * Operation: input('a')
 * Output: []
 * Explanation:
 * There are no sentences that have prefix "i a".
 * 
 * Operation: input('#')
 * Output: []
 * Explanation:
 * The user finished the input, the sentence "i a" should be saved as a
 * historical sentence in system. And the following input will be counted as a
 * new search.
 * 
 * 
 * Note:
 * 
 * 
 * The input sentence will always start with a letter and end with '#', and
 * only one blank space will exist between two words.
 * The number of complete sentences that to be searched won't exceed 100. The
 * length of each sentence including those in the historical data won't exceed
 * 100.
 * Please use double-quote instead of single-quote when you write test cases
 * even for a character input.
 * Please remember to RESET your class variables declared in class
 * AutocompleteSystem, as static/class variables are persisted across multiple
 * test cases. Please see here for more details.
 * 
 * 
 * 
 * 
 */
class AutocompleteSystem {
    
    static class Node {
        int tot = 0;
        List<String> ans = new ArrayList<>();
        int[] cnt = new int[3];
        Node[] next = new Node[27];
    }
    
    Node head = new Node();
    Node cur = head;
    String str = "";

    public AutocompleteSystem(String[] sentences, int[] times) {
        for (int i = 0; i < sentences.length; i++) {
            add(sentences[i], times[i]);
        }
        cur = head;
    }
    
    void add(String s, int tm) {
        Node node = head;
        for (char c : s.toCharArray()) {
            int id = charToID(c);
            if (node.next[id] == null)
                node.next[id] = new Node();
            node = node.next[id];
            List<String> ans = node.ans;
            int[] cnt = node.cnt;
            for (id = 0; id < ans.size(); id++)
                if (ans.get(id).equals(s))
                    break;
            if (id < ans.size()) {
                cnt[id] = tm;
                while (id > 0 && (cnt[id-1] < cnt[id] || cnt[id-1] == cnt[id] && s.compareTo(ans.get(id-1)) < 0)) {
                    String tmp = ans.get(id);
                    ans.set(id, ans.get(id-1));
                    ans.set(id-1, tmp);
                    int val = cnt[id-1];
                    cnt[id-1] = cnt[id];
                    cnt[id] = val;
                    id--;
                }
            } else {
                id = ans.size()-1;
                while (id >= 0 && (cnt[id] < tm || cnt[id] == tm && s.compareTo(ans.get(id)) < 0)) {
                    if (id < 2) {
                        if (id == ans.size() - 1) {
                            ans.add(ans.get(id));
                            cnt[id+1] = cnt[id];
                        } else {
                            ans.set(id+1, ans.get(id));
                            cnt[id+1] = cnt[id];
                        }
                    }
                    id--;
                }
                if (++id < 3) {
                    if (id < ans.size())
                        ans.set(id, s);
                    else
                        ans.add(s);
                    cnt[id] = tm;
                }
            }
        }
        node.tot = tm;
    }
    
    public List<String> input(char c) {
        if (c == '#') {
            add(str, cur == null ? 1 : cur.tot + 1);
            str = "";
            cur = head;
            return new ArrayList<>();
        }
        str += c;
        int id = charToID(c);
        cur = cur != null ? cur.next[id] : null;
        if (cur == null)
            return new ArrayList<>();
        return cur.ans;
    }
    
    int charToID(char c) {
        if (c == ' ')
            return 26;
        return c - 'a';
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
