/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10112
 *  UVa link: http://uva.onlinejudge.org/external/101/10112.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Oct 30 23:05:01 2014
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

    String[] t = new String[20];
    int[] x = new int[20];
    int[] y = new int[20];
    int[][][] z = new int[20][20][20];
    int n;

    int area(int i, int j, int k) {
        return Math.abs((y[k]-y[i])*(x[j]-x[i])-(y[j]-y[i])*(x[k]-x[i]));
    }

    void run() {
        while (in.hasNext()) {
            String s = in.nextLine();
            if ("0".equals(s))
                break;
            n = Integer.valueOf(s);
            for (int i = 0; i < n; i++) {
                s = in.nextLine();
                String[] ls = s.split(" ");
                t[i] = ls[0];
                x[i] = Integer.valueOf(ls[1]);
                y[i] = Integer.valueOf(ls[2]);
            }
            int max = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i+1; j < n; j++) {
                    for (int k = j+1; k < n; k++) {
                        int a = area(i, j, k);
                        if (a > max) {
                            boolean r = true;
                            for (int l = 0; l < n; l++) {
                                if (l == i || l == j || l == k)
                                    continue;
                                if (area(i, j, l) + area(i, l, k) + area(l, j, k) == a) {
                                    r = false;
                                    break;
                                }
                            }
                            if (r) {
                                max = a;
                                s = t[i] + t[j] + t[k];
                            }
                        }
                    }
                }
            }
            out.println(s);
        }
    }

}
