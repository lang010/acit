/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10387
 *  UVa link: http://uva.onlinejudge.org/external/103/10387.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Oct 30 23:05:01 2014
 */

import java.util.Scanner;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.File;

public class Main {
    Scanner in = new Scanner(System.in, "ISO-8859-1");
    PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
    public Main() throws Exception {
    }

    public static void main(String[] args) throws Exception {
	Main m = new Main();
	m.run();
	m.release();
    }
    void release() {
	in.close();
	out.close();
    }

    void run() {
        while (in.hasNext()) {
            int a = in.nextInt();
            int b = in.nextInt();
            int s = in.nextInt();
            int m = in.nextInt();
            int n = in.nextInt();
            if (a == 0 || b == 0)
                break;
            a = a*m;
            b = b*n;
            double r = Math.hypot(a,b)/s;
            double d = Math.toDegrees(Math.atan(1.0*b/a));
            out.printf("%.2f %.2f%n", d, r);
        }
    }

}
