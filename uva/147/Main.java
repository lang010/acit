/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 147
 *  UVa link: http://uva.onlinejudge.org/external/1/147.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 30 15:35:48 2014
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

    int[] val = { 1, 2, 4, 10, 20, 40, 100, 200, 400, 1000, 2000 };
    long[][] map = new long[11][6010];
    int sum = 0;
    {
        for (int i = 0; i < 6010; i++) {
            map[0][i] = 1;
        }
    }

    void run() {
        long t = 0;
        for (int i = 1; i < val.length; i++) {
            for (int j = 0; j <= 6000; j++) {
                int ss = j;
                t = 0;
                while (ss>=0) {
                    t += map[i-1][ss];
                    ss -= val[i];
                }

                map[i][j] = t;
            }

        }
        while (true) {
            String s = sc.next();
            if ("0.00".equals(s)) {
                break;
            }
            double v = Double.valueOf(s);
            sum = (int) (v * 20 + 0.5);
            pw.printf("%6.2f%17d%n", v, map[10][sum]);
        }

    }

}
