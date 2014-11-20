/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 674
 *  UVa link: http://uva.onlinejudge.org/external/6/674.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 19 23:13:46 2014
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

    int max = 7500;
    long[][] ls = new long[6][max];
    int[] dx = {1, 5, 10, 25, 50};
    void run() {
        for (int i = 0; i < max; i++) {
            ls[0][i] = 1;
        }
        for (int i = 1; i < 5; i++) {
            for (int j = 0; j < max; j++) {
                int id = j;
                ls[i][j] = 0;
                while (id>=0) {
                    ls[i][j] += ls[i-1][id];
                    id -= dx[i];
                }
            }

        }

        while (sc.hasNextInt()) {
            pw.println(ls[4][sc.nextInt()]);
        }

    }

}
