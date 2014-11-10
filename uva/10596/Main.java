/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10596
 *  UVa link: http://uva.onlinejudge.org/external/105/10596.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 16 13:12:49 2014
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

    int[][] map = new int[300][300];
    int N = 0, R = 0;
    int[] degree = new int[300];
    int[] visited = new int[300];

    void initMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = 0;
            }
            degree[i] = 0;
            visited[i] = 0;
        }
    }

    int dfs(int id) {
        if (visited[id] == 1 || degree[id] <= 0) {
            return 0;
        }
        int r = degree[id];
        visited[id] = 1;

        for (int i = 0; i < N; i++) {
            if (map[id][i] > 0) {
                r += dfs(i);
            }
        }

        return r;
    }

    void run() {
        int r = 0;
        while (sc.hasNext()) {
            N = sc.nextInt();
            R = sc.nextInt();
            initMap();
            for (int i = 0; i < R; i++) {
                int a, b;
                a = sc.nextInt();
                b = sc.nextInt();
                map[a][b] = 1;
                map[b][a] = 1;
                degree[a]++;
                degree[b]++;
            }
            r = 0;
            for (int i = 0; i < N; i++) {
                if (degree[i]%2 != 0) {
                    r = 1;
                    break;
                }
            }
            if (r == 1 || R == 0) {
                pw.println("Not Possible");
                continue;
            }
            for (int i = 0; i < N; i++) {
                r = dfs(i);
                //pw.printf("T: %d %d%n", r, R);
                //pw.flush();
                if (r != 0) {
                    break;
                }
            }

            if (r == 2*R) {
                pw.println("Possible");
            } else {
                pw.println("Not Possible");
            }
        }

    }

}
