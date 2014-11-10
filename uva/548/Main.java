/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 548
 *  UVa link: http://uva.onlinejudge.org/external/5/548.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov  8 08:57:14 2014
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

    int[] ain = new int[10010];
    int[] apo = new int[10010];
    int sum = 0;
    int min = 0;
    int id = 0;

    int tree(int b, int e, int b1, int e1) {
        if (e<=b) {
            return 0;
        }

        if (e-b == 1) {
            sum += apo[b];
            if (min > sum) {
                min = sum;
                id = b;
            } else if (min == sum && apo[id] > apo[b]) {
                id = b;
            }

            sum -= apo[b];
            return 1;
        }
        sum += apo[e-1];
        int i;
        for (i = b1; i < e1-1; i++) {
            if (ain[i] == apo[e-1]) {
                break;
            }
        }
        i -= b1;
        tree(b, b+i, b1, b1+i);
        tree(b+i, e-1, b1+i+1, e1); 
        sum -= apo[e-1];
        return 1;
    }

    void run() {
        while (in.hasNext()) {
            String s1 = in.nextLine();
            String s2 = in.nextLine();
            String[] l1, l2;
            l1 = s1.split(" ");
            l2 = s2.split(" ");
            for (int i = 0; i < l1.length; i++) {
                ain[i] = Integer.valueOf(l1[i]);
                apo[i] = Integer.valueOf(l2[i]);
            }
            sum = 0;
            min = 1000000000;
            tree(0, l1.length, 0, l1.length);
            //out.printf("%d, sum %d, id %d%n", min, sum, id);
            out.println(apo[id]);
        }
    }

}
