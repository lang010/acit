/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10003
 *  UVa link: http://uva.onlinejudge.org/external/100/10003.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 22 21:37:28 2014
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

    int n = 0;
    int len = 0;
    int[] ls = new int[100];
    int[][] map = null;

    int cnt(int b, int e) {
        if (e - b <= 1) {
            return 0;
        }
        if (map[b][e]>0) {
            return map[b][e];
        }

        int ans = 0;
        int min = 1000000;
        for (int i = b+1; i < e; i++) {
            ans = cnt(b, i) + cnt(i, e);
            if (min > ans) {
                min = ans;
            }
        }
        map[b][e] = min + ls[e] - ls[b];
        //pw.printf("%d %d %d %d%n", b, e, min, map[b][e]);

        return map[b][e];
    }

    void run() {
        while (true) {
            len = sc.nextInt();
            if (len == 0) {
                break;
            }
            map = new int[100][100];
            n = sc.nextInt();
            ls[0] = 0;
            for (int i = 0; i < n; i++) {
                ls[i+1] = sc.nextInt();
            }
            n++;
            ls[n] = len;
            pw.printf("The minimum cutting is %d.%n", cnt(0, n));
        }
    }

}
