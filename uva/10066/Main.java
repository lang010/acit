/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10066
 *  UVa link: http://uva.onlinejudge.org/external/100/10066.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec  8 12:02:23 2014
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

    int[][] map = new int[150][150];
    int[] l1 = new int[150];
    int[] l2 = new int[150];

    void run() {
        int cnt = 1;
        while (true) {

            int n = sc.nextInt();
            int m = sc.nextInt();
            if (n == 0 && m == 0) {
                break;
            }
            for (int i = 1; i <= n; i++) {
                l1[i] = sc.nextInt();
            }
            for (int i = 1; i <= m; i++) {
                l2[i] = sc.nextInt();
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    map[i][j] = Math.max(map[i-1][j], map[i][j-1]);
                    if (l1[i] == l2[j]) {
                        map[i][j] = Math.max(map[i][j], map[i-1][j-1]+1);
                    }

                }
            }
            pw.printf("Twin Towers #%d%n", cnt++);
            pw.printf("Number of Tiles : %d%n%n", map[n][m]);
        }

    }

}
