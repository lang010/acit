/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10812
 *  UVa link: http://uva.onlinejudge.org/external/108/10812.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 26 00:17:59 2014
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

    void run() {
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int d = sc.nextInt();
            int x1 = (s+d)/2;
            int x2 = (s-d)/2;
            if (x1*2 == s+d && x1>=0 && x2>=0 && x1>=x2) {
                pw.printf("%d %d%n", x1, x2);
            } else {
                pw.println("impossible");
            }
        }

    }

}
