/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 291
 *  UVa link: http://uva.onlinejudge.org/external/2/291.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 29 15:01:00 2014
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

    int[][] map = {
        { 0, 1, 1, 0, 1 },
        { 1, 0, 1, 0, 1 },
        { 1, 1, 0, 1, 1 },
        { 0, 0, 1, 0, 1 },
        { 1, 1, 1, 1, 0 },
    };

    int[] ls = new int[10];

    void dfs(int d, int id) {
        ls[d] = id+1;
        if (d == 8) {
            for (int i = 0; i < 9; i++) {
                pw.printf("%d", ls[i]);
            }
            pw.println();
            return ;
        }
        for (int i = 0; i < 5; i++) {
            if (map[id][i] > 0) {
                map[id][i] = map[i][id] = 0;
                dfs(d+1, i);
                map[id][i] = map[i][id] = 1;
            }
        }
        return ;
    }

    void run() {
        dfs(0, 0);
    }

}
