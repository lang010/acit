/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10323
 *  UVa link: http://uva.onlinejudge.org/external/103/10323.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec 11 23:20:17 2014
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

    long max = 6227020800l;

    void run() {
        long s = 0;
        int n = 0;
        while (sc.hasNextInt()) {
            n = sc.nextInt();
            s = 1;
            for (int i = 1; i <= n && s <= max; i++) {
                s *= i;
            }
            if (n<0) {
                if (-n%2 == 1) {
                    pw.println("Overflow!");
                } else {
                    pw.println("Underflow!");
                }
                continue;
            }

            if (s < 10000) {
                pw.println("Underflow!");
            } else if (s > max) {
                pw.println("Overflow!");
            } else {
                pw.println(s);
            }

        }

    }

}
