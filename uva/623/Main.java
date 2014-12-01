/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 623
 *  UVa link: http://uva.onlinejudge.org/external/6/623.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 30 14:00:05 2014
 */

import java.util.Scanner;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.math.BigInteger;
import java.util.Map;

public class Main {
    Scanner sc = new Scanner(System.in, "ISO-8859-1");
    PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
    public Main() throws Exception {
    }

    public static void main(String[] args) throws Exception {
	Main m = new Main();
	m.run();
	m.release();
    }
    void release() {
	sc.close();
	pw.close();
    }

    Map<Integer, BigInteger> map = new HashMap<Integer, BigInteger>();

    void run() {
        BigInteger n;
        BigInteger f = BigInteger.valueOf(1);
        map.put(0, f);
        for (int i = 1; i < 1001; i++) {
            n = BigInteger.valueOf(i);
            f = f.multiply(n);
            map.put(i, f);
        }
        while (sc.hasNextInt()) {
            int x = sc.nextInt();
            pw.printf("%d!%n", x);
            pw.println(map.get(x));
        }

    }

}
