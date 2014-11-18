/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10018
 *  UVa link: http://uva.onlinejudge.org/external/100/10018.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 18 19:33:14 2014
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

    long reverse(long p) {
        long y = 0;
        while (p>0) {
            y = y*10 + p%10;
            p /= 10;
        }
        return y;
    }

    void run() {
        int cnt = 0;
        int n = sc.nextInt();
        long x, y;
        for (int k = 0; k < n; k++) {
            cnt = 0;
            x = sc.nextLong();
            y = reverse(x);
            while (x != y) {
                x += y;
                y = reverse(x);
                cnt++;
            }
            pw.printf("%d %d%n", cnt, x);
        }

    }

}
