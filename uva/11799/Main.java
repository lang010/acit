/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 11799
 *  UVa link: http://uva.onlinejudge.org/external/117/11799.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec  4 09:32:47 2014
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
        int max = 0;
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            max = 0;
            for (int j = 0; j < n; j++) {
                int v = sc.nextInt();
                if (v > max) {
                    max = v;
                }
            }
            pw.printf("Case %d: %d%n", i+1, max);
        }

    }

}
