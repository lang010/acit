/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10562
 *  UVa link: http://uva.onlinejudge.org/external/105/10562.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 12 19:26:42 2014
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

    String[] sl = new String[210];
    int n;

    int find(int id, int b, int e) {
        char c;
        for (int i = b; i < e && i < sl[id].length(); i++) {
            c = sl[id].charAt(i);
            if (c != ' ') {
                return i;
            }

        }
        return e;
    }

    int tree(int id, int w) {
        if (id >= n || w >= sl[id].length()) {
            return 0;
        }
        char c = sl[id].charAt(w);
        out.printf("%c(", c);
        if (id+3<n && w<sl[id+1].length() && sl[id+1].charAt(w) == '|') {
            id = id+2;
            int b = w, e = w+1;
            while (b>=0 && b<sl[id].length() && sl[id].charAt(b) == '-') {
                b--;
            }
            b++;
            while (e<=sl[id].length() && sl[id].charAt(e-1) == '-') {
                e++;
            }
            e--;
            id++;
            //out.printf("T: %d %d %d%n", b, e, id);
            w = find(id, b, e);
            while (w < e) {
                tree(id, w);
                w = find(id, w+1, e);
            }

        }

        out.printf(")");
        return 1;
    }

    void run() {
        int k = in.nextInt();
        in.nextLine();
        for (int i = 0; i < k; i++) {
            n = 0;
            while (true) {
                sl[n++] = in.nextLine();
                if ("#".equals(sl[n-1])) {
                    n--;
                    break;
                }
            }
            out.printf("(");
            tree(0, find(0, 0, sl[0].length()));
            out.println(")");
            out.flush();
        }

    }

}
