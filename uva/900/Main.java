/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 900
 *  UVa link: http://uva.onlinejudge.org/external/9/900.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec  6 14:39:40 2014
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

    long[] ls = new long[51];
    {
        ls[0] = 1;
        ls[1] = 2;
        for (int i = 2; i < 51; i++) {
            ls[i] = ls[i-1] + ls[i-2];
        }
    }

    void run() {
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            pw.println(ls[n-1]);
        }

    }

}
