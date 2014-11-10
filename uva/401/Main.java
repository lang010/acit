/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 401
 *  UVa link: http://uva.onlinejudge.org/external/4/401.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Oct 30 23:05:01 2014
 */

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
public class Main {
    public static void main(String[] args) {
	Main m = new Main();
	m.run();
    }

    public void run() {
	while (in.hasNext()) {
	    String s = in.next().replace("0", "O");
	    boolean isP = true;
	    boolean isM = true;
	    int i = 0;
	    int j = s.length() -1;
	    while (i<=j) {
		char l = s.charAt(i);
		char r = s.charAt(j);
		if (l != r)
		    isP = false;
		String ls = String.valueOf(l);
		String rs = String.valueOf(r);
		if (! ls.equals(map.get(rs)) )
		    isM = false;
		i++;
		j--;
	    }
	    System.out.print(s);
	    if ( isP && isM )
		System.out.println(" -- is a mirrored palindrome.");
	    else if (isP)
		System.out.println(" -- is a regular palindrome.");
	    else if (isM)
		System.out.println(" -- is a mirrored string.");
	    else
		System.out.println(" -- is not a palindrome.");
	    System.out.println();
	}
    }

    Scanner in = new Scanner(System.in);
    Map<String, String> map = new HashMap<String, String>();

    {
	map.put("A", "A");
	map.put("E", "3");
	map.put("3", "E");
	map.put("H", "H");
	map.put("I", "I");
	map.put("J", "L");
	map.put("L", "J");
	map.put("M", "M");
	map.put("O", "O");
	map.put("S", "2");
	map.put("2", "S");
	map.put("T", "T");
	map.put("U", "U");
	map.put("V", "V");
	map.put("W", "W");
	map.put("X", "X");
	map.put("Y", "Y");
	map.put("Z", "5");
	map.put("5", "Z");
	map.put("1", "1");
	map.put("8", "8");

    }
}
