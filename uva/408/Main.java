/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 408
 *  UVa link: http://uva.onlinejudge.org/external/4/408.html
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
        int n, m, t;
        int n1, m1;
        String s;
        while (in.hasNext()) {
            m1 = m = in.nextInt();
            n1 = n = in.nextInt();
            while (m%n != 0) {
                t = n;
                n = m%n;
                m = t;
            }
            if (n > 1) {
                s = "Bad Choice";
            } else {
                s = "Good Choice";
            }
            out.printf("%10d%10d    %s%n%n", m1, n1, s);
        }
    }

}
