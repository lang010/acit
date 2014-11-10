/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 572
 *  UVa link: http://uva.onlinejudge.org/external/5/572.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 12 21:16:05 2014
 */

import java.util.Scanner;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

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

    int[][] map = new int[200][200];
    int cnt;
    int n, m;

    int color(int x, int y, int id) {
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return 0;
        }
        if (map[x][y] == 1) {
            map[x][y] = id;
            color(x+1, y, id);
            color(x+1, y+1, id);
            color(x+1, y-1, id);
            color(x-1, y, id);
            color(x-1, y+1, id);
            color(x-1, y-1, id);
            color(x, y+1, id);
            color(x, y-1, id);
            return id;
        }

        return 0;
    }

    void run() {

        while (true) {
            n = in.nextInt();
            m = in.nextInt();
            if (n == 0) {
                break;
            }
            cnt = 0;
            in.nextLine();
            for (int i = 0; i < n; i++) {
                String s = in.nextLine();
                for (int j = 0; j < m; j++) {
                    if (s.charAt(j) == '*') {
                        map[i][j] = 0;
                    } else {
                        map[i][j] = 1;
                    }
                }
            }
            int id = 2;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (color(i, j, id)>0) {
                        id++;
                    }
                }
            }
            out.println(id-2);
            
        }

    }

}
