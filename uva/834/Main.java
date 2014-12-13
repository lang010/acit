/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 834
 *  UVa link: http://uva.onlinejudge.org/external/8/834.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec 16 22:23:19 2014
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

    int gcd(int x, int y) {
        if (x == 0) {
            return y;
        }
        return gcd(y%x, x);
    }

    void run() {
        int x, y;
        int t;
        int g;
        while (sc.hasNextInt()) {
            x = sc.nextInt();
            y = sc.nextInt();
            if (x%y==0) {
                pw.printf("[%d]%n", x/y);
                continue;
            }
            g = gcd(x, y);
            x /= g;
            y /= g;
            pw.printf("[%d;", x/y);
            x %= y;
            while (x!=1) {
                t = x;
                x = y;
                y = t;
                //pw.printf("(%d %d)", x, y);
                pw.printf("%d,", x/y);
                x %= y;
            }
            pw.printf("%d]%n", y);
        }

    }

}
