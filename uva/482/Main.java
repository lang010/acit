/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 482
 *  UVa link: http://uva.onlinejudge.org/external/4/482.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 26 23:45:53 2014
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
        int T = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < T; i++) {
            sc.nextLine();
            String s1 = sc.nextLine().trim();
            String s2 = sc.nextLine().trim();
            String[] ls1 = s1.split("\\s+");
            String[] ls2 = s2.split("\\s+");
            int[] ls = new int[ls1.length];
            for (int j = 0; j < ls1.length; j++) {
                ls[j] = Integer.valueOf(ls1[j]);
            }
            if (i>0) {
                pw.println();
            }
            for (int j = 0; j < ls.length; j++) {
                //pw.printf("TT %d%n", ls[j]);
                for (int k = 0; k < ls.length; k++) {
                    if (ls[k] == j+1) {
                        pw.println(ls2[k]);
                    }
                }
            }
        }

    }

}
