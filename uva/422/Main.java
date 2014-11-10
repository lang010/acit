/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 422
 *  UVa link: http://uva.onlinejudge.org/external/4/422.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov  2 16:04:18 2014
 */
/**
 * Solution for uva 422
 *
 * @author <a href="mailto:ll@lianglee.org">Liang Li</a>
 * @version 1.0
 */

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

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

    int n;
    char[][] mat = new char[150][150];
    String str = null;
    int x,y;

    boolean check(int dx, int dy) {
        int nn = str.length();
        int xx=0, yy=0;
        for (int i = 0; i < nn; i++) {
            xx = i*dx + x;
            yy = i*dy + y;

            if (xx < n && xx >= 0 && yy < n && yy >= 0) {
                if (mat[xx][yy] != str.charAt(i)) {
                    return false;
                }
            } else
                return false;
        }
        out.printf("%d,%d %d,%d%n", x+1, y+1, xx+1, yy+1);

        return true;
    }

    void run() {
        n = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            for (int j = 0; j < n; j++) {
                mat[i][j] = s.charAt(j);
            }
        }
        while (in.hasNext()) {
            str = in.nextLine();
            if ("0".equals(str)) {
                break;
            }
            boolean t = false;
            if (str.length() <= n) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        x = i;
                        y = j;
                        if (check(1,0) || check(-1, 0)
                            || check(0,1) || check(0, -1)
                            || check(1,1) || check(1,-1)
                            || check(-1, -1) || check(-1, 1)) {
                            t = true;
                            break;
                        }
                    }
                    if (t) {
                        break;
                    }
                }

            }
            if (!t) {
                out.println("Not found");
            }
        }

    }

}
