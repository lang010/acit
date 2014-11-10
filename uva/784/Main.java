/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 784
 *  UVa link: http://uva.onlinejudge.org/external/7/784.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 15 12:35:25 2014
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
    char[][] map = new char[100][100];
    int N;

    boolean isVal(int x, int y) {
        if (x<0 || y<0 || x>= N || y>= map[x][0]) {
            return false;
        }
        if (map[x][y] == ' ') {
            return true;
        }
        return false;
    }


    void dfs(int x, int y) {
        if (!isVal(x, y)) {
            return ;
        }
        map[x][y] = '#';
        dfs(x+1, y);
        dfs(x, y+1);
        dfs(x-1, y);
        dfs(x, y-1);
    }

    void run() {
        int cnt = in.nextInt();
        int x = 0, y = 0;
        String s;
        char c;
        in.nextLine();
        for (int i = 0; i < cnt; i++) {
            N = 0;
            while (true) {
                s = in.nextLine();
                if (s.charAt(0) == '_') {
                    break;
                }
                map[N][0] = (char) (s.length() + 1);
                for (int j = 0; j < s.length(); j++) {
                    c = s.charAt(j);
                    if (c == '*') {
                        x = N;
                        y = j+1;
                        c = ' ';
                    }
                    map[N][j+1] = c;
                }
                N++;
            }
            dfs(x, y);
            for (int j = 0; j < N; j++) {
                for (int k = 1; k < map[j][0]; k++) {
                    out.printf("%c", map[j][k]);
                }
                out.println();
            }
            out.println(s);
        }

    }

}
