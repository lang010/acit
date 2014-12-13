/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 12015
 *  UVa link: http://uva.onlinejudge.org/external/120/12015.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec 17 22:42:36 2014
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

    int max = 0;
    String[] ls = new String[20];
    int n = 0;

    void run() {
        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            max = -10000000;
            n = 0;
            for (int j = 0; j < 10; j++) {
                String s = sc.next();
                int v = sc.nextInt();
                if (v > max) {
                    ls[0] = s;
                    max = v;
                    n = 1;
                } else if (v == max) {
                    ls[n++] = s;
                }
            }
            pw.printf("Case #%d:%n", i+1);
            for (int j = 0; j < n; j++) {
                pw.println(ls[j]);
            }

        }

    }

}
