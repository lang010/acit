/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 108
 *  UVa link: http://uva.onlinejudge.org/external/1/108.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 21 08:15:02 2014
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
    int[][] map = new int[101][101];


    void run() {
        N = sc.nextInt();
        int x = 0;
        for (int i = 0; i < N; i++) {
            x = 0;
            for (int j = 0; j < N; j++) {
                x += sc.nextInt();
                map[i+1][j+1] = map[i][j+1] + x;
            }
        }
        int max = -1000000;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int ii = i; ii <= N; ii++) {
                    for (int jj = j; jj <= N; jj++) {
                        x = map[ii][jj] - map[i-1][jj] - map[ii][j-1] + map[i-1][j-1];
                        if (x > max) {
                            max = x;
                        }
                    }
                }
            }
        }
        pw.println(max);
    }

}
