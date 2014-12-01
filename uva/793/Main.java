/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 793
 *  UVa link: http://uva.onlinejudge.org/external/7/793.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 29 16:01:33 2014
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

    int[] p = null;
    int n = 0;

    int parent(int id) {
        if (p[id] == id) {
            return id;
        }
        p[id] = parent(p[id]);
        return p[id];
    }

    void run() {
        int T = sc.nextInt();
        while (T-- > 0) {
            n = sc.nextInt();
            sc.nextLine();
            p = new int[n+1];
            for (int i = 0; i <= n; i++) {
                p[i] = i;
            }

            int nW = 0, nR = 0;
            while (sc.hasNext()) {
                String s = sc.nextLine();
                if ("".equals(s)) {
                    break;
                }
                String[] sl = s.split(" ");
                int x = Integer.valueOf(sl[1]);
                int y = Integer.valueOf(sl[2]);
                int p1 = parent(x);
                int p2 = parent(y);
                //pw.printf("%d %d%n", p1, p2);
                if ("c".equals(sl[0])) {
                    p[p2] = p1;
                } else {
                    if (p1 == p2) {
                        nR++;
                    } else {
                        nW++;
                    }
                }
            }
            pw.printf("%d,%d%n", nR, nW);
            if (T>0) {
                pw.println();
            }
        }
    }

}
