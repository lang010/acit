/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 729
 *  UVa link: http://uva.onlinejudge.org/external/7/729.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 19 14:19:31 2014
 */

import java.util.Scanner;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

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

    int len = 0;
    int depth = 0;

    int cnt(int x) {
        int r = 0;
        while (x>0) {
            if (x%2 == 1) {
                r++;
            }
            x = x>>1;
        }
        return r;
    }

    void print(int x) {
        for (int i = len-1; i>=0; i--) {
            if ((x & (1<<i)) > 0) {
                pw.printf("1");
            } else {
                pw.printf("0");
            }
        }
        pw.println();
    }

    void run() {
        int T = sc.nextInt();
        for (int k = 0; k < T; k++) {
            len = sc.nextInt();
            depth = sc.nextInt();
            //pw.printf("%d %d%n", len, depth);
            //pw.flush();
            if (k>0) {
                pw.println();
            }
            for (int i = 0; i < 1<<len; i++) {
                if (cnt(i) == depth) {
                    print(i);
                }

            }
        }

    }

}
