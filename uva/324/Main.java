/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 324
 *  UVa link: http://uva.onlinejudge.org/external/3/324.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec  6 11:26:55 2014
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

    BigInteger[] ls = new BigInteger[400];
    {
        ls[0] = BigInteger.ONE;
        for (int i = 1; i < 400; i++) {
            ls[i] = ls[i-1].multiply(BigInteger.valueOf(i));
        }
        //pw.println(ls[399]);
    }

    void run() {
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            char[] lc = ls[n].toString().toCharArray();
            int[] li = new int[10];
            for (int i = 0; i < lc.length; i++) {
                li[lc[i]-'0']++;
            }
            pw.printf("%d! --%n", n);
            for (int i = 0; i < 5; i++) {
                pw.printf("   (%d)%5d", i, li[i]);
            }
            pw.println();
            for (int i = 5; i < 10; i++) {
                pw.printf("   (%d)%5d", i, li[i]);
            }
            pw.println();
        }
    }

}
