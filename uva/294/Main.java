/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem 294
 *  UVa link: http://uva.onlinejudge.org/external/2/294.html
 *
 *  @Authur Liang Li <ll@lianglee.org>
 *  @Date Nov 30 14:18:10 2014
 */

import java.util.Scanner;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

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

    int max = (int) Math.sqrt(1000000000);
    int[] pl = new int[4000];
    int pn = 0;
    {
        int t = 2;
        int f = 0;
        while (t <= max+100 && pn < max) {
            f = 1;
            for (int i = 0; i < pn; i++) {
                if (t%pl[i] == 0) {
                    f = 0;
                    break;
                }
            }
            if (f == 1) {
                pl[pn++] = t;
            }
            t++;
        }
        /*
        for (int i = 0; i < pn; i++) {
            pw.printf("%d ", pl[i]);
        }
        pw.printf("%n%d %d%n", t, pn);
        */
    }

    int cnt(int x) {
        int ans = 1;
        int n = 0;
        int t = 0;
        while (x>1 && n < pn) {
            if (x%pl[n] == 0) {
                t++;
                x /= pl[n];
            } else {
                n++;
                if (t>0) {
                    ans *= t+1;
                    t = 0;
                }
            }
        }
        if (x>1) {
            ans *= 2;
        } else {
            ans *= t+1;
        }


        return ans;
    }

    void run() {
        int T = sc.nextInt();
        for (int k = 0; k < T; k++) {
            int l = sc.nextInt();
            int h = sc.nextInt();
            int t, p, d;
            p = l;
            d = cnt(l);
            for (int i = l+1; i <= h; i++) {
                t = cnt(i);
                if (t>d) {
                    d = t;
                    p = i;
                }
            }
            pw.printf("Between %d and %d, %d has a maximum of %d divisors.%n", l, h, p, d);
        }

    }
}
