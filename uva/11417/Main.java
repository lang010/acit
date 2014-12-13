/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 11417
 *  UVa link: http://uva.onlinejudge.org/external/114/11417.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec 16 18:40:12 2014
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

    int[] ls = new int [501];

    int gcd(int x, int y) {
        if (x == 0) {
            return y;
        }
        return gcd(y%x, x);
    }

    void run() {
        int r = 0;
        for (int i = 2; i < 501; i++) {
            r = 0;
            for (int j = 1; j < i; j++) {
                r += gcd(j, i);
            }
            ls[i] = ls[i-1] + r;
        }
        while (true) {
            r = sc.nextInt();
            if (r == 0) {
                break;
            }
            pw.println(ls[r]);
        }

    }

}
