/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10189
 *  UVa link: http://uva.onlinejudge.org/external/101/10189.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 19 22:05:40 2014
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

    int N = 0;
    int M = 0;
    int[][] map = new int[200][200];
    int[] dx = {1, 1, 1, -1, -1, -1, 0, 0 };
    int[] dy = {-1, 0, 1, -1, 0, 1, 1, -1 };

    void set(int x, int y) {
        int xx, yy;
        for (int i = 0; i < 8; i++) {
            xx = x + dx[i];
            yy = y + dy[i];
            if (xx>=0 && yy>=0 && xx < N && yy < M && map[xx][yy]>=0) {
                map[xx][yy]++;
            }

        }

    }

    void run() {
        int cnt = 1;
        while (true) {
            N = sc.nextInt();
            M = sc.nextInt();
            if (N == 0) {
                break;
            }

            for (int i = 0; i < N; i++) {
                String s = sc.next();
                for (int j = 0; j < M; j++) {
                    map[i][j] = 0;
                    if (s.charAt(j) == '*') {
                        map[i][j] = -1;
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] < 0) {
                        set(i, j);
                    }
                }
            }
            if (cnt>1) {
                pw.println();
            }

            pw.printf("Field #%d:%n", cnt++);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] < 0) {
                        pw.printf("*");
                    } else {
                        pw.printf("%d", map[i][j]);
                    }
                }
                pw.println();
            }

        }

    }

}
