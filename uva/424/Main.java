/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 424
 *  UVa link: http://uva.onlinejudge.org/external/4/424.html
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
	BigInteger sum = new BigInteger("0");
	while (true) {
	    String s = in.nextLine();
	    if (s.equals("0"))
		break;
	    sum = sum.add(new BigInteger(s));
	}
	System.out.println(sum);
    }

}
