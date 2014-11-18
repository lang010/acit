/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10370
 *  UVa link: http://uva.onlinejudge.org/external/103/10370.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 17 00:18:07 2014
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

    int[] ls = new int[1500];

    void run() {
        double avg;
        int c;
        int n;
        int cnt;
        c = sc.nextInt();
        for (int i = 0; i < c; i++) {
            n = sc.nextInt();
            avg = 0;
            cnt = 0;
            for (int j = 0; j < n; j++) {
                ls[j] = sc.nextInt();
                avg += ls[j];
            }
            avg /= n;
            for (int j = 0; j < n; j++) {
                if (ls[j] > avg) {
                    cnt++;
                }
            }
            pw.printf("%.3f%%%n", 100.0*cnt/n);
        }

    }

}
