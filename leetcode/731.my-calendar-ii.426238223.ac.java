/*
 * @lc app=leetcode id=731 lang=java
 *
 * [731] My Calendar II
 *
 * https://leetcode.com/problems/my-calendar-ii/description/
 *
 * algorithms
 * Medium (49.97%)
 * Total Accepted:    47.8K
 * Total Submissions: 95.7K
 * Testcase Example:  '["MyCalendarTwo","book","book","book","book","book","book"]\n' +
  '[[],[10,20],[50,60],[10,40],[5,15],[5,10],[25,55]]'
 *
 * Implement a MyCalendarTwo class to store your events. A new event can be
 * added if adding the event will not cause a triple booking.
 * 
 * Your class will have one method, book(int start, int end). Formally, this
 * represents a booking on the half open interval [start, end), the range of
 * real numbers x such that start <= x < end.
 * 
 * A triple booking happens when three events have some non-empty intersection
 * (ie., there is some time that is common to all 3 events.)
 * 
 * For each call to the method MyCalendar.book, return true if the event can be
 * added to the calendar successfully without causing a triple booking.
 * Otherwise, return false and do not add the event to the calendar.
 * Your class will be called like this: MyCalendar cal = new MyCalendar();
 * MyCalendar.book(start, end)
 * 
 * Example 1:
 * 
 * 
 * MyCalendar();
 * MyCalendar.book(10, 20); // returns true
 * MyCalendar.book(50, 60); // returns true
 * MyCalendar.book(10, 40); // returns true
 * MyCalendar.book(5, 15); // returns false
 * MyCalendar.book(5, 10); // returns true
 * MyCalendar.book(25, 55); // returns true
 * Explanation: 
 * The first two events can be booked.  The third event can be double booked.
 * The fourth event (5, 15) can't be booked, because it would result in a
 * triple booking.
 * The fifth event (5, 10) can be booked, as it does not use time 10 which is
 * already double booked.
 * The sixth event (25, 55) can be booked, as the time in [25, 40) will be
 * double booked with the third event;
 * the time [40, 50) will be single booked, and the time [50, 55) will be
 * double booked with the second event.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * The number of calls to MyCalendar.book per test case will be at most
 * 1000.
 * In calls to MyCalendar.book(start, end), start and end are integers in the
 * range [0, 10^9].
 * 
 * 
 * 
 */
class MyCalendarTwo {
    
    TreeMap<Integer, Integer> map1 = new TreeMap<>();
    TreeMap<Integer, Integer> map2 = new TreeMap<>();

    public MyCalendarTwo() {
    }
    
    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> entry = map2.lowerEntry(end);
        if (entry != null && entry.getValue() > start)
            return false;
        while (true) {
            // Add Map1
            entry = map1.lowerEntry(end);
            if (entry == null || entry.getValue() < start)
                break;
            map1.remove(entry.getKey());
            int st = Math.max(start, entry.getKey());
            int en = Math.min(end, entry.getValue());
            start = Math.min(start, entry.getKey());
            end = Math.max(end, entry.getValue());
            if (st < en) {
                // Add Map2
                entry = map2.lowerEntry(end);
                if (entry != null && entry.getValue() == st)
                    map2.put(entry.getKey(), en);
                else
                    map2.put(st, en);
            }
        }
        map1.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
