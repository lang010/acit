/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 297
 *  UVa link: http://uva.onlinejudge.org/external/2/297.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 11 10:24:21 2014
 */

import java.util.Scanner;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.File;

public class Main {
    Scanner in = new Scanner(System.in, "ISO-8859-1");
    PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
    public Main() throws Exception {
    }

    public static void main(String[] args) throws Exception {
	Main m = new Main();
	m.run();
	m.release();
    }
    void release() {
	in.close();
	out.close();
    }

    int[][] map = new int[32][32];
    int[] dw = new int[10];
    int id;
    String s;

    int color(int d) {
        int n;
        int i = 0, j = 0;
        int r = 0;
        for (int k = 0; k < d; k++) {
            n = 16/(1<<k);
            i += (dw[k]%2) * n;
            j += (dw[k]/2) * n;
        }
        n = 32/(1<<d);
        //out.printf("T: %d, %d, %d%n", i, j, n);
        for (int k = 0; k < n; k++) {
            for (int l = 0; l < n; l++) {
                map[i+k][j+l] = 1;
            }
        }

        return r;
    }

    int tree(int d) {
        id++;
        char c = s.charAt(id);
        if (c == 'p') {
            for (int i = 0; i < 4; i++) {
                dw[d] = i;
                tree(d+1);
            }
            return 1;
        }
        if (c == 'f') {
            color(d);
        }
        
        return 0;
    }

    int cnt() {
        int c = 0;
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < 32; j++) {
                if (map[i][j] > 0) {
                    c++;
                    map[i][j] = 0;
                }
            }
        }

        return c;
    }

    void run() {
        int n = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            s = in.nextLine();
            id = -1;
            tree(0);
            s = in.nextLine();
            id = -1;
            tree(0);
            out.printf("There are %d black pixels.%n", cnt());
        }

    }

}
