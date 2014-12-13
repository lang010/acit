/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10220
 *  UVa link: http://uva.onlinejudge.org/external/102/10220.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec 13 14:26:15 2014
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

    int[] ls = new int[1001];
    {
        BigInteger[] f = new BigInteger[1001];
        f[0] = BigInteger.ONE;
        for (int i = 1; i < 1001; i++) {
            f[i] = f[i-1].multiply(BigInteger.valueOf(i));
        }
        for (int i = 0; i < 1001; i++) {
            int a = 0;
            char[] nl = f[i].toString().toCharArray();
            for (int j = 0; j < nl.length; j++) {
                a += nl[j] - '0';
            }
            ls[i] = a;
        }
    };

    void run() {
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            pw.println(ls[n]);
        }
    }
}
