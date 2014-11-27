/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 661
 *  UVa link: http://uva.onlinejudge.org/external/6/661.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 26 23:26:10 2014
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

    int[] ls = new int[100];
    int[] on = new int[100];
    int n, m, c;
    void run() {
        int t = 1;
        while (true) {
            n = sc.nextInt();
            m = sc.nextInt();
            c = sc.nextInt();
            if (n == 0) {
                break;
            }

            int max = 0;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                ls[i] = sc.nextInt();
                on[i] = 0;
            }
            for (int i = 0; i < m; i++) {
                int x = sc.nextInt();
                x--;
                if (max <= c) {
                    if (on[x] == 0) {
                        cnt += ls[x];
                        on[x] = 1;
                        if (cnt > max) {
                            max = cnt;
                        }
                    } else {
                        cnt -= ls[x];
                        on[x] = 0;
                    }
                }
            }
            pw.printf("Sequence %d%n", t++);
            if (max <= c) {
                pw.println("Fuse was not blown.");
                pw.printf("Maximal power consumption was %d amperes.%n%n", max);
            } else {
                pw.println("Fuse was blown.\n");
            }
        }

    }

}
