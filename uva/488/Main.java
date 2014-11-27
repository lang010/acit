/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 488
 *  UVa link: http://uva.onlinejudge.org/external/4/488.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 28 19:29:16 2014
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
        int T = sc.nextInt();
        for (int k = 0; k < T; k++) {
            int h = sc.nextInt();
            int f = sc.nextInt();
            if (k>0) {
                pw.println();
            }
            StringBuilder sb = new StringBuilder();

            for (int t = 0; t < f; t++) {
                if (t>0) {
                    sb.append("\n");
                }
                for (int i = 0; i < h; i++) {
                    for (int j = 0; j <= i; j++) {
                        sb.append(i+1);
                    }
                    sb.append("\n");
                }
                for (int i = 0; i < h-1; i++) {
                    for (int j = 0; j < h-i-1; j++) {
                        sb.append(h-i-1);
                    }
                    sb.append("\n");
                }
            }
            pw.printf(sb.toString());
        }

    }

}
