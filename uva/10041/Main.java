/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10041
 *  UVa link: http://uva.onlinejudge.org/external/100/10041.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 28 22:42:27 2014
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
        int[] ls = new int[600];
        int T = sc.nextInt();
        int n;
        int s;
        int min = 500000000;
        for (int k = 0; k < T; k++ ) {
            n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                ls[i] = sc.nextInt();
            }
            min = 50000000;
            for (int i = 0; i < n; i++) {
                s = 0;
                for (int j = 0; j < n; j++) {
                    s += Math.abs(ls[i] - ls[j]);
                }
                if (s < min) {
                    min = s;
                }
            }
            pw.println(min);
        }

    }

}
