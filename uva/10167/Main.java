/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10167
 *  UVa link: http://uva.onlinejudge.org/external/101/10167.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 17 23:24:32 2014
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

    int[] xl = new int[150];
    int[] yl = new int[150];
    int n = 0;

    boolean check(int a, int b) {
        int l,r;
        int t;
        l = r = 0;
        for (int i = 0; i < n*2; i++) {
            t = a*xl[i] + b*yl[i];
            if (t < 0) {
                l++;
            }
            if (t > 0) {
                r++;
            }
        }
        if (l == r && l == n) {
            return true;
        }
        return false;
    }

    void run() {
        int a,b;
        while (true) {
            n = sc.nextInt();
            if (n == 0) {
                break;
            }
            for (int i = 0; i < 2*n; i++) {
                xl[i] = sc.nextInt();
                yl[i] = sc.nextInt();
            }
            a = 0;
            b = 1;
            if (!check(0,1)) {
                a = 1;
                for (a = 1; a <= 500; a++) {
                    for (b = -500; b <= 500; b++) {
                        if (check(a,b)) {
                            n = 0;
                            break;
                        }
                    }
                    if (n == 0) {
                        break;
                    }
                }
            }
            pw.printf("%d %d%n", a, b);
        }

    }

}
