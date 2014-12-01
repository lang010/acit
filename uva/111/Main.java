/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 111
 *  UVa link: http://uva.onlinejudge.org/external/1/111.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 30 18:34:12 2014
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

    int[][] map = new int[30][30];
    int[] ba = new int[30];
    int[] ls = new int[30];
    int n = 0;

    void run() {
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            ba[sc.nextInt()-1] = i+1;
        }
        while (sc.hasNextInt()) {
            for (int i = 1; i <= n; i++) {
                int x = sc.nextInt();
                ls[x-1] = i;
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (ba[j-1] == ls[i-1]) {
                        map[i][j] = map[i-1][j-1]+1;
                    } else {
                        map[i][j] = map[i][j-1] > map[i-1][j] ? map[i][j-1] : map[i-1][j];
                    }
                }
            }
            pw.println(map[n][n]);
        }

    }

}
