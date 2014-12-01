/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10019
 *  UVa link: http://uva.onlinejudge.org/external/100/10019.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 29 12:36:04 2014
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

    int cnt(int x) {
        int s = 0;
        while (x>0) {
            s += x%2;
            x /=2;
        }
        return s;
    }

    void run() {
        int b1, b2;
        int n;
        int T = sc.nextInt();
        for (int k = 0; k < T; k++) {
            n = sc.nextInt();
            b1 = cnt(n);
            b2 = 0;
            while (n>0) {
                b2 += cnt(n%10);
                n /= 10;
            }
            pw.printf("%d %d%n", b1, b2);
        }

    }

}
