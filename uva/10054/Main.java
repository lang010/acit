/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10054
 *  UVa link: http://uva.onlinejudge.org/external/100/10054.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 16 16:06:34 2014
 */

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
    PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
    public Main() throws Exception {
    }

    public static void main(String[] args) throws Exception {
	Main m = new Main();
	m.run();
	m.release();
    }
    void release() throws Exception {
	br.close();
	pw.close();
    }

    int n;
    int[][] map = new int[100][100];
    int[] visited = new int[100];
    int[] degree = new int[100];

    int[] link = new int[1010];
    int nl;

    void init() {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                map[i][j] = 0;
            }
            degree[i] = 0;
            visited[i] = 0;
        }
    }

    int dfs(int id) {
        int r = 0;
        //pw.println("T: " + id);
        for (int i = 1; i <= 50; i++ ) {
            if (map[id][i] > 0) {
                map[id][i]--;
                map[i][id]--;
                //pw.println("TT: " + i);
                r += dfs(i) + 1;
            }
        }

        link[nl++] = id;
        return r;
    }

    void run() throws Exception {
        int t = Integer.valueOf(br.readLine());
        int x=0, y=0;
        for (int i = 0; i < t; i++) {
            init();
            n = Integer.valueOf(br.readLine());
            for (int j = 0; j < n; j++) {
                String s = br.readLine();
                String[] sl = s.split(" ");
                x = Integer.valueOf(sl[0]);
                y = Integer.valueOf(sl[1]);
                map[x][y]++;
                map[y][x]++;
                degree[x]++;
                degree[y]++;
            }
            boolean ok = true;
            for (int j= 0; j <= 50; j++) {
                if (degree[j]%2==1) {
                    ok = false;
                    break;
                }
            }
            nl = 0;
            if (ok) {
                for (int j = 0; j <= 50; j++) {
                    if (degree[j]>0) {
                        dfs(j);
                        break;
                    }
                }
            }
            if (i>0) {
                System.out.println();
            }
            System.out.printf("Case #%d%n", i+1);
            if (nl == n+1) {
                for (int j = 0; j < nl-1; j++) {
                    System.out.printf("%d %d%n", link[j], link[j+1]);
                }
            } else {
                System.out.println("some beads may be lost");
            }
        }

    }

}

