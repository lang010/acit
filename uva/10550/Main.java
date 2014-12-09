/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10550
 *  UVa link: http://uva.onlinejudge.org/external/105/10550.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec 10 00:05:56 2014
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

    int degree(int x, int y, boolean counter) {
        int ans = (y-x)*9;
        if (ans < 0) {
            ans += 360;
        }

        if (ans>0 && !counter) {
            ans = 360 - ans;
        }
        return ans;
    }

    void run() {
        int a, b, c, d;
        while (true) {
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            d = sc.nextInt();
            if (a == 0 && b == 0 && c == 0 && d == 0) {
                break;
            }
            pw.println(360*3 + degree(a, b, false) + degree(b, c, true) + degree(c, d, false));
        }

    }

}
