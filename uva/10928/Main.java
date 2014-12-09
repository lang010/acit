/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10928
 *  UVa link: http://uva.onlinejudge.org/external/109/10928.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec  6 23:53:40 2014
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

    int[] ls = new int[1100];
    int n = 0;

    void run() {
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            n = sc.nextInt();
            sc.nextLine();
            int min = 1000000;
            for (int j = 0; j < n; j++) {
                String s = sc.nextLine();
                ls[j] = s.split(" ").length;
                if (min > ls[j]) {
                    min = ls[j];
                }
            }
            int t = 0;
            for (int j = 0; j < n; j++) {
                if (ls[j] == min) {
                    if (t>0) {
                        pw.printf(" ");
                    }
                    pw.printf("%d", j+1);
                    t = 1;
                }
            }
            pw.println();
        }


    }

}
