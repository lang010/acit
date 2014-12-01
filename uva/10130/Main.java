/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10130
 *  UVa link: http://uva.onlinejudge.org/external/101/10130.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec  2 06:19:34 2014
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

    int n = 0;
    int[] pl = new int[1010];
    int[] wl = new int[1010];
    int[] ml = new int[31];

    void run() {
        int T = sc.nextInt();
        for (int k = 0; k < T; k++) {
            n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                pl[i] = sc.nextInt();
                wl[i] = sc.nextInt();
            }
            for (int i = 0; i < 31; i++) {
                ml[i] = 0;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 30; j >= 0; j--) {
                    if (j-wl[i] >= 0 && ml[j-wl[i]] + pl[i] > ml[j]) {
                        ml[j] = ml[j-wl[i]] + pl[i];
                    }
                }
            }
            //for (int i = 0; i < 31; i++) {
            //    pw.printf("(%d, %d) ", i, ml[i]);
            //}
            //pw.println();

            int g = sc.nextInt();
            int sum = 0;
            for (int i = 0; i < g; i++) {
                sum += ml[sc.nextInt()];
            }
            pw.println(sum);
        }

    }

}
