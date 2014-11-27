/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 459
 *  UVa link: http://uva.onlinejudge.org/external/4/459.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 28 19:50:01 2014
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

    int[][] map = new int[50][50];
    int n = 0;
    int[] vis = new int[50];

    int dfs(int id) {
        if (vis[id] != 0) {
            return 0;
        }
        vis[id] = 1;
        for (int i = 0; i < n; i++) {
            if (map[id][i]>0) {
                dfs(i);
            }
        }
        return 1;
    }

    void run() {
        int T = sc.nextInt();
        for (int k = 0; k < T; k++) {
            int sum = 0;
            if (k>0) {
                pw.println();
            }

            n = sc.next().charAt(0) - 'A' + 1;
            sc.nextLine();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = 0;
                }
                vis[i] = 0;
            }

            while (sc.hasNextLine()) {
                String s = sc.nextLine();
                if ("".equals(s)) {
                    break;
                }
                int x = s.charAt(0) - 'A';
                int y = s.charAt(1) - 'A';
                map[x][y] = map[y][x] = 1;
            }
            for (int i = 0; i < n; i++) {
                sum += dfs(i);
            }
            pw.println(sum);
        }

    }

}
