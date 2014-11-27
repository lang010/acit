/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 481
 *  UVa link: http://uva.onlinejudge.org/external/4/481.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 25 07:27:47 2014
 */

import java.util.Scanner;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;

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

    int[] ls = new int[200005];
    int n = 0;
    int[] minls = new int[200005];
    //int[] idls = new int[10000];
    int minN = 0;
    List<List<Integer>> idls = new ArrayList<List<Integer>>();

    void run() {
        int b,e;
        int m,x;
        while (sc.hasNextInt()) {
            x = sc.nextInt();
            ls[n++] = x;
            b = 0;
            e = minN - 1;
            while (b<=e) {
                m = (b+e)/2;
                if (minls[m] == x) {
                    b = m;
                    break;
                } else if (minls[m] > x) {
                    e = m-1;
                } else {
                    b = m+1;
                }
            }
            minls[b] = x;
            if (idls.size() < b+1) {
                idls.add(new ArrayList<Integer>());
            }
            idls.get(b).add(n-1);

            if (minN-1 < b) {
                minN = b+1;
            }
            //pw.println(minN);
        }
        e = minN-2;
        while (e>=0) {
            b = idls.get(e).size()-1;
            x = idls.get(e+1).get(idls.get(e+1).size()-1);
            while (x<idls.get(e).get(b)) {
                b--;
            }
            //pw.printf("T: %d %d %d %d%n", e, b, idls.get(e).size(), x);
            if (b < idls.get(e).size()-1) {
                b = idls.get(e).get(b);
                idls.get(e).add(b);
                minls[e] = ls[b];
            }
            e--;
        }

        pw.printf("%d%n-%n", minN);
        for (int i = 0; i < minN; i++) {
            pw.println(minls[i]);
        }

    }

}
