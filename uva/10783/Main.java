/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10783
 *  UVa link: http://uva.onlinejudge.org/external/107/10783.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 16 23:53:50 2014
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
        int a,b,sum,t;
        t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            sum = 0;
            for (int j = a; j <= b; j++) {
                if (j%2 == 1) {
                    sum += j;
                }
            }
            pw.printf("Case %d: %d%n", i+1, sum);
        }

    }

}
