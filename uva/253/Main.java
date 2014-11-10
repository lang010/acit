/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 253
 *  UVa link: http://uva.onlinejudge.org/external/2/253.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Oct 30 23:05:01 2014
 */

import java.util.Scanner;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

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

    void next(int b) {
	for (int i = 0; i < 3; i++) {
	    cp(map[b+i], map[b+i+1]);
	    mL(b+i+1);
	}
    }
    int[][] map = new int[24][7];
    {
	for (int i = 0; i < 7; i++)
	    for (int j = 0; j < 24; j++)
		map[j][i] = i;
	int[] t = new int[7];

	next(0);

	mU(4);
	next(4);

	mL(8);
	mU(8);
	next(8);

	mL(12);
	mL(12);
	mL(12);
	mU(12);
	next(12);

	// 5 top
	mU(16);
	mU(16);
	mU(16);
	next(16);

	// 6 top
	mU(20);
	mU(20);
	next(20);
	
    };

    void cp(int[] l1, int[] l2) {
	for (int i = 0; i < 7; i++)
	    l2[i] = l1[i];
    }
    void mU(int id) {
	int[] l1 = map[id];
	int[] l2 = new int[7];
	l2[1] = l1[2];
	l2[2] = l1[6];
	l2[6] = l1[5];
	l2[5] = l1[1];
	l2[3] = l1[3];
	l2[4] = l1[4];
	cp(l2, l1);
    }

    void mL(int id) {
	int[] l1 = map[id];
	int[] l2 = new int[7];
	l2[2] = l1[3];
	l2[3] = l1[5];
	l2[5] = l1[4];
	l2[4] = l1[2];
	l2[1] = l1[1];
	l2[6] = l1[6];
	cp(l2, l1);
    }


    String check(String s) {
	String s1 = s.substring(0, 6);
	String s2 = s.substring(6, 12);
	char[] ls = new char[6];

	for (int i = 0; i < 24; i++) {
	    for (int j = 1; j < 7; j++)
		ls[j-1] = s1.charAt(map[i][j]-1);
	    s = String.valueOf(ls);
	    //System.out.printf("%d: %s - %s%n", i, s2, s);
	    
	    if (s2.equals(String.valueOf(ls)))
		return "TRUE";
	}

	return "FALSE";
    }

    void run() {
	while (in.hasNext()) {
	    String s = in.next().toLowerCase();
	    out.println(check(s));
	    out.flush();
	}
    }

}
