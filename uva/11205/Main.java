/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 11205
 *  UVa link: http://uva.onlinejudge.org/external/112/11205.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 17 23:58:44 2014
 */

import java.util.Scanner;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

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

    int n, p;
    int[] ls = new int[200];

    void run() {
        int T = sc.nextInt();
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < T; i++) {
            p = sc.nextInt();
            n = sc.nextInt();
            for (int j = 0; j < n; j++) {
                ls[j] = 0;
                for (int k = 0; k < p; k++) {
                    if (sc.nextInt() == 1) {
                        ls[j] += 1 << k;
                    }
                }
            }
            int cnt = 0;
            int min = 1000000;
            for (int j = 0; j < (1<<p); j++) {
                set.clear();
                for (int k = 0; k < n; k++) {
                    set.add(ls[k] & j);
                }
                if (set.size() == n) {
                    cnt = 0;
                    int x = j;
                    //pw.println(x);
                    //pw.flush();
                    while (x>0) {
                        if (x%2 == 1) {
                            cnt++;
                        }
                        x = x>>1;
                    }
                    if (cnt < min) {
                        min = cnt;
                    }

                }
            }

            pw.println(min);
        }

    }

}
