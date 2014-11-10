/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 100
 *  UVa link: http://uva.onlinejudge.org/external/1/100.html
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
    
    int max = 1000000;
    long[] ls = new long[max];
    {
	for (int i = 0; i < max; i++)
	    ls[i] = -1;
	ls[0] = ls[1] = 0;
    }
    void run() {
	while (in.hasNext()) {
	    long m = -1;
	    int b = in.nextInt();
	    int e = in.nextInt();
	    long t = 0;
	    int l = b;
	    int r = e;
	    if (l>r) {
		l = e;
		r = b;
	    }
	    for (int i = l; i <= r; i++) {
		t = get(i);
		if (t > m) {
		    m = t;
		}
	    }
	    System.out.println(b + " " + e + " " + (m+1));
	    
	}
    }

    long get(long k) {

	if (k < max && ls[(int)k] > -1) {
	    return ls[(int)k];
	}
	long r = 0;
	if (k%2 == 0) {
	    r = get(k/2);
	} else {
	    r = get(3*k + 1);
	}
	r++;
	
	if (k < max) {
	    ls[(int)k] = r;
	}

	return r;
    }

}
