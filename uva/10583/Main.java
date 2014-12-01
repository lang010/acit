/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10583
 *  UVa link: http://uva.onlinejudge.org/external/105/10583.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 29 23:10:52 2014
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

    int[] p = new int[50001];

    int parent(int id) {
        if (p[id] == id) {
            return id;
        }
        p[id] = parent(p[id]);
        return p[id];
    }

    void run() {
        int cnt = 1;
        while (true) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            if (n == 0 && k == 0) {
                break;
            }

            for (int i = 0; i <= n; i++) {
                p[i] = i;
            }
            for (int i = 0; i < k; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int p1 = parent(x);
                int p2 = parent(y);
                if (p1 != p2) {
                    p[p1] = p2;
                }
            }
            k = 0;
            for (int i = 1; i < n+1; i++) {
                if (p[i] == i) {
                    k++;
                }
            }
            pw.printf("Case %d: %d%n", cnt++, k);
        }

    }

}
