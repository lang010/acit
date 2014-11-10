/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 755
 *  UVa link: http://uva.onlinejudge.org/external/7/755.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Oct 30 23:05:01 2014
 */

import java.util.Scanner;
import java.util.*;
import java.io.*;
public class Main {
    //Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws IOException {
	Main m = new Main();
	m.run();
    }

    int form(String s) {
	int r = 0;
	
	s = s.toUpperCase();
	for (int i = 0; i < s.length(); i++) {
	    char c = s.charAt(i);
	    if (c == '-')
		continue;
	    if (c >= '0' && c <= '9')
		r = r*10 + c - '0';
	    else if (c >= 'A' && c <= 'C')
		r = r*10+2;
	    else if (c >= 'D' && c <= 'F')
		r = r*10+3;
	    else if (c >= 'G' && c <= 'I')
		r = r*10+4;
	    else if (c >= 'J' && c <= 'L')
		r = r*10+5;
	    else if (c >= 'M' && c <= 'O')
		r = r*10+6;
	    else if (c >= 'P' && c <= 'S')
		r = r*10+7;
	    else if (c >= 'T' && c <= 'V')
		r = r*10+8;
	    else if (c >= 'W' && c <= 'Y')
		r = r*10+9;
	}
	//System.out.println("Next: " + r);
	//cn[r] += 1;

	return (r);
    }

    String str(int r) {
	return String.format("%03d-%04d", r/10000, r%10000);
    }

    int max = 100010;
    int[] strls = new int[max];

    long t1, t2, t3, t4;
    long beg, end;

    void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int cnt = Integer.valueOf(br.readLine());
	StringBuffer sb = new StringBuffer("");
	while (cnt-- > 0) {
	    beg = System.currentTimeMillis();
	    br.readLine();
	    int N = Integer.valueOf(br.readLine());

	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    List<Integer> ls = new ArrayList<Integer>();


	    for (int j = 0; j < N ; j++) {
		String s = br.readLine();
		//strls[j] = form(s);
		int k = form(s);
		if (map.containsKey(k)) {
		    map.put(k, map.get(k) + 1);
		} else {
		    map.put(k, 1);
		    ls.add(k);
		}
	    }

	    end = System.currentTimeMillis();
	    t1 = end - beg;
	    beg = end;

	    int nn = 0;
	    for (int j = 0; j < ls.size(); j++) {
		Integer k = ls.get(j);
		Integer v = map.get(k);
		if (v>1)
		    strls[nn++] = k;
	    }
	    end = System.currentTimeMillis();
	    t2 = end - beg;
	    beg = end;

	    Arrays.sort(strls, 0, nn);

	    end = System.currentTimeMillis();
	    t3 = end - beg;
	    beg = end;

	    int flag = 0;
	    for (int j = 0; j < nn; j++) {
		sb.append(str(strls[j]));
		sb.append(" ");
		sb.append(map.get(strls[j]));
		sb.append("\n");
		flag = 1;
	    }

	    end = System.currentTimeMillis();
	    t4 = end - beg;
	    beg = end;


	    if (flag < 1)
		sb.append("No duplicates.\n");
	    if (cnt > 0)
		sb.append("\n");
	    //System.out.printf("Time: %d, %d, %d, %d%n", t1, t2, t3, t4);
	}
	System.out.print(sb);
    }

}
