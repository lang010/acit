/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10300
 *  UVa link: http://uva.onlinejudge.org/external/103/10300.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 28 22:55:06 2014
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
        int f;
        long a, b, c;
        long s;
        for (int k = 0; k < n; k++) {
            s = 0;
            f = sc.nextInt();
            for (int i = 0; i < f; i++) {
                a = sc.nextLong();
                b = sc.nextLong();
                c = sc.nextLong();
                s += a*c;
            }
            pw.println(s);
        }

    }

}
