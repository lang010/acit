/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 562
 *  UVa link: http://uva.onlinejudge.org/external/5/562.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Dec  5 13:17:40 2014
 */
import java.util.Scanner;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;

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

    int[] ls = new int[120];
    int[][] map = new int[120][500*120];
    int n = 0;

    void run() {
        int T = sc.nextInt();
        int s = 0;
        for (int k = 0; k < T; k++) {
            n = sc.nextInt();
            s = 0;
            for (int i = 0; i < n; i++) {
                ls[i] = sc.nextInt();
                s += ls[i];
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= s/2; j++) {
                    map[i][j] = map[i-1][j];
                    if (j>=ls[i-1] && map[i][j] < map[i-1][j-ls[i-1]] + ls[i-1]) {
                        map[i][j] = map[i-1][j-ls[i-1]] + ls[i-1];
                    }
                }
            }
            pw.println(s-map[n][s/2]*2);
        }

    }

}
