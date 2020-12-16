/*
 * @lc app=leetcode id=551 lang=java
 *
 * [551] Student Attendance Record I
 *
 * https://leetcode.com/problems/student-attendance-record-i/description/
 *
 * algorithms
 * Easy (46.05%)
 * Total Accepted:    98.9K
 * Total Submissions: 214.9K
 * Testcase Example:  '"PPALLP"'
 *
 * You are given a string representing an attendance record for a student. The
 * record only contains the following three characters:
 * 
 * 
 * 
 * 'A' : Absent. 
 * 'L' : Late.
 * ⁠'P' : Present. 
 * 
 * 
 * 
 * 
 * A student could be rewarded if his attendance record doesn't contain more
 * than one 'A' (absent) or more than two continuous 'L' (late).    
 * 
 * You need to return whether the student could be rewarded according to his
 * attendance record.
 * 
 * Example 1:
 * 
 * Input: "PPALLP"
 * Output: True
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: "PPALLL"
 * Output: False
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public boolean checkRecord(String s) {
        int a = 0;
        int l = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                a++;
                if (a > 1)
                    return false;
            }
            if (c == 'L') {
                l++;
                if (l > 2)
                    return false;
            } else
                l = 0;
        }
        return true;
    }
}
