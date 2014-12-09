/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 406
 *  UVa link: http://uva.onlinejudge.org/external/4/406.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec  6 00:00:45 2014
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

    int[] ls = new int[200];
    int n = 0;
    {
        ls[n++] = 1;
        for (int i = 2; i < 1000; i++) {
            int t = 0;
            for (int j = 1; j < n; j++) {
                if (i%ls[j] == 0) {
                    t = 1;
                    break;
                }
            }
            if (t == 0) {
                ls[n++] = i;
            }
        }
        //pw.println(n);
    }
    void run() {
        while (sc.hasNextInt()) {
            int x = sc.nextInt();
            int c = sc.nextInt();
            int t = 0;
            for (t = 0; t < n; t++) {
                if (ls[t]>x) {
                    break;
                }
            }
            int l = t/2 - c;
            int r = t/2 + c;
            if (t%2 == 1) {
                l++;
            }
            if (l <= 0) {
                l = 0;
                r = t;
            }

            pw.printf("%d %d:", x, c);
            for (int i = l; i < r; i++) {
                pw.printf(" %d", ls[i]);
            }
            pw.println("\n");
        }

    }

}
