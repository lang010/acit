/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10494
 *  UVa link: http://uva.onlinejudge.org/external/104/10494.html
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
	    BigInteger l = new BigInteger(in.next());
	    String f = in.next();
	    BigInteger r = new BigInteger(in.next());
	    if (f.equals("%")) {
		l = l.mod(r);
	    } else {
		l = l.divide(r);
	    }
	    System.out.println(l);
	}
    }

}
