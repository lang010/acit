/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10302
 *  UVa link: http://uva.onlinejudge.org/external/103/10302.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec  7 21:23:24 2014
 */
import java.util.Scanner;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;

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

    long[] l = new long[50001];
    {
        l[1] = 1;
        for (int i = 2; i < 50001; i++) {
            long lt = i;
            l[i] = l[i-1] + lt*lt*lt;
        }
    }

    void run() {
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            pw.println(l[n]);
        }
    }

}
