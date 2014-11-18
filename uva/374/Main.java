/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 374
 *  UVa link: http://uva.onlinejudge.org/external/3/374.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 18 08:36:28 2014
 */

import java.util.Scanner;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

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

    long[] ls = new long[40];

    void run() {
        while (sc.hasNextLong()) {
            long b, p, m;
            b = sc.nextLong();
            p = sc.nextLong();
            m = sc.nextLong();
            ls[0] = b % m;
            for (int i = 1; i < 40; i++) {
                ls[i] = (ls[i-1]*ls[i-1]) % m;
            }
            long r = 1;
            int cnt = 0;
            while (p>0) {
                if (p%2 == 1) {
                    r = (r*ls[cnt])%m;
                }
                p = p>>1;
                cnt++;
            }
            pw.println(r);
        }
    }

}
