/*
 * @lc app=leetcode id=800 lang=java
 *
 * [800] Similar RGB Color
 *
 * https://leetcode.com/problems/similar-rgb-color/description/
 *
 * algorithms
 * Easy (61.97%)
 * Total Accepted:    10.8K
 * Total Submissions: 17.5K
 * Testcase Example:  '"#09f166"'
 *
 * In the following, every capital letter represents some hexadecimal digit
 * from 0 to f.
 * 
 * The red-green-blue color "#AABBCC" can be written as "#ABC" in shorthand.
 * For example, "#15c" is shorthand for the color "#1155cc".
 * 
 * Now, say the similarity between two colors "#ABCDEF" and "#UVWXYZ" is -(AB -
 * UV)^2 - (CD - WX)^2 - (EF - YZ)^2.
 * 
 * Given the color "#ABCDEF", return a 7 character color that is most similar
 * to #ABCDEF, and has a shorthand (that is, it can be represented as some
 * "#XYZ"
 * 
 * 
 * Example 1:
 * Input: color = "#09f166"
 * Output: "#11ee66"
 * Explanation:  
 * The similarity is -(0x09 - 0x11)^2 -(0xf1 - 0xee)^2 - (0x66 - 0x66)^2 = -64
 * -9 -0 = -73.
 * This is the highest among any shorthand color.
 * 
 * 
 * Note:
 * 
 * 
 * color is a string of length 7.
 * color is a valid RGB color: for i > 0, color[i] is a hexadecimal digit from
 * 0 to f
 * Any answer which has the same (highest) similarity as the best answer will
 * be accepted.
 * All inputs and outputs should use lowercase letters, and the output is 7
 * characters.
 * 
 * 
 */
class Solution {
    public String similarRGB(String color) {
        StringBuilder sb = new StringBuilder();
        sb.append('#');
        for (int i = 0; i < 3; i++) {
            char c1 = color.charAt(i*2+1);
            char c2 = color.charAt(i*2+2);
            if (Math.abs(val(c1)-val(c2)) > 8) {
                if (c1 > c2)
                    if (c1 == 'a')
                        c1 = '9';
                    else
                        c1--;
                else
                    if (1 == '9')
                        c1 = 'a';
                    else
                        c1++;
            }
            sb.append(c1);
            sb.append(c1);
        }
        return sb.toString();
    }
    
    int val(char c) {
        if (c >= 'a')
            return c - 'a' + 10;
        return c - '0';
    }
}
