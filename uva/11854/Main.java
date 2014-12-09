/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 11854
 *  UVa link: http://uva.onlinejudge.org/external/118/11854.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec 10 00:19:47 2014
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
        int a, b, c;
        while (true) {
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            if (a == 0 && b == 0 && c == 0) {
                break;
            }

            a = a*a;
            b = b*b;
            c = c*c;
            if (a == b+c || b == a+c || c == a+b) {
                pw.println("right");
            } else {
                pw.println("wrong");
            }
        }

    }

}
