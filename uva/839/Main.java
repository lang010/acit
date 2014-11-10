/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 839
 *  UVa link: http://uva.onlinejudge.org/external/8/839.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 12 15:51:13 2014
 */

import java.util.Scanner;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

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

    int tree() {
        int w1 = in.nextInt();
        int d1 = in.nextInt();
        int w2 = in.nextInt();
        int d2 = in.nextInt();
        if (w1 == 0) {
            w1 = tree();
        }
        if (w2 == 0) {
            w2 = tree();
        }
        if (w1 > 0 && w2 > 0) {
            if (w1*d1 == w2*d2) {
                return w1 + w2;
            } else {
                return -w1 - w2;
            }
        }
        return -1;
    }

    void run() {
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            if (i>0) {
                out.println();
            }
            if (tree() > 0) {
                out.println("YES");
            } else {
                out.println("NO");
            }
        }
    }

}
