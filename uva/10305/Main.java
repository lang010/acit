/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10305
 *  UVa link: http://uva.onlinejudge.org/external/103/10305.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 16 10:59:02 2014
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

    int[][] map = new int[200][200];
    int cnt = 0;
    int N;
    int M;

    void initMap() {
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                map[i][j] = 0;
            }
        }
    }

    int doTask(int id) {
        if (map[id][0] != 0) {
            return 0;
        }
        map[id][0] = -1;
        if (cnt > 0) {
            pw.printf(" ");
        }
        pw.printf("%d", id);
        //pw.flush();
        for (int i = 1; i < N + 1; i++) {
            if (map[id][i] > 0) {
                map[i][0]--;
            }
        }

        return 1;
    }

    void run() {
        int a,b;
        while (true) {
            N = sc.nextInt();
            M = sc.nextInt();
            if (N == 0) {
                break;
            }

            initMap();
            for (int i = 0; i < M; i++) {
                a = sc.nextInt();
                b = sc.nextInt();
                map[a][b] = 1;
                map[b][0]++;
            }
            cnt = 0;
            while (cnt < N) {
                for (int i = 0; i < N; i++) {
                    cnt += doTask(i+1);
                }
            }
            pw.println();
        }

    }

}
