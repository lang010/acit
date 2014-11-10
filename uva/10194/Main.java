/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10194
 *  UVa link: http://uva.onlinejudge.org/external/101/10194.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Oct 30 23:05:01 2014
 */

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import java.io.PrintWriter;
import java.io.*;

public class Main {
    Scanner in = new Scanner(System.in, "ISO-8859-1");
    
    public static void main(String[] args) throws Exception {
	Main m = new Main();
	m.run();
    }

    static class Team implements Comparable<Team> {
	String n;
	int a = 0;
	int b = 0;
	int c = 0;
	int d = 0;
	int e = 0;
	int f = 0;
	int g = 0;
	int h = 0;
	int i = 0;
	public int compareTo(Team t) {
	    int x = 0;
	    x = b - t.b;
	    if (x == 0) {
		x = d - t.d;
	    }
	    if (x == 0) {
		x = g - t.g;
	    }
	    if (x == 0) {
		x = h - t.h;
	    }
	    if (x == 0) {
		x = t.c - c;
	    }
	    if (x == 0) {
		x = -n.compareToIgnoreCase(t.n);
	    }
	    return -x;
	}
	public String toString() {
	    return String.format("%d) %s %dp, %dg (%d-%d-%d), %dgd (%d-%d)", a, n, b, c, d, e, f, g, h, i );
	}
    }

    void run() throws Exception {
	PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));

	int cnt = in.nextInt();
	in.nextLine();
	String ti;
	Map<String, Team> map = new HashMap<String, Team>();
	while (cnt-- != 0) {

	    ti = in.nextLine();
	    int N = in.nextInt();
	    in.nextLine();
	    map.clear();
	    for (int i = 0; i < N; i++) {
		Team t = new Team();
		t.n = in.nextLine();
		map.put(t.n, t);
	    }

	    N = in.nextInt();
	    in.nextLine();
	    for (int i = 0; i < N; i++) {
		String[] ls = in.nextLine().split("#");
		Team t1 = map.get(ls[0]);
		Team t2 = map.get(ls[2]);
		String[] sl = ls[1].split("@");
		int s1 = Integer.valueOf(sl[0]);
		int s2 = Integer.valueOf(sl[1]);
		t1.h += s1;
		t1.i += s2;
		t1.g = t1.h - t1.i;
		t1.c += 1;
		t2.h += s2;
		t2.i += s1;
		t2.c += 1;
		t2.g = t2.h - t2.i;
		if (s1 > s2) {
		    t1.b += 3;
		    t1.d += 1;
		    t2.f += 1;
		} else if (s1 < s2) {
		    t2.b += 3;
		    t2.d += 1;
		    t1.f += 1;
		} else {
		    t1.b += 1;
		    t2.b += 1;
		    t1.e += 1;
		    t2.e += 1;
		}
	    }
	    //System.out.println(map);
	    List<Team> list = new ArrayList<Team>(map.values());
	    Collections.sort(list);
	    out.println(ti);
	    for (int i = 0; i < list.size(); i++) {
		Team t = list.get(i);
		t.a = i+1;
		out.println(t);
	    }
	    if (cnt != 0) {
		out.println();
	    }
	}
	out.close();
    }

}
