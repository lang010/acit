/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 657
 *  UVa link: http://uva.onlinejudge.org/external/6/657.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 15 12:06:53 2014
 */

import java.util.Scanner;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;

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

    int[][] map = new int[200][200];
    int W, H;
    int[] ls = new int[200];
    int N;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    int[] qx = new int[40000];
    int[] qy = new int[40000];
    int b, e;

    boolean isVal(int x, int y) {
        if (x < 0 || y < 0 || x >= W || y >= H) {
            return false;
        }
        if (map[x][y] > 0) {
            return true;
        }
        return false;
    }

    int num(int x, int y) {
        if (!isVal(x, y)) {
            return 0;
        }
        int r = 0;
        if (map[x][y] == 2) {
            r = 1;
            b = 0;
            e = 1;
            qx[b] = x;
            qy[b] = y;
            map[x][y] = -map[x][y];
            int xx, yy;
            while (b < e) {
                x = qx[b];
                y = qy[b];
                b++;
                for (int i = 0; i < 4; i++) {
                    xx = x + dx[i];
                    yy = y + dy[i];
                    if (isVal(xx, yy) && map[xx][yy] == 2) {
                        qx[e] = xx;
                        qy[e] = yy;
                        map[xx][yy] = -map[xx][yy];
                        e++;
                    }
                }
            }

            for (int i = 0; i < e; i++) {
                for (int j = 0; j < 4; j++) {
                    xx = qx[i] + dx[j];
                    yy = qy[i] + dy[j];
                    //out.printf("TT: %d %d -> %d %d%n", xx, yy, qx[i], qy[i]);
                    //out.flush();
                    r += num(xx, yy);
                }
            }
            return r;
        }
        map[x][y] = -map[x][y];

        for (int i = 0; i < 4; i++) {
            r += num(x + dx[i], y + dy[i]);
        }
        return r;
    }

    void run() {
        int cnt = 1;
        while (in.hasNext()) {
            H = in.nextInt();
            W = in.nextInt();
            if (W == 0) {
                break;
            }
            for (int i = 0; i < W; i++) {
                String s = in.next();
                for (int j = 0; j < H; j++) {
                    map[i][j] = 0;
                    //out.printf("TT: %s%n", s);
                    //out.flush();
                    char c = s.charAt(j);
                    if (c == '*') {
                        map[i][j] = 1;
                    } else if (c == 'X') {
                        map[i][j] = 2;
                    }
                }
            }
            int r = 0;
            N = 0;
            for (int i = 0; i < W; i++ ) {
                for (int j = 0; j < H; j++) {
                    r = num(i, j);
                    if (r > 0) {
                        ls[N++] = r;
                    }
                }
            }
            if (N == 0) {
                N++;
                ls[0] = 0;
            }
            out.println("Throw " + cnt++);
            Arrays.sort(ls, 0, N);
            for (int i = 0; i < N; i++) {
                if (i>0) {
                    out.printf(" ");
                }
                out.printf("%d", ls[i]);
            }
            out.println("\n");
        }


    }

}
