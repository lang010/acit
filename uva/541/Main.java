/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 541
 *  UVa link: http://uva.onlinejudge.org/external/5/541.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 29 23:30:14 2014
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

    void run() {
        int n = 0;
        int[][] map = new int[120][120];
        while (true) {
            n = sc.nextInt();
            if (n == 0) {
                break;
            }
            for (int i = 0; i < n+1; i++) {
                map[i][n] = map[n][i] = 0;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = sc.nextInt();
                    map[n][j] += map[i][j];
                    map[i][n] += map[i][j];
                }
            }
            int oddx=0, oddy=0;
            int oxCnt = 0, oyCnt = 0;
            for (int i = 0; i < n; i++) {
                if (map[n][i]%2 == 1) {
                    oyCnt++;
                    oddy = i;
                }
                if (map[i][n]%2 == 1) {
                    oxCnt++;
                    oddx = i;
                }
            }
            if (oxCnt == 0 && oyCnt == 0) {
                pw.println("OK");
            } else if (oxCnt == 1 && oyCnt == 1) {
                pw.printf("Change bit (%d,%d)%n", oddx+1, oddy+1);
            } else {
                pw.println("Corrupt");
            }
        }

    }

}
