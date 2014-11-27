/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 264
 *  UVa link: http://uva.onlinejudge.org/external/2/264.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 28 14:36:30 2014
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
        int x, y, n;
        int t;
        while (sc.hasNextInt()) {
            n = sc.nextInt();
            x = 0;
            y = 0;
            while (n>y) {
                x++;
                y += x;
            }
            t = x%2;
            y -= x;
            y = n - y;
            x -= y;
            x++;
            if (t == 1) {
                pw.printf("TERM %d IS %d/%d%n", n, x, y);
            } else {
                pw.printf("TERM %d IS %d/%d%n", n, y, x);
            }


        }

    }

}
