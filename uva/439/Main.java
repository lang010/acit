/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 439
 *  UVa link: http://uva.onlinejudge.org/external/4/439.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 13 08:33:28 2014
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

    int[][] map = new int[8][8];
    int[] xl = new int[200];
    int[] yl = new int[200];
    int b, e;

    int[] dx = {1, 1, -1, -1, 2, 2, -2, -2};
    int[] dy = {2, -2, 2, -2, 1, -1, 1, -1};

    boolean isVal(int x, int y) {
        if (x < 0 || x >= 8 || y < 0 || y >= 8) {
            return false;
        }
        return true;
    }

    void run() {
        while (in.hasNext()) {
            String s1 = in.next();
            String s2 = in.next();
            int x1, x2, y1, y2, x, y;
            x1 = s1.charAt(0) - 'a';
            y1 = s1.charAt(1) - '1';
            x2 = s2.charAt(0) - 'a';
            y2 = s2.charAt(1) - '1';
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    map[i][j] = 0;
                }

            }
            map[x1][y1] = 1;
            xl[0] = x1;
            yl[0] = y1;
            b = 0;
            e = 1;
            while (b<e) {
                if (map[x2][y2] > 0) {
                    break;
                }
                x1 = xl[b];
                y1 = yl[b];
                b++;
                for (int i = 0; i < 8; i++) {
                    x = x1 + dx[i];
                    y = y1 + dy[i];
                    if (isVal(x, y) && map[x][y] == 0) {
                        map[x][y] = map[x1][y1]+1;
                        xl[e] = x;
                        yl[e] = y;
                        e++;
                    }
                }
            }
            out.printf("To get from %s to %s takes %d knight moves.%n", s1, s2, map[x2][y2]-1);

        }

    }

}
