/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 612
 *  UVa link: http://uva.onlinejudge.org/external/6/612.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 27 07:42:41 2014
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

    String[] sl = new String[200];
    int[] ls = new int[200];
    int M, n, m;

    int cnt(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length(); j++) {
                if (s.charAt(i) > s.charAt(j)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    void run() {
        M = sc.nextInt();
        for (int k = 0; k < M; k++) {
            if (k>0) {
                pw.println();
            }
            n = sc.nextInt();
            m = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < m; i++) {
                sl[i] = sc.nextLine().trim();
                ls[i] = cnt(sl[i]);
            }
            for (int i = 0; i < m; i++) {
                for (int j = m-1; j > i; j--) {
                    if (ls[j-1] > ls[j]) {
                        int t = ls[j-1];
                        ls[j-1] = ls[j];
                        ls[j] = t;
                        String s = sl[j-1];
                        sl[j-1] = sl[j];
                        sl[j] = s;
                    }
                }
            }
            for (int i = 0; i < m; i++) {
                pw.println(sl[i]);
            }

        }
    }

}
