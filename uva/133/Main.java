/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 133
 *  UVa link: http://uva.onlinejudge.org/external/1/133.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Oct 31 10:02:28 2014
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

    void run() {
        while(in.hasNext()) {
            int n = in.nextInt();
            int k = in.nextInt();
            int m = in.nextInt();
            if (n == 0)
                break;
            int[] ls = new int[n];
            for (int i = 0; i < n; i++)
                ls[i] = i+1;
            int cnt = 0;
            int l = -1;
            int lc = 0;
            int r = cnt;
            int rc = 0;
            while (cnt < n) {
                while (lc < k) {
                    l++;
                    if (l == n)
                        l = 0;
                    if (ls[l]>0) {
                        lc++;
                    }
                }
                while (rc < m) {
                    r--;
                    if (r<0)
                        r = n-1;
                    if (ls[r] > 0)
                        rc++;
                }
                if (cnt > 0)
                    out.printf(",");
                out.printf("%3d", ls[l]);
                ls[l] = 0;
                cnt++;
                lc = 0;
                if (cnt == n)
                    break;
                if (r != l) {
                    out.printf("%3d", ls[r]);
                    cnt++;
                }
                ls[r] = 0;
                rc = 0;
            }
            out.println();
        }
    }

}
