/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 11462
 *  UVa link: http://uva.onlinejudge.org/external/114/11462.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 27 14:55:59 2014
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

    int max = 101;
    int[] ls = new int[110];
    int n;
    void run() {
        while (true) {
            n = sc.nextInt();
            if (n <= 0) {
                break;
            }
            for (int i = 0; i < max; i++) {
                ls[i] = 0;
            }

            for (int i = 0; i < n; i++) {
                ls[sc.nextInt()]++;
            }
            int f = 0;
            for (int i = 0; i < max; i++) {
                for (int j = 0; j < ls[i]; j++) {
                    if (f == 1) {
                        pw.printf(" ");
                    } else {
                        f = 1;
                    }
                    pw.printf("%d", i);
                }
            }
            pw.println();
        }

    }

}
