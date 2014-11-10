/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 196
 *  UVa link: http://uva.onlinejudge.org/external/1/196.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 16 00:28:38 2014
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

    int N = 0, M = 0;
    String[][] map = new String[20100][1200];
    int[][] val = new int[20100][1200];

    int cntY(String ys) {
        int r = 0;
        if (ys.length() == 1) {
            r = ys.charAt(0) - 'A';
        }
        if (ys.length() == 2) {
            r = (ys.charAt(0)-'A')*26 + ys.charAt(1) - 'A' + 26;
        }
        if (ys.length() == 3) {
            r = (ys.charAt(0)-'A')*26*26 + (ys.charAt(1)-'A')*26 + ys.charAt(2)-'A' + 26*26 + 26;
        }

        return r;
    }

    int cal(int x, int y) {
        //out.printf("%d, %d, %s%n", x, y, map[x][y]);
        //out.flush();
        if (map[x][y].charAt(0) != '=') {
            if (map[x][y] != " ") {
                val[x][y] = Integer.valueOf(map[x][y]);
                map[x][y] = " ";
            }

            return val[x][y];
        }
        int r = 0;
        int xx = 0;
        String ys = "";
        char c;
        for (int i = 1; i < map[x][y].length(); i++) {
            c = map[x][y].charAt(i);
            if (c>= 'A' && c <= 'Z') {
                ys += c;
            }
            if (c >= '0' && c <= '9') {
                xx = xx*10 + c - '0';
            }
            if (c == '+') {
                r += cal(xx-1, cntY(ys));
                xx = 0;
                ys = "";
            }
        }
        r += cal(xx-1, cntY(ys));

        map[x][y] = " ";
        val[x][y] = r;
        return r;
    }

    void run() {
        int cnt = in.nextInt();
        while (cnt-- > 0) {
            N = in.nextInt();
            M = in.nextInt();
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = in.next();
                }
            }
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (j>0) {
                        out.printf(" ");
                    }
                    out.printf("%d", cal(i, j));
                }
                out.println();
            }

        }


    }

}
