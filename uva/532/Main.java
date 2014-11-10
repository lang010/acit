/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 532
 *  UVa link: http://uva.onlinejudge.org/external/5/532.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 13 23:38:12 2014
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
    int L, R, C;
    int[][][] dung = new int[40][40][40];
    int[] dx = {1, 0, -1, 0, 0, 0};
    int[] dy = {0, 1, 0, -1, 0, 0};
    int[] dz = {0, 0, 0, 0, 1, -1};
    int[] qx = new int[27000];
    int[] qy = new int[27000];
    int[] qz = new int[27000];
    int b, e;

    boolean isVal(int x, int y, int z) {
        if (x < 0 || y < 0 || z < 0 || x >= L || y >= R || z >= C) {
            return false;
        }
        if (dung[x][y][z] != 0) {
            return false;
        }

        return true;
    }

    void run() {
        while (true) {
            int xx, x, yy, y, zz, z;
            xx = x = yy = y = zz = z = 0;
            L = in.nextInt();
            R = in.nextInt();
            C = in.nextInt();
            if (L == 0) {
                break;
            }
            for (int i = 0; i < L ; i++) {
                for (int j = 0; j < R; j++) {
                    String s = in.next();
                    for (int k = 0; k < C; k++) {
                        char c = s.charAt(k);
                        dung[i][j][k] = 0;
                        if (c == 'S') {
                            x = i;
                            y = j;
                            z = k;
                        } else if (c == 'E') {
                            xx = i;
                            yy = j;
                            zz = k;
                        } else if (c == '#') {
                            dung[i][j][k] = -1;
                        }
                    }
                }
            }
            qx[0] = x;
            qy[0] = y;
            qz[0] = z;
            dung[x][y][z] = 1;
            b = 0;
            e = 1;
            int nx, ny, nz;
            while (b < e) {
                x = qx[b];
                y = qy[b];
                z = qz[b];
                if (x == xx && y == yy && z == zz) {
                    break;
                }
                b++;
                //out.printf("TT: %d %d %d %d%n", x, y, z, b);
                for (int i = 0; i < 6; i++ ) {
                    nx = x + dx[i];
                    ny = y + dy[i];
                    nz = z + dz[i];
                    if (isVal(nx, ny, nz)) {
                        dung[nx][ny][nz] = dung[x][y][z] + 1;
                        qx[e] = nx;
                        qy[e] = ny;
                        qz[e] = nz;
                        e++;
                    }
                    //out.printf("T: %d %d %d%n", nx, ny, nz);
                    //out.flush();
                }
            }
            if (b < e) {
                out.printf("Escaped in %d minute(s).%n", dung[xx][yy][zz] - 1);
            } else {
                out.println("Trapped!");
            }
        }

    }

}
