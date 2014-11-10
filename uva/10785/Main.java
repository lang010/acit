/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10785
 *  UVa link: http://uva.onlinejudge.org/external/107/10785.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Oct 30 23:05:01 2014
 */

import java.util.Scanner;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;

public class Main {
    Scanner in = new Scanner(System.in, "ISO-8859-1");
    PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
    public Main() throws Exception {
    }
    public static void main(String[] args) throws Exception {
	Main m = new Main();
	m.run();
	m.release();
    }
    void release() {
	in.close();
	out.close();
    }

    void run() {
	int N = in.nextInt();
	for (int i = 0; i < N ; i++) {
	    int n = in.nextInt();
	    out.println("Case " + (i+1) + ": " + get(n));
	}
    }

    char[] V = {'A', 'U', 'E', 'O', 'I'};
    char[] C = {'J', 'S', 'B', 'K', 'T', 'C', 'L', 'D', 'M', 'V', 'N', 'W', 'F', 'X', 'G', 'P', 'Y', 'H', 'Q', 'Z', 'R'};

    String get(int n) {
	if (n == 1)
	    return "A";
	char[] s = new char[n];
	char[] s2 = new char[n/2];
	char[] s1 = new char[(n+1)/2];

	int cnt = 0;
	int id = 0;
	for (int i = 0; i < s1.length; i++) {
	    s1[i] = V[id];
	    cnt++;
	    if (cnt >= 21) {
		cnt = 0;
		id++;
	    }
	}
	cnt = 0;
	id = 0;
	for (int i = 0; i < s2.length; i++) {
	    s2[i] = C[id];
	    cnt++;
	    if (cnt >= 5) {
		id++;
		cnt = 0;
	    }
	}
	Arrays.sort(s1);
	Arrays.sort(s2);
	for(int i = 0; i < n ; i++) {
	    if (i%2 == 0)
		s[i] = s1[i/2];
	    else s[i] = s2[i/2];
	}
	return new String(s);
    }

}
