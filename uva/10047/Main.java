/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10047
 *  UVa link: http://uva.onlinejudge.org/external/100/10047.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 15 22:24:15 2014
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

    int[][] map = new int[30][30];
    int[][][][] visited = new int[30][30][4][5];
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    int[] qx = new int[40000];
    int[] qy = new int[40000];
    int[] qs = new int[40000];
    int[] qd = new int[40000];
    int[] qt = new int[40000];
    int b, e;

    int N, M;

    boolean isVal(int x, int y, int d, int c) {
        if (x < 0 || y < 0 || x >= M || y >= N) {
            return false;
        }
        if (map[x][y] == 0 && visited[x][y][d][c] == 0) {
            return true;
        }
        return false;
    }

    void run() {
        int cnt = 1;
        int x, y, xx, yy;
        int d, s, t = 0;
        char c;
        x = y = xx = yy = 0;
        while (true) {
            M = in.nextInt();
            N = in.nextInt();
            if (M == 0) {
                break;
            }
            if (cnt>1) {
                out.println();
            }

            in.nextLine();
            for (int i = 0; i < M; i++) {
                String str = in.nextLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = 0;
                    c = str.charAt(j);
                    if (c == '#') {
                        map[i][j] = 1;
                    }
                    if (c == 'S') {
                        x = i;
                        y = j;
                    }
                    if (c == 'T') {
                        xx = i;
                        yy = j;
                    }
                    for (int k = 0; k < 4; k++) {
                        for (int l = 0; l < 5; l++) {
                            visited[i][j][k][l] = 0;
                        }
                    }
                }
            }
            qx[0] = x;
            qy[0] = y;
            qs[0] = 0;
            qd[0] = 0;
            qt[0] = 0;
            visited[x][y][0][0] = 1;
            b = 0; e = 1;
            while (b < e) {
                x = qx[b];
                y = qy[b];
                s = qs[b];
                d = qd[b];
                t = qt[b];
                if (x == xx && y == yy && s == 0) {
                    break;
                }
                b++;
                if (isVal(x, y, (d+1)%4, s)) {
                    qx[e] = x;
                    qy[e] = y;
                    qs[e] = s;
                    qd[e] = (d+1)%4;
                    qt[e] = t+1;
                    visited[x][y][(d+1)%4][s] = 1;
                    e++;
                }
                if (isVal(x, y, (d+3)%4, s)) {
                    qx[e] = x;
                    qy[e] = y;
                    qs[e] = s;
                    qd[e] = (d+3)%4;
                    qt[e] = t+1;
                    visited[x][y][(d+3)%4][s] = 1;
                    e++;
                }
                x += dx[d];
                y += dy[d];
                s = (s+1)%5;
                if (isVal(x, y, d, s)) {
                    qx[e] = x;
                    qy[e] = y;
                    qs[e] = s;
                    qd[e] = d;
                    qt[e] = t+1;
                    visited[x][y][d][s] = 1;
                    e++;
                }

            }
            out.printf("Case #%d%n", cnt++);
            if (b<e) {
                out.printf("minimum time = %d sec%n", t);
            } else {
                out.println("destination not reachable");
            }
        }

    }

}
