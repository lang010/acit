/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 11764
 *  UVa link: http://uva.onlinejudge.org/external/117/11764.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec  5 00:02:07 2014
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
            int n = sc.nextInt();
            int h = sc.nextInt();
            int c0 = 0;
            int c1 = 0;
            for (int i = 1; i < n; i++) {
                int x = sc.nextInt();
                if (h>x) {
                    c1++;
                }
                if (h<x) {
                    c0++;
                }
                h = x;
            }
            pw.printf("Case %d: %d %d%n", k+1, c0, c1);
        }

    }

}
