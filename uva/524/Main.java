/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 524
 *  UVa link: http://uva.onlinejudge.org/external/5/524.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 22 20:27:41 2014
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

    int[] visit = new int[20];
    int[] ls = new int[20];
    int[] prim = new int[40];
    int n = 0;

    StringBuilder sb = null;

    {
        prim[0] = prim[1] = 0;
        for (int i = 2; i < 40; i++) {
            int f = 1;
            for (int j = 2; j < i; j++) {
                if (i%j == 0) {
                    f = 0;
                    break;
                }
            }
            prim[i] = f;
        }
    }

    void check() {
        int id = ls[0] + ls[n-1];
        if (prim[id] == 0) {
            return ;
        }

        for (int i = 0; i < n-1; i++) {
            sb.append(ls[i]);
            sb.append(" ");
        }
        sb.append(ls[n-1]);
        sb.append("\n");
    }

    void dfs(int x) {
        if (x == n) {
            check();
            return ;
        }
        for (int i = 2; i <= n; i++) {
            if (visit[i] == 0 && prim[ls[x-1]+i] == 1) {
                visit[i] = 1;
                ls[x] = i;
                dfs(x+1);
                visit[i] = 0;
            }
        }
    }

    void run() {
        int cnt = 0;
        while (sc.hasNext()) {
            sb = new StringBuilder();
            n = sc.nextInt();
            if (cnt>0) {
                sb.append("\n");
            }
            cnt++;
            sb.append("Case ");
            sb.append(cnt);
            sb.append(":\n");

            ls[0] = 1;
            dfs(1);
            System.out.printf(sb.toString());
        }
    }

}
