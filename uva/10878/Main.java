/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10878
 *  UVa link: http://uva.onlinejudge.org/external/108/10878.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Oct 30 23:05:01 2014
 */
import java.util.Scanner;
public class Main {
    Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
	Main m = new Main();
	m.run();
    }

    public void run() {
	String s = "";
	while (in.hasNext()) {
	    String l = in.nextLine();
	    if (l.charAt(0) == '|') {
		l = l.replace(".", "");
		char c = '\0';
		for (int i = 1; i < 9; i++) {
		    c <<= 1;
		    if (l.charAt(i) == 'o')
			c |= 1;
		}
		s = s+c;
	    }
	}
	System.out.print(s);
	
    }
}
