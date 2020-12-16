/*
 * @lc app=leetcode id=1078 lang=java
 *
 * [1078] Occurrences After Bigram
 *
 * https://leetcode.com/problems/occurrences-after-bigram/description/
 *
 * algorithms
 * Easy (64.85%)
 * Total Accepted:    34.3K
 * Total Submissions: 52.9K
 * Testcase Example:  '"alice is a good girl she is a good student"\n"a"\n"good"'
 *
 * Given words first and second, consider occurrences in some text of the form
 * "first second third", where second comes immediately after first, and third
 * comes immediately after second.
 * 
 * For each such occurrence, add "third" to the answer, and return the
 * answer.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: text = "alice is a good girl she is a good student", first = "a",
 * second = "good"
 * Output: ["girl","student"]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: text = "we will we will rock you", first = "we", second = "will"
 * Output: ["we","rock"]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= text.length <= 1000
 * text consists of space separated words, where each word consists of
 * lowercase English letters.
 * 1 <= first.length, second.length <= 10
 * first and second consist of lowercase English letters.
 * 
 * 
 * 
 */
class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        String[] arr = text.split(" ");
        List<String> ls = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++)
            if (first.equals(arr[i]) && second.equals(arr[i+1]))
                ls.add(arr[i+2]);
        return ls.toArray(new String[0]);
    }
}
