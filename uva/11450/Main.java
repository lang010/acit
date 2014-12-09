/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 11450
 *  UVa link: http://uva.onlinejudge.org/external/114/11450.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec  8 11:21:33 2014
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

    int[][] map = new int[30][250];
    int M = 0;
    int C = 0;
    int N = 0;

    void run() {
        N = sc.nextInt();
        for (int k = 0; k < N; k++) {
            M = sc.nextInt();
            C = sc.nextInt();
            for (int i = 1; i <= C; i++) {
                int n = sc.nextInt();
                for (int j = 0; j <= M; j++) {
                    map[i][j] = -1;
                }

                for (int j = 0; j < n; j++) {
                    int T = sc.nextInt();
                    for (int t = T ; t <= M; t++) {
                        if (map[i-1][t-T] < 0) {
                            continue;
                        }
                        if (map[i-1][t-T] + T > map[i][t]) {
                            map[i][t] = map[i-1][t-T] + T;
                        }
                    }
                }
            }
            if (map[C][M] > 0) {
                pw.println(map[C][M]);
            } else {
                pw.println("no solution");
            }
        }

    }

}
