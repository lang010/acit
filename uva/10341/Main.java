/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10341
 *  UVa link: http://uva.onlinejudge.org/external/103/10341.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 26 16:50:55 2014
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
    int p = 0, q = 0, r = 0, s = 0, t = 0, u = 0;

    double f(double x) {
        return p*Math.exp(-x) + q*Math.sin(x) + r*Math.cos(x) + s*Math.tan(x) + t*x*x +u;
    }

    double cnt() {
        double b = 0;
        double e = 1;
        while (e-b > 1e-7) {
            double x = (b+e)/2;
            if (f(x)*f(b) > 0) {
                b = x;
            } else {
                e = x;
            }
        }
        return (b+e)/2;
    }

    void run() {
        double x = 0;

        while (sc.hasNextInt()) {
            p = sc.nextInt();
            q = sc.nextInt();
            r = sc.nextInt();
            s = sc.nextInt();
            t = sc.nextInt();
            u = sc.nextInt();
            if (f(0)*f(1)>0) {
                pw.println("No solution");
            } else {
                x = cnt();
                pw.printf("%.4f%n", x);
            }

        }

    }

}
