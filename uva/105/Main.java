/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 105
 *  UVa link: http://uva.onlinejudge.org/external/1/105.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec  2 23:37:43 2014
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

    int[] hl = new int[10001];

    void run() {
        while (sc.hasNextInt()) {
            int l = sc.nextInt();
            int h = sc.nextInt();
            int r = sc.nextInt();
            for (int i = l; i < r; i++) {
                if (hl[i] < h) {
                    hl[i] = h;
                }
            }
        }
        int t = 0;
        if (hl[0] > 0) {
            pw.printf("%d %d", 0, hl[0]);
            t++;
        }
        for (int i = 1; i < 10001; i++) {
            if (hl[i] != hl[i-1]) {
                if (t>0) {
                    pw.printf(" %d %d", i, hl[i]);
                } else {
                    pw.printf("%d %d", i, hl[i]);
                }
                t++;
            }
        }
        pw.println();
    }

}
