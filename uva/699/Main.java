/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 699
 *  UVa link: http://uva.onlinejudge.org/external/6/699.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 10 22:08:15 2014
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

    int[] ls = new int[2000];
    int d;
    int dl = 0;
    int id;

    void tree(int dx) {
        id++;
        int v = in.nextInt();
        if (v < 0) {
            return ;
        }
        d += dx;
        ls[d] += v;
        if (dl > d) {
            dl = d;
        }
        tree(-1);
        tree(1);
        d -= dx;
    }

    void run() {
        int k = 1;
        while (in.hasNext()) {
            d = 1000;
            dl = 1000;
            id = -1;
            tree(0);
            if (ls[dl] == 0) {
                break;
            }

            out.printf("Case %d:%n%d", k++, ls[dl++]);
            ls[dl-1] = 0;
            while (ls[dl]>0) {
                out.printf(" %d", ls[dl++]);
                ls[dl-1] = 0;
            }
            out.println("\n");
        }

    }

}
