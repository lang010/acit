/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 465
 *  UVa link: http://uva.onlinejudge.org/external/4/465.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Oct 30 23:05:01 2014
 */

import java.util.Scanner;
import java.math.BigInteger;
public class Main {
    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
	Main m = new Main();
	m.run();
    }

    void run() {
	while (in.hasNext()) {
	    String l = in.next();
	    String m = in.next();
	    String r = in.next();
	    System.out.println(l + " " + m + " " + r);
	    r(l, m, r);
	}
    }

    void r(String l, String m, String r) {
	BigInteger lb = new BigInteger(l);
	BigInteger rb = new BigInteger(r);
	
	if (isBig(lb)) {
	    System.out.println("first number too big");
	}
	if (isBig(rb)) {
	    System.out.println("second number too big");
	}
	if (m.equals("+")) {
	    rb = lb.add(rb);
	} else {
	    rb = lb.multiply(rb);
	}

	if (isBig(rb)) {
	    System.out.println("result too big");
	}
    }

    boolean isBig(BigInteger b) {
	int i = b.intValue();
	return !b.equals(BigInteger.valueOf(i));
    }

}
