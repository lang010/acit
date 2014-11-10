/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 748
 *  UVa link: http://uva.onlinejudge.org/external/7/748.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Oct 30 23:05:01 2014
 */

import java.util.Scanner;
import java.math.BigDecimal;
import java.math.BigInteger;
public class Main {
    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
	Main m = new Main();
	m.run();
    }

    void run() {
	while (in.hasNext()) {
	    double d = in.nextDouble();
	    int n = in.nextInt();
	    int f = 1;
	    int cnt = 0;
	    while (true) {
		if (d*f - ((int)(d*f)) < 0.00001) {
		    break;
		}
		f *= 10;
		cnt++;
	    }
	    BigInteger b = BigInteger.valueOf((int)(d*f));
	    BigInteger r = b;
	    for (int i = 0; i < n-1; i++) {
		//System.out.println(r);
		r = r.multiply(b);
	    }
	    String s = r.toString();
	    if (cnt > 0) {
		if (s.length() > cnt * n) {
		    s = s.substring(0, s.length() - cnt*n) + "." + s.substring(s.length() - cnt*n);
		} else {
		    for (int i = cnt*n - s.length(); i > 0; i--) {
			s = "0" + s;
		    }
		    s = "." + s;
		}
	    }
	    System.out.println(s);
	}
    }

}
