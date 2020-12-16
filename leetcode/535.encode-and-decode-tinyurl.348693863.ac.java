/*
 * @lc app=leetcode id=535 lang=java
 *
 * [535] Encode and Decode TinyURL
 *
 * https://leetcode.com/problems/encode-and-decode-tinyurl/description/
 *
 * algorithms
 * Medium (80.56%)
 * Total Accepted:    116.9K
 * Total Submissions: 145.2K
 * Testcase Example:  '"https://leetcode.com/problems/design-tinyurl"'
 *
 * Note: This is a companion problem to the System Design problem: Design
 * TinyURL.
 * 
 * TinyURL is a URL shortening service where you enter a URL such as
 * https://leetcode.com/problems/design-tinyurl and it returns a short URL such
 * as http://tinyurl.com/4e9iAk.
 * 
 * Design the encode and decode methods for the TinyURL service. There is no
 * restriction on how your encode/decode algorithm should work. You just need
 * to ensure that a URL can be encoded to a tiny URL and the tiny URL can be
 * decoded to the original URL.
 * 
 */
public class Codec {
    
    Map<String, String> map = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String url = "http://tinyurl.com/" + longUrl.hashCode();
        map.put(url, longUrl);
        return url;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.getOrDefault(shortUrl, "");
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
