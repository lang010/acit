/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 396
 *  UVa link: http://uva.onlinejudge.org/external/3/396.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 30 16:45:06 2014
 */

import java.util.Scanner;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;

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

    BigInteger[] ls = new BigInteger[101];
    {
        ls[0] = BigInteger.ONE;
        for (int i = 1; i < 101; i++) {
            ls[i] = BigInteger.valueOf(i).multiply(ls[i-1]);
        }

    }

    void run() {
        while (true) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            if (n == 0 && m == 0) {
                break;
            }
            pw.printf("%d things taken %d at a time is %s exactly.%n", n, m, ls[n].divide(ls[m]).divide(ls[n-m]).toString());
        }

    }

}
