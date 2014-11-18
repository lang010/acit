/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 10098
 *  UVa link: http://uva.onlinejudge.org/external/100/10098.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 18 22:14:30 2014
 */

import java.util.Scanner;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

    int len = 0;
    char[] ls = null;
    char[] ncs = new char[20];
    int[] v = new int[20];
    Set<String> set = new HashSet<String>();

    void dfs(int d) {
        if (d == len) {
            String s = new String(ncs, 0, len);
            if (set.contains(s)) {
                return ;
            }
            set.add(s);
            pw.println(s);
            return ;
        }
        for (int i = 0; i < len; i++) {
            if (v[i] == 0) {
                v[i] = 1;
                ncs[d] = ls[i];
                dfs(d+1);
                v[i] = 0;
            }
        }
        return ;
    }

    void run() {
        int T = sc.nextInt();
        for (int k = 0; k < T; k++) {
            String s = sc.next();
            ls = s.toCharArray();
            Arrays.sort(ls);
            len = ls.length;
            for (int i = 0; i < len; i++ ) {
                v[i] = 0;
            }
            set.clear();
            dfs(0);
            pw.println();
        }

    }

}
