/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10038
 *  UVa link: http://uva.onlinejudge.org/external/100/10038.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 16 23:40:27 2014
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
        int n = 0;
        int a,b;
        boolean ok;
        while (sc.hasNext()) {
            n = sc.nextInt();
            int[] ls = new int[n];
            a = b = sc.nextInt();
            ok = true;
            for (int i = 1; i < n; i++) {
                b = sc.nextInt();
                a = Math.abs(b-a);
                if (a < n) {
                    ls[a]++;
                }
                a = b;
            }
            for (int i = 1; i < n; i++) {
                if (ls[i] != 1) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                pw.println("Jolly");
            } else {
                pw.println("Not jolly");
            }
        }

    }

}
