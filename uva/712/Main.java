/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 712
 *  UVa link: http://uva.onlinejudge.org/external/7/712.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 12 00:51:25 2014
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

    int[] id = new int[10];

    void run() {
        int k = 1;
        while (true) {
            int n = in.nextInt();
            if (n == 0) {
                break;
            }

            for (int i = 0; i < n; i++) {
                String ss = in.next();
                int x = ss.charAt(1) - '1';
                id[x] = n-i-1;
            }
            String s = in.next();
            int m = in.nextInt();
            String r = "";
            for (int i = 0; i < m ; i++) {
                String ss = in.next();
                int x = 0;
                for (int j = 0; j < n; j++) {
                    if (ss.charAt(j) == '1') {
                        x += 1<<id[j];
                    }
                }

                r = r + s.charAt(x);
            }
            out.printf("S-Tree #%d:%n%s%n%n", k++, r);
        }

    }

}
