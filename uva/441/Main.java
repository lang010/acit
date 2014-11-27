/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 441
 *  UVa link: http://uva.onlinejudge.org/external/4/441.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 25 21:44:19 2014
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

    int[] ls = new int[50];
    int n = 0;

    void run() {
        int cnt = 0;
        while (true) {
            n = sc.nextInt();
            if (n == 0) {
                break;
            }
            if (cnt > 0) {
                pw.println();
            }
            cnt++;
            for (int i = 0; i < n; i++) {
                ls[i] = sc.nextInt();
            }
            for (int a = 0; a < n-5; a++) {
                for (int b = a+1; b < n-4; b++) {
                    for (int c = b+1; c < n-3; c++) {
                        for (int d = c+1; d < n-2; d++) {
                            for (int e = d+1; e < n-1; e++) {
                                for (int f = e+1; f < n; f++) {
                                    pw.printf("%d %d %d %d %d %d%n", ls[a], ls[b], ls[c], ls[d], ls[e], ls[f]);
                                }
                            }
                        }
                    }
                }
            }
        }

    }

}
