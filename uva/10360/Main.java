/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10360
 *  UVa link: http://uva.onlinejudge.org/external/103/10360.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec  7 00:26:59 2014
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

    int[][] map = new int[1025][1025];
    int[][] tot = new int[1124][1124];
    int d = 0;

    void init() {
        for (int i = 0; i < 1025; i++) {
            for (int j = 0; j < 1025; j++) {
                map[i][j] = 0;
            }
        }
    }

    int cnt(int x, int y) {
        int x1 = x-d;
        int y1 = y-d;
        int x2 = x+d+1;
        int y2 = y+d+1;
        x1 = x1 >= 0 ? x1 : 0;
        y1 = y1 >= 0 ? y1 : 0;
        x2 = x2 <= 1025 ? x2 : 1025;
        y2 = y2 <= 1025 ? y2 : 1025;

        return tot[x2][y2] - tot[x1][y2] - tot[x2][y1] + tot[x1][y1];
    }

    void run() {
        int T = sc.nextInt();
        for (int k = 0; k < T; k++) {
            d = sc.nextInt();
            init();
            int m = sc.nextInt();
            for (int i = 0; i < m; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                map[x][y] = sc.nextInt();
            }
            for (int i = 0; i <= 1026; i++) {
                tot[i][0] = tot[0][i] = 0;
            }
            for (int i = 0; i < 1025; i++) {
                int tmp = 0;
                for (int j = 0; j < 1025; j++) {
                    tmp += map[i][j];
                    tot[i+1][j+1] = tot[i][j+1] + tmp;
                }
            }

            int max = 0;
            int maxI = 0, maxJ = 0;
            for (int i = 0; i < 1025; i++) {
                for (int j = 0; j < 1025; j++) {
                    int x = cnt(i, j);
                    if (x>max) {
                        max = x;
                        maxI = i;
                        maxJ = j;
                    }
                }
            }

            pw.printf("%d %d %d%n", maxI, maxJ, max);
        }
    }

}
