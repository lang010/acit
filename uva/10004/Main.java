/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10004
 *  UVa link: http://uva.onlinejudge.org/external/100/10004.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 14 07:34:15 2014
 */

import java.util.Scanner;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Main {
    Scanner in = new Scanner(System.in, "ISO-8859-1");
    PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
    public Main() throws Exception {
    }

    public static void main(String[] args) throws Exception {
	Main m = new Main();
	m.run();
	m.release();
    }
    void release() {
	in.close();
	out.close();
    }

    int N,L;
    int[][] map = new int[200][200];
    int[] color = new int[200];

    int dfs(int id, int c) {
        if (color[id] == c) {
            return 1;
        }
        if (color[id]>0 && color[id] != c) {
            return -1;
        }
        color[id] = c;
        for (int i = 0; i < N; i++) {
            if (map[id][i] > 0 && dfs(i, c%2+1)<0) {
                return -1;
            }
        }
        return 1;
    }

    void run() {
        while (true) {
            N = in.nextInt();
            if (N == 0) {
                break;
            }
            L = in.nextInt();
            for (int i = 0; i < N; i++) {
                color[i] = 0;
                for (int j = 0; j < N; j++) {
                    map[i][j] = 0;
                }
            }
            int a, b;
            for (int i = 0; i < L ; i++) {
                a = in.nextInt();
                b = in.nextInt();
                map[a][b] = 1;
            }
            if (dfs(0, 1)>0) {
                out.println("BICOLORABLE.");
            } else {
                out.println("NOT BICOLORABLE.");
            }

        }

    }

}
