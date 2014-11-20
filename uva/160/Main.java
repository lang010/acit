/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 160
 *  UVa link: http://uva.onlinejudge.org/external/1/160.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 22 23:26:01 2014
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

    int[] prime = new int[100];
    int n = 0;
    int[] ls = new int[100];
    int m = 0;

    {
        for (int i = 2; i < 100; i++) {
            int t = 1;
            for (int j = 0; j < n; j++) {
                if (i%prime[j] == 0) {
                    t = 0;
                    break;
                }
            }
            if (t == 1) {
                prime[n++] = i;
            }
        }
    }

    void cnt(int x) {
        int id = 0;
        while (x>1) {
            if (x%prime[id] == 0) {
                x /= prime[id];
                ls[id]++;
                if (m<id) {
                    m = id;
                }
            } else {
                id++;
            }
        }
    }

    void run() {
        while (true) {
            int x = sc.nextInt();
            if (x == 0) {
                break;
            }
            m = 0;
            for (int i = 0; i < 100; i++) {
                ls[i] = 0;
            }

            for (int i = 2; i <= x; i++) {
                cnt(i);
            }

            pw.printf("%3d! =", x);
            for (int i = 0; i < m/15+1; i++) {
                if (i > 0) {
                    pw.printf("      ");
                }
                for (int j = i*15; j <= m && j < (i+1)*15; j++) {
                    pw.printf("%3d", ls[j]);
                }
                pw.println();
            }

        }

    }

}
