/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10327
 *  UVa link: http://uva.onlinejudge.org/external/103/10327.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 21 19:53:47 2014
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

    int[] ls = new int[1010];
    int n = 0;
    void run() {
        while (sc.hasNext()) {
            n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                ls[i] = sc.nextInt();
            }
            int minId = 0;
            int cnt = 0;
            int t = 0;
            for (int i = 0; i < n; i++) {
                minId = i;
                for (int j = i+1; j < n; j++ ) {
                    if (ls[minId] > ls[j]) {
                        minId = j;
                    }
                }
                while (minId != i) {
                    t = ls[minId];
                    ls[minId] = ls[minId-1];
                    ls[minId-1] = t;
                    minId--;
                    cnt++;
                }
            }
            pw.printf("Minimum exchange operations : %d%n", cnt);
        }

    }

}
